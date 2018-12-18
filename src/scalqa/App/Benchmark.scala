package scalqa; package App

object Benchmark {

  def apply[A: Numeric](totalTime: Duration, targets: (String, () => A)*): Unit = {
    val subTestMillis = { // Each run 2.5 or 3 seconds
      val m = totalTime.totalMillis.real;
      if (m % 3000 < m % 2500) 3000.Millis else 2500.Millis
    }
    applySplit[A]((totalTime.totalMillis / subTestMillis).toInt, subTestMillis, 10.Millis, targets: _*)
  }

  def applySplit[A: Numeric](subTestCount: Int, subTestLength: Duration, gcPause: Duration, targets: (String, () => A)*): Unit =
    Z.Benchmark.apply(targets.all.to[Idx], subTestCount, subTestLength, gcPause)

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
 *     [[App.Benchmark]] is a simple comparison testing tool
 *
 *     JVM technology makes it difficult to get absolute performance data
 *
 *     [[App.Benchmark]] allows to run several targets side by side, comparing their performance against each other
 *
 *     The result presents three values:
 *
 *       - 'Run count' is the number of times the target executed. The time frame is equal for all targets
 *       - 'Memory' is the average memory increase for all executions.
 *          This is even less precise measurement, however for side by side comparison is somewhat valuable
 *       - 'Control Value Avg' is the average of target returns.
 *         This can be used for validity check. In best case, all targets should arrive to the same value in different ways
 *
 *       Let's test folding performance for List, Vector and Array
 *
 *      {{{
 *         // Int values from 0 to 100 shuffled
 *
 *         val v: Vector[Int] = (1 <> 100).all.shuffle.to[Vector]
 *         val l: List[Int] = v.toList
 *         val a: Array[Int] = v.toArray
 *
 *         App.Benchmark(10.Seconds,
 *           ("List   ", () => l.fold(0)(_ + _)),
 *           ("Vector ", () => v.fold(0)(_ + _)),
 *           ("Array  ", () => a.fold(0)(_ + _)))
 *
 *         // Output
 *         Final Result.  Total Duration 10 secs
 *         --- ------- --------- --- ------ --- -----------------
 *         Num Name    Run Count %   Memory %   Control Value Avg
 *         --- ------- --------- --- ------ --- -----------------
 *         1   List    2.5m      51  1.4kB  86  5050
 *         2   Vector  2.0m      41  1.7kB  100 5050
 *         3   Array   4.9m      100 1.5kB  90  5050
 *         --- ------- --------- --- ------ --- -----------------
 *      }}}
 *
 * @def apply[ -> Run test with defaults
 *
 *      Runs test for the totalTime specified
 *
 *      A number of sub-tests will be generated automatically
 *
 *      @param totalTime total time allowed for the test
 *      @param targets a list of tuples, each representing target name and target function to run.
 *                     The function return will be converted to Long and average value will be displayed in the results
 *
 *
 * @def applySplit -> Run test specialized
 *
 *      Runs test with specified number of subtests and GC time
 *
 *      @param subTestCount number of times to run the test.  The result of each run will be accumulated into 'Grand Total' at the end
 *      @param subTestLength: length of each test
 *      @param gcPause: Garbage collection pause, after each mini-run
 *      @param targets a list of tuples, each representing target name and target function to run.
 *                     The function return will be converted to Long and average value will be displayed in the results
 */
