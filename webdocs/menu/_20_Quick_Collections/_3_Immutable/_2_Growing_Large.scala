package Quick_Collections.Immutable

/**
 *  Growing large Array is devastatingly slow, so we also test creating [[scalqa.Refs Refs]]
 *  with List, Vector, and [[scalqa.Idx.M Idx.M (mutable buffer)]] as intermediary
 *
 *  Code
 *
 *  {{{
 *     import scalqa._
 *
 *     App.Benchmark(12.Seconds,
 *       ("List       ", () => { var v: List[Int] = Nil;                  for (i <- 0 to 1000) v = i :: v; v.size }),
 *       ("Vector     ", () => { var v: Vector[Int] = Vector.empty;       for (i <- 0 to 1000) v :+= i;    v.size }),
 *       ("Array      ", () => { var v: Array[Int] = Array.emptyIntArray; for (i <- 0 to 1000) v += i;     v.size }),
 *       ("Refs       ", () => { var v: Refs[Int] = \/;                   for (i <- 0 to 1000) v += i;     v.size }),
 *       ("Ints       ", () => { var v: Ints = \/;                        for (i <- 0 to 1000) v += i;     v.size }),
 *       ("List/Ints  ", () => { var v: List[Int] = Nil;                  for (i <- 0 to 1000) v = i :: v; v.all.toRaw[Ints].size }),
 *       ("Vector/Ints", () => { var v: Vector[Int] = Vector.empty;       for (i <- 0 to 1000) v :+= i;    v.all.toRaw[Ints].size }),
 *       ("Buffer/Ints", () => { val v: Idx.M[Int] = NEW;                 for (i <- 0 to 1000) v += i;     v.all.toRaw[Ints].size }))
 *   }}}
 *
 *   Result
 *
 *  {{{
 *     Final Result.  Total Duration 12 secs
 *     --- ---------------- --------- --- ------- --- -----------------
 *     Num Name             Run Count %   Memory  %   Control Value Avg
 *     --- ---------------- --------- --- ------- --- -----------------
 *     1   List             99.2k     48  34.0kB  1   1001
 *     2   Vector           24.4k     11  219.7kB 10  1001
 *     3   Array            3.0k      1   1.9mB   92  1001
 *     4   Refs             2.6k      1   2.1mB   100 1001
 *     5   Ints             2.8k      1   2.0mB   95  1001
 *     6   Ints from List   73.4k     35  49.7kB  2   1001
 *     7   Ints from Vector 17.9k     8   226.4kB 10  1001
 *     8   Ints from Buffer 206.3k    100 12.4kB  0   1001
 *     --- ---------------- --------- --- ------- --- -----------------
 *  }}}
 */
class Growing_Large { val sort_2 = () }
