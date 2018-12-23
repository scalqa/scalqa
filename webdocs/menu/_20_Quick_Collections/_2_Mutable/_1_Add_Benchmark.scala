package Quick_Collections.Mutable

/**
 *  Code
 *
 *  {{{
 *     import scalqa._
 *     import scala.collection.mutable.Buffer
 *
 *     val sa: Array[String] = (0 to 1000).all.map("string" + _).toArray
 *
 *     App.Benchmark(12.Seconds,
 *       ("List      ", () => { var v: List[String]   = Nil;          for (i <- 0 to 1000) v = sa(i) :: v; v.size }),
 *       ("Vector    ", () => { var v: Vector[String] = Vector.empty; for (i <- 0 to 1000) v :+= sa(i);    v.size }),
 *       ("Buffer    ", () => { val v: Buffer[String] = Buffer.empty; for (i <- 0 to 1000) v += sa(i);     v.size }),
 *       ("Idx.M     ", () => { val v: Idx.M[String]  = NEW;          for (i <- 0 to 1000) v += sa(i);     v.size }))
 *   }}}
 *
 *   Result
 *
 *  {{{
 *     Final Result.  Total Duration 12 secs
 *     --- ---------- --------- --- ------- --- -----------------
 *     Num Name       Run Count %   Memory  %   Control Value Avg
 *     --- ---------- --------- --- ------- --- -----------------
 *     1   List       288.2k    54  23.5kB  11  1001
 *     2   Vector     46.9k     8   204.2kB 100 1001
 *     3   Buffer     496.5k    93  8.1kB   3   1001
 *     4   Idx.M      531.7k    100 8.3kB   4   1001
 *     --- ---------- --------- --- ------- --- -----------------
 *  }}}
 *
 */
class Add_Benchmark { val sort_1 = () }
