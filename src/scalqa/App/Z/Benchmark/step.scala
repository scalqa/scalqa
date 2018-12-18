package scalqa; package App; package Z; package Benchmark

private[App] object step {

  def apply[A: Numeric](targets: Idx[(String, () => A)], runCnt: Int, runLen: Duration, GcPause: Duration): Idx[Result] =
    runCnt.all
      .peek(_ => {
        App.Memory.gc;
        App.pause(GcPause)
      })
      .flatMap(j => targets.size.all.map(i => runSingleTarget(i, targets(i), runLen)))
      .sortBy(_.id)
      .groupBy(_.id)
      .map(_.reduce(_ + _))
      .to[Idx]

  private def runSingleTarget[A](id: Int, trgt: (String, () => A), len: Duration)(implicit n: Numeric[A]): Result = {
    val mem = App.Memory.used
    val end = Time.now + len
    var count = 0
    var value: Long = \/
    while (Time.now < end) {
      count += 1;
      value += n.toLong(trgt._2())
    }
    new Result(id, trgt._1, count, if (count == 0) \/ else (App.Memory.used - mem) / count, value)
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
