package sample.Performance.Opt;  import scalqa.{*, given};  import language.implicitConversions

object FilterMapApply_Raw:

  def main(sa: Array[String]): Unit =

    val CNT = 100000
    val ints: Array[Int] = (0 <> CNT).~.toArray

    J.Benchmark(
      ("scala.Option[Int]", () => { var sum=0.Percent; for(i <- 0<>CNT){ val o: Option[Int] = Some(ints(i)); o.filter(_ % 2 == 0).map(_.Percent).foreach(sum += _)}; sum}),
      ("Opt[Int]",          () => { var sum=0.Percent; for(i <- 0<>CNT){ val o: Opt[Int]    = ints(i);       o.filter(_ % 2 == 0).map(_.Percent).forval (sum += _)}; sum}),
      ("Int.Opt",           () => { var sum=0.Percent; for(i <- 0<>CNT){ val o: Int.Opt     = ints(i);       o.filter(_ % 2 == 0).map(_.Percent).forval (sum += _)}; sum}),
    )