package scalqa; package j; package util; package benchmark; package z; import language.implicitConversions

object execute:

  def apply[A](targets: ><[(String, () => A)], repeated: Int=1,  trialCount: Int = 4, trialDuration: Time.Length = 3.Seconds, verbose: Boolean = true)(using Opt[Math[A]]) =

    val (slotCount, slotDuration) = setup(trialDuration, targets, repeated)

    if(slotCount == 0) J.illegalArgument("The targets take too much time to execute, cannot setup tests within given duration:" +- trialDuration)

    def printPack(l: ><[Result]) =
      l.~.map(_.opsPerSec    ).max.self_^(v => l.~.foreach(_.maxOpsPerSec     = v))
      l.~.map(_.memoryAverage).max.self_^(v => l.~.foreach(_.maxMemoryAverage = v))
      println(l.~.toText)

    def run(tag: String, tag2: Opt[String] = \/): ><[Result] =
      if (verbose) println(tag + " Length is about " + trialDuration.tag ++ tag2)
      runTrial(targets, repeated, slotCount, slotDuration).^(l => if (verbose) printPack(l))

    run("Warm Up Run.", "\n(Run in " + slotCount * targets.size + " time slots of" +- slotDuration + " each)")

    val rslt = (1 <> trialCount).~
      .map(v => run("\nTrial: " + v + " (of " + trialCount + ")."))
      .reduce(_.~.zip(_).map(_ + _).><)

    if (verbose) println("\n" + "*" * 50 + "\nFinal Result. Total length is about" +- trialDuration * trialCount)

    printPack(rslt)

    if (verbose) println("*" * 50 + '\n')


  // --------------------------------------------------------------------------------------------------------------
  private def setup[A](totalDuration: Time.Length, targets: ><[(String, () => A)], repeated: Int): (Int, Time.Length) =
    def maxTargetDuration: Time.Length = targets.~.map(t => {val nt = System.nanoTime; t._2(); (System.nanoTime - nt).Nanos}).max * targets.size

    (1 <> 5).~.map(_ => maxTargetDuration).min /* goodTestDuration */ match
      case v if v * 2              >= totalDuration => (1, totalDuration / targets.size)
      case v if v * 50 / repeated  < totalDuration  => (50 / repeated, totalDuration / 50 / targets.size * repeated)
      case v                                        => ((totalDuration.nanosTotal / v.nanosTotal / targets.size).Int, v)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
