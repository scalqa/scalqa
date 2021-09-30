package scalqa; package j; package util; package benchmark; package z; import language.implicitConversions

object execute:

  def apply[A](targets: ><[(String, () => A)], repeated: Int=1,  trialCount: Int = 4, trialLengthOpt: Time.Length.Opt = \/, verbose: Boolean = true)(using Opt[Numeric[A]]) =

    val setup = Setup(trialLengthOpt, targets, repeated)

    def printResults(l: ><[Result]) =
      l.~.map(_.opsPerSec    ).max.self_^(v => l.~.foreach(_.maxOpsPerSec     = v))
      l.~.map(_.memoryAverage).max.self_^(v => l.~.foreach(_.maxMemoryAverage = v))
      println(l.~.toText)

    def run(tag: String, tag2: Opt[String] = \/): ><[Result] =
      if (verbose) println(tag + " Time length is about " + setup.totalLength.tag +? tag2)
      runTrial(targets, repeated, setup.slotCount, setup.slotLength).^(l => if (verbose) printResults(l))

    run("Warm Up Run.", "\n(Run in " + setup.slotCount + " time slots of" +- setup.slotLength + " each)")

    val rslt = (1 <> trialCount).~
      .map(v => run("\nTrial: " + v + " (of " + trialCount + ")."))
      .reduce(_.~.zip(_).map(_ + _).><)

    if (verbose) println("\n" + "*" * 50 + "\nFinal Result. Total length is about" +- setup.totalLength * trialCount)

    printResults(rslt)

    if (verbose) println("*" * 50 + '\n')

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
