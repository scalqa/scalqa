package Quick_Collections.Stream_Performance

/**
 *  Code
 *
 *  {{{
 *     import scalqa._
 *
 *     val range  = 0 to 1000
 *     val vector = range.toVector
 *     val list   = range.toList
 *     val array  = range.toArray
 *
 *     App.Benchmark(12.Seconds,
 *       ("Range        ", () => { for (i <- range;    if i % 2 == 0; j <- range   ) yield i + j / 2L } sum),
 *       ("Vector       ", () => { for (i <- vector;   if i % 2 == 0; j <- vector  ) yield i + j / 2L } sum),
 *       ("List         ", () => { for (i <- list;     if i % 2 == 0; j <- list    ) yield i + j / 2L } sum),
 *       ("Array        ", () => { for (i <- array;    if i % 2 == 0; j <- array   ) yield i + j / 2L } sum),
 *       ("Range Stream ", () => { for (i <- range ~;  if i % 2 == 0; j <- range ~ ) yield i + j / 2L } sum),
 *       ("Vector Stream", () => { for (i <- vector ~; if i % 2 == 0; j <- vector ~) yield i + j / 2L } sum),
 *       ("List Stream  ", () => { for (i <- list ~;   if i % 2 == 0; j <- list ~  ) yield i + j / 2L } sum),
 *       ("Array Stream ", () => { for (i <- array ~;  if i % 2 == 0; j <- array ~ ) yield i + j / 2L } sum))
 *  }}}
 *
 *   Result
 *
 *  {{{
 *     Final Result.  Total Duration 12 secs
 *     --- ------------- --------- --- ------ --- -----------------
 *     Num Name          Run Count %   Memory %   Control Value Avg
 *     --- ------------- --------- --- ------ --- -----------------
 *     1   Range         52        12  28.5mB 50  376000500
 *     2   Vector        63        14  32.5mB 58  376000500
 *     3   List          79        18  48.3mB 86  376000500
 *     4   Array         74        17  56.1mB 100 376000500
 *     5   Range Stream  415       96  0B     0   376000500
 *     6   Vector Stream 292       67  0B     0   376000500
 *     7   List Stream   313       72  0B     0   376000500
 *     8   Array Stream  431       100 0B     0   376000500
 *     --- ------------- --------- --- ------ --- -----------------
 *  }}}
 */
class Specialized_Benchmarks { val sort_2 = () }
