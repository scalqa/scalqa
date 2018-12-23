package Quick_Collections

/**
 *  In order to compare "apples to apples", we need to evaluate [[scalqa.Stream Stream]] against similar and well known functionality
 *
 *  Fortunately, [[scalqa.Stream Stream]] is also supported for Java and Scala collections
 *
 *  Once scalqa is imported, streaming method [[scalqa.Any.Able.Stream `all` and its alias `~`]] (tilde) are implicitly attached to all containers
 *
 *  {{{
 *     import scalqa._
 *
 *     val rs: Stream[Int]    = 1 to 10 all
 *
 *     val vs: Stream[Char]   = List('a','b','c') ~
 *
 *     val vs: Stream[String] = Vector("a","b","c").all
 *  }}}
 *
 *   Thus, we can [[scalqa.App.Benchmark benchmark]] Stream against native operations on the same well known collections
 *
 *   There are two tests for [[Benchmarks regular objects]] and [[Specialized_Benchmarks primitives]], where Stream has advantage of un-boxed performance
 */
package object Stream_Performance { val sort_1 = () }
