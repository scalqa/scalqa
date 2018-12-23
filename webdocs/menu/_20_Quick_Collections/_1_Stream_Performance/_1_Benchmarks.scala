package Quick_Collections.Stream_Performance

/**
 *  Code
 *
 *  {{{
 *     import scalqa._
 *
 *     class Foo(val id: Int) { def even = id % 2 == 0 }
 *     class Bar(val foo: Foo)
 *
 *     val vector = (1 to 100).map(i => new Bar(new Foo(i))).toVector
 *     val list   = vector.toList
 *     val array  = vector.toArray
 *
 *     App.Benchmark(12.Seconds,
 *       ("Vector       ", () => { for (v <- vector  ; if v.foo.even; b <- vector  ) yield b.foo }.count(_.even)),
 *       ("List         ", () => { for (v <- list    ; if v.foo.even; b <- list    ) yield b.foo }.count(_.even)),
 *       ("Array        ", () => { for (v <- array   ; if v.foo.even; b <- array   ) yield b.foo }.count(_.even)),
 *       ("Vector Stream", () => { for (v <- vector ~; if v.foo.even; b <- vector ~) yield b.foo }.count(_.even)),
 *       ("List   Stream", () => { for (v <- list ~  ; if v.foo.even; b <- list ~  ) yield b.foo }.count(_.even)),
 *       ("Array  Stream", () => { for (v <- array ~ ; if v.foo.even; b <- array ~ ) yield b.foo }.count(_.even)))
 *   }}}
 *
 *   Result
 *
 *  {{{
 *     Final Result.  Total Duration 12 secs
 *     --- ------------- --------- --- ------- --- -----------------
 *     Num Name          Run Count %   Memory  %   Control Value Avg
 *     --- ------------- --------- --- ------- --- -----------------
 *     1   Vector        10.5k     26  66.0kB  27  2500
 *     2   List          15.9k     40  239.5kB 100 2500
 *     3   Array         14.3k     36  113.3kB 47  2500
 *     4   Vector Stream 39.0k     100 2.6kB   1   2500
 *     5   List   Stream 33.6k     86  4.2kB   1   2500
 *     6   Array  Stream 24.1k     61  3.6kB   1   2500
 *     --- ------------- --------- --- ------- --- -----------------
 *  }}}
 */
class Benchmarks extends App { val sort_1 = () }
