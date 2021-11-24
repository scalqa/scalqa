package scalqa; package j; package util; package benchmark; package z; import language.implicitConversions

object execute:

  def apply[A](targets: Pack[(String, () => A)], repeated: Int=1,  trialCount: Int = 4, trialLengthOpt: Time.Length.Opt = \/, verbose: Boolean = true)(using Opt[Numeric[A]]) =

    val setup = Setup(trialLengthOpt, targets, repeated)

    def printResults(l: Pack[Result]) =
      l.stream.map(_.opsPerSec    ).max.self(v => l.stream.foreach(_.maxOpsPerSec     = v))
      l.stream.map(_.memoryAverage).max.self(v => l.stream.foreach(_.maxMemoryAverage = v))
      println(l.stream.toText)

    def run(tag: String, tag2: Opt[String] = \/): Pack[Result] =
      if (verbose) println(tag + " Time length is about " + setup.totalLength.tag +? tag2)
      runTrial(targets, repeated, setup.slotCount, setup.slotLength).self(l => if (verbose) printResults(l))

    run("Warm Up Run.", "\n(Run in " + setup.slotCount + " time slots of" +- setup.slotLength + " each)")

    val rslt = (1 <> trialCount).stream
      .map(v => run("\nTrial: " + v + " (of " + trialCount + ")."))
      .reduce(_.stream.zip(_).map(_ + _).pack)

    if (verbose) println("\n" + "*" * 50 + "\nFinal Result. Total length is about" +- setup.totalLength * trialCount)

    printResults(rslt)

    if (verbose) println("*" * 50 + '\n')

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
