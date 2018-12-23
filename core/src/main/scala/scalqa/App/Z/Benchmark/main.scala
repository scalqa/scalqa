package scalqa; package App; package Z; package Benchmark

private[App] object main {

  def apply[A: Numeric](targets: Idx[(String, () => A)], trialCount: Int, trialDuration: Duration, gcPause: Duration) = {

    // testCount and testDuration within single trial
    val (testCount, testDuration) = {
      def duration(runs: Int) = (trialDuration - (gcPause * runs)) / targets.size / runs
      val v = 1.allUp.find(duration(_) < 100.Millis)
      (v, duration(v))
    }

    val about = "Duration " + trialDuration + " (" + targets.size + " targets each run " + testCount + " times for " + testDuration + ")"

    def printOut(l: Idx[Result]) = {
      l.all.map(_.count).maxOpt.apply(v => l.all.apply(_.maxCount = v))
      l.all.map(_.memory).maxOpt.apply(v => l.all.foreach(_.maxMemory = v))
      l.all.toText.lp
    }

    "\nWarm Up Run " + trialDuration lp

    printOut(trial(targets, 1, trialDuration / targets.size, 10.Millis).I(_.all(_.memory = \/)))

    val total = (1 <> trialCount).all
      .peek("\nTrial: " + _ + " (of " + trialCount + ").   " + about lp)
      .map(_ => trial(targets, testCount, testDuration, gcPause))
      .peek(printOut)
      .reduce(_.all.zip(_).map(_.to(_ + _)).to[Idx])

    "******************************************************************************\n".lp
    "Final Result.  Total Duration " + (trialDuration * trialCount) lp

    printOut(total)

    "******************************************************************************\n".lp
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
