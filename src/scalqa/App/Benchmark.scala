package scalqa; package App

object Benchmark {

  def apply(targets: (String, () => Int)*) { apply(10, 2.Seconds, targets: _*) }

  def apply(runCount: Int, len: Time.Length, targets: (String, () => Int)*) {
    val GcPause = 10.Millis
    val trgts = targets.all.as[Index]
    var runLen: Time.Length = \/
    var runCnt = trgts.size + 1;
    do {
      runCnt *= 2
      runLen = (len - (runCnt * GcPause).Millis) / trgts.size / runCnt
    } while (runLen > 50.Millis)

    def runTest: Index[Result] = (0 <>> (runCnt * trgts.size)).all
      .map(j => {
        val id = j % trgts.size
        if (j % (trgts.size + 1) == 0) { App.Memory.gc; Pause(GcPause) }
        val memBefore = App.Memory.used; val endTime: Time = Time.get + runLen; var count, value = 0L;
        while (Time.get < endTime) { count += 1; value += trgts(id)._2() }
        new Result(id, trgts(id)._1, count, if (count == 0) 0 else (App.Memory.used - memBefore) / count, value)
      })
      .sortBy(_.id).groupBy(_.id).map(a => a.fold(a.pumpOpt(EVERY).value, _ + _)).as[Index]

    def printOut(l: Index[Result]) {
      l.all.map(_.count).maxOpt.apply(v => l.all(_.baseCnt = v))
      l.all.map(_.memory).maxOpt.apply(v => l.all(_.baseMem = v))
      l.all.tp
    }

    val details = "   (" + trgts.size + " targets each run " + runCnt + " times for " + runLen + ")"
    Print.ln("\nWarm Up Run. Duration ", len, details)
    printOut(runTest)

    (1 <> runCount).all
      .peek(Print.ln("\nStart: ", _, " (of ", runCount, ")  Duration ", len, details))
      .swap(runTest)
      .peek(printOut)
      .foldOpt(_.all.zip(_).map(_.to(_ + _)).as[Index])
      .run(Print.ln("\nGRAND TOTAL"))
      .apply(printOut)
  }

  // *****************************************************************************************************************************
  private class Result(val id: Int, val label: String, val count: Long, val memory: Long, val valueSum: Long, var baseCnt: Long = 0, var baseMem: Long = 0) extends Able.Info {

    def +(that: Result) = new Result(id, label, this.count + that.count, (this.memory + that.memory) / 2, this.valueSum + that.valueSum, this.baseCnt + that.baseCnt, (this.baseMem + that.baseMem) / 2)

    protected def info = \/.info ~ ("Num", id + 1) ~ ("Target", label) ~ ("Run Count", count.brief) ~ ("%", Percent.getScaled(count, baseCnt).round(0).toInt) ~
      ("Memory", memory.brief + "b") ~ ("%", Percent.getScaled(memory, baseMem).round(0).toInt) ~ ("Control Value Avg", if (count == 0) 0 else valueSum / count)
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @object Benchmark ->
 *
 *     [[Benchmark]] is a simple comparison testing tool
 *
 *     With today JVM technology, it is hard to get absolute performance data
 *
 *     [[Benchmark]] allows to run several targets side by side, comparing their performance against each other
 *
 *     The result presents three values:
 *
 *       - 'Run count' is the number of times the target executed. The time frame is equal for all targets
 *       - 'Memory' is the average memory increase for several executions.
 *          This is even less precise measurement, however for side by side comparison is somewhat valuable
 *       - 'Control Value Avg' is the average of target returns.
 *         This can be used for validity check. In best case, all targets should arrive to the same value in different ways
 *
 *      @example
 *      {{{
 *          // Test Int Plus vs. Long Plus vs. Float Plus
 *         var int  = 0
 *         var long = 0L
 *         var float = 0F
 *
 *         App.Benchmark(100, 1.Second,
 *             ("Int  plus ", () => { int   += 1;  0 }),
 *             ("Long plus ", () => { long  += 1L; 0 }),
 *             ("Float plus", () => { float += 1F; 0 }))
 *
 *         // Output end
 *
 *         GRAND TOTAL
 *         --- ----------- --------- --- ------ --- -----------------
 *         Num Target      Run Count %   Memory %   Control Value Avg
 *         --- ----------- --------- --- ------ --- -----------------
 *         1   Int  plus   243.9m    100 137b   96  0
 *         2   Long plus   239.8m    98  142b   100 0
 *         3   Float plus  244.2m    100 142b   100 0
 *         --- ----------- --------- --- ------ --- -----------------
 *      }}}
 *
 *      Bigger example can be found in [[Pipe.Benchmarks]]
 *
 * @def apply(targets -> Runs test with defaults
 *
 *       Runs ''apply'' 10 times for 2.Seconds each
 *
 * @def apply(runCount -> Runs test
 *
 *      Runs several targets side by side (actually mixing runs on a single thread) and prints results for comparison
 *
 *      Note: Results within 3% difference should generally be considered equal
 *
 *      @param runCount number of times to run the test.  The result of each run will be accumulated into 'Grand Total' at the end
 *      @param len: length of each test
 *      @param targets a list of tuples, each representing target name and target function to run.
 *                     The function return value is averaged and displayed in the results
 */
