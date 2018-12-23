package Quick_Collections.Immutable

/**
 *  Code
 *
 *  {{{
 *     import scalqa._
 *
 *     App.Benchmark(12.Seconds,
 *       ("List  ", () => { var v: List[Int] = Nil;                  for (i <- 0 to 50) v = i :: v; v.size }),
 *       ("Vector", () => { var v: Vector[Int] = Vector.empty;       for (i <- 0 to 50) v :+= i;    v.size }),
 *       ("Array ", () => { var v: Array[Int] = Array.emptyIntArray; for (i <- 0 to 50) v += i;     v.size }),
 *       ("Refs  ", () => { var v: Refs[Int] = \/;                   for (i <- 0 to 50) v += i;     v.size }),
 *       ("Ints  ", () => { var v: Ints = \/;                        for (i <- 0 to 50) v += i;     v.size }))
 *   }}}
 *
 *   Result
 *
 *  {{{
 *     Final Result.  Total Duration 12 secs
 *     --- ------ --------- --- ------ --- -----------------
 *     Num Name   Run Count %   Memory %   Control Value Avg
 *     --- ------ --------- --- ------ --- -----------------
 *     1   List   5.0m      100 1.1kB  11  51
 *     2   Vector 749.8k    14  10.2kB 100 51
 *     3   Array  1.1m      21  6.2kB  61  51
 *     4   Refs   616.8k    12  7.2kB  70  51
 *     5   Ints   1.0m      21  6.1kB  60  51
 *     --- ------ --------- --- ------ --- -----------------
 *  }}}
 */
class Growing_Small { val sort_1 = () }
