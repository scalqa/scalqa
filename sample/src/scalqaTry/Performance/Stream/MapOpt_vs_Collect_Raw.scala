package scalqaTry.Performance.Stream;  import scalqa.{*, given};  import language.implicitConversions

object MapOpt_vs_Collect_Raw:

  def main(sa: Array[String]): Unit =

    val CNT = 1000
    val a   : Array[Char]         = (0 <>> CNT).~.map(_.Char).toArray

    J.Benchmark(
      ("Array.collect   ",  () => {var i=0L; a         .collect       {case v if v%2==0 => v + 2              }.foreach(i += _); i}),
      ("Iterator.collect",  () => {var i=0L; a.iterator.collect       {case v if v%2==0 => v + 2              }.foreach(i += _); i}),
      ("Stream.map_?    ",  () => {var i=0L; a.~       .map_?[Int.Opt]{case v if v%2==0 => v + 2; case _ => \/}.foreach(i += _); i}),
      ("Stream.MAP_?    ",  () => {var i=0L; a.~       .MAP_?[Int.Opt]{case v if v%2==0 => v + 2; case _ => \/}.foreach(i += _); i}),
    )

