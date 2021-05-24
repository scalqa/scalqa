package example.performance.opt;  import scalqa.{*, given};  import language.implicitConversions

object MapOpt_vs_Collect_Raw:

  def main(sa: Array[String]): Unit =

    val CNT = 100000
    val a   : Array[Char]         = (0 <>> CNT).~.map(_.Char).toArray

    J.Benchmark(
      ("collect ", () => {var s=0L; for(j <- 0 <>> CNT)  Some(a(j)).collect       {case v if v%2==0 => v + 2              }.foreach(i => s += i.Long); s}),
      ("map_?   ", () => {var s=0L; for(j <- 0 <>> CNT)  a(j).?    .map_?[Int.Opt]{case v if v%2==0 => v + 2; case _ => \/}.foreach(i => s += i.Long); s}),
    )

