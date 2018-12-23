package Quick_Collections.Mutable

/**
 *  Code
 *
 *  {{{
 *     import scalqa._
 *     import scala.collection.mutable.Buffer
 *
 *     App.Benchmark(12.Seconds,
 *       ("List      ", () => { var v: List[Int]   = Nil;          for (i <- 0 to 1000) v = i :: v; v.size }),
 *       ("Vector    ", () => { var v: Vector[Int] = Vector.empty; for (i <- 0 to 1000) v :+= i;    v.size }),
 *       ("Buffer    ", () => { val v: Buffer[Int] = Buffer.empty; for (i <- 0 to 1000) v += i;     v.size }),
 *       ("Idx.M     ", () => { val v: Idx.M[Int]  = NEW;          for (i <- 0 to 1000) v += i;     v.size }))
 *   }}}
 *
 *   Result
 *
 *  {{{
 *     Final Result.  Total Duration 12 secs
 *     --- ---------- --------- --- ------- --- -----------------
 *     Num Name       Run Count %   Memory  %   Control Value Avg
 *     --- ---------- --------- --- ------- --- -----------------
 *     1   List       204.5k    30  37.3kB  17  1001
 *     2   Vector     48.8k     7   218.3kB 100 1001
 *     3   Buffer     369.2k    55  21.6kB  9   1001
 *     4   Idx.M      670.8k    100 8.3kB   3   1001
 *     --- ---------- --------- --- ------- --- -----------------
 *  }}}
 */
class Add_Benchmark_Specialized { val sort_2 = () }
