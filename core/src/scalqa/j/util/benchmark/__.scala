package scalqa; package j; package util; import language.implicitConversions

import benchmark.z.execute

object Benchmark:

  // The test code is physically repeated 5 times (BUNDLED) to prevent JVM on picking favorite execution path

  @tn("numbered") inline def apply[A](inline targets: (() => A)*)(using Opt[Math[A]]): Unit =
    var s=sep1; val BUNDLE_1=targets; s=sep2; val BUNDLE_2=targets; val BUNDLE_3=targets; val BUNDLE_4=targets; val BUNDLE_5=targets
    execute[A]((BUNDLE_1.~ ++ BUNDLE_2 ++ BUNDLE_3 ++ BUNDLE_4 ++ BUNDLE_5).zipIndex.map((i,f) => ((i%BUNDLE_1.size+1).tag,f)).><,5)

  @tn("labeled")  inline def apply[A](inline targets: (String, () => A)*)(using Opt[Math[A]]): Unit =
    var s=sep1; val BUNDLE_1=targets; s=sep2; val BUNDLE_2=targets; val BUNDLE_3=targets; val BUNDLE_4=targets; val BUNDLE_5=targets
    execute[A]((BUNDLE_1.~ ++ BUNDLE_2 ++ BUNDLE_3 ++ BUNDLE_4 ++ BUNDLE_5).><,5)

  inline def custom[A](verbose: Boolean = true, trialCount: Int = 4, eachTrial: Time.Length = 3.Seconds)(inline targets: (String, () => A)*)(using Opt[Math[A]]): Unit =
    var s=sep1; val BUNDLE_1=targets; s=sep2; val BUNDLE_2=targets; val BUNDLE_3=targets; val BUNDLE_4=targets; val BUNDLE_5=targets
    execute[A]((BUNDLE_1.~ ++ BUNDLE_2 ++ BUNDLE_3 ++ BUNDLE_4 ++ BUNDLE_5).><, 5, trialCount, eachTrial, verbose)

  private inline val sep1 = "@@@@@@@ Start Benchmark Definition @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@"
  private inline val sep2 = "@@@@@@@ End. Below is just repetition (4 more times) @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@"

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@object Benchmark -> ###

       [[Benchmark]] is a basic comparison test tool

       JVM technology makes it difficult to get absolute performance data

       [[Benchmark]] allows to run several targets side by side, comparing their performance against each other

       Let's try to benchmark 'append' performance for `List`, `Vector` and `Buffer`

       ```
       J.Benchmark(
         ("scala.List  ", () => { var v: List[Int]   = Nil;          for (i <- 1 <> 1000) v = i :: v; v.size }),
         ("scala.Vector", () => { var v: Vector[Int] = Vector.empty; for (i <- 1 <> 1000) v = v :+ i; v.size }),
         ("Val.Buffer",   () => { val v: Buffer[Int] = Buffer();     for (i <- 1 <> 1000) v += i;     v.size }))

       // Output
       Final Result. Total length is about 12 secs
       --- ------------ ------- --- ------- --- ---------
       Num Name         Ops/Sec %   Memory  %   Avg Value
       --- ------------ ------- --- ------- --- ---------
       1   scala.List   145.5k  50  37.8kB  30  1000.0
       2   scala.Vector 40.3k   13  125.1kB 100 1000.0
       3   Val.Buffer   291.1k  100 21.3kB  17  1000.0
       --- ------------ ------- --- ------- --- ---------
       ```
       The results present three values:

         - 'Ops/Sec' is the number of times the target executed per second
         - 'Memory' is the average memory increase for one execution
         - 'Avg Value' is the average of target returns for validity check. Naturally, all targets should arrive to the same value in different ways

       `Note.` Absolute values are less informative than following them percentages of the largest value

       From the above example, the following conclusions can be made:

          - `List` is twice and `Vector` is five times slower than `Buffer`
          - `Vector` is seriously heavier on memory

@def apply -> Run with defaults

        Runs 4 trials 3 seconds each

        All trials are accumulated into final result

        @param targets a list of tuples, each representing target name and target function to run.
                       The function return will be converted to Long and average value will be displayed in the results

        @note All targets must return `same` numeric type (Int, Long, Double, etc.)


@def custom -> Run specified number of trials

        J.Benchmarking is split in several trials, which are equal sub-tests, and their results should be in the same ball park

        If some trial appears to be off the line, then something unusual happened, and it is a good reason to re-run the entire test

        All trials are accumulated into final result

        @param trialCount - number of trials to run
        @param eachTrial - length of each trial
        @param targets - a list of tuples, each representing target name and target function to run.
                       The function return will be converted to Long and average value will be displayed in the results

        @note All targets must return `same` numeric type (Int, Long, Double, etc.)

*/
