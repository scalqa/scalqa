package scalqa; package App; package Z; package Benchmark

private[App] object apply {

  def apply[A: Numeric](targets: Idx[(String, () => A)], steps: Int, stepLength: Duration, GcPause: Duration) {

    def calcLen(runs: Int) = (stepLength - (GcPause * runs)) / targets.size / runs

    val cnt = 1.allUp.find(calcLen(_) < 100.Millis)

    val len = calcLen(cnt)

    val about = "Duration " + stepLength + " (" + targets.size + " targets each run " + cnt + " times for " + len + ")"

    def printOut(l: Idx[Result]) {
      l.all.map(_.count).maxOpt.apply(v => l.all.apply(_.maxCount = v))
      l.all.map(_.memory).maxOpt.apply(v => l.all.foreach(_.maxMemory = v))
      l.all.toText.lp
    }

    "\nWarm Up Run " + stepLength lp

    printOut(step(targets, 1, stepLength / targets.size, 10.Millis).I(_.all(_.memory = \/)))

    val total = (1 <> steps).all
      .peek("\nStep: " + _ + " (of " + steps + ").   " + about lp)
      .map(_ => step(targets, cnt, len, GcPause))
      .peek(printOut)
      .reduce(_.all.zip(_).map(_.to(_ + _)).to[Idx])

    "******************************************************************************\n".lp
    "Final Result.  Total Duration " + (stepLength * steps) lp

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
