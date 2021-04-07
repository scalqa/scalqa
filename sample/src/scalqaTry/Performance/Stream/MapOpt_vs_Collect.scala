package scalqaTry.Performance.Stream;  import scalqa.{*, given};  import language.implicitConversions

object MapOpt_vs_Collect:

  def main(sa: Array[String]): Unit =

    val CNT = 1001

    val a: Array[String] = (0 <>> CNT).~.map(_.toString).toArray

    J.Benchmark(
      ("Array.collect",     () => {var i=0L; a         .collect           {case v if v.length%2==0 => v              }.foreach(i += _.length); i}),
      ("Iterator.collect",  () => {var i=0L; a.iterator.collect           {case v if v.length%2==0 => v              }.foreach(i += _.length); i}),
      ("Stream.map_?   ",   () => {var i=0L; a.~       .map_?[Opt[String]]{case v if v.length%2==0 => v; case _ => \/}.foreach(i += _.length); i}),
      ("Stream.MAP_?   ",   () => {var i=0L; a.~       .MAP_?[Opt[String]]{case v if v.length%2==0 => v; case _ => \/}.foreach(i += _.length); i}),
    )

