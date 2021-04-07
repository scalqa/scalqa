package scalqaTry.Performance.Opt;  import scalqa.{*, given};  import language.implicitConversions

object FilterMapApply:

  case class Bar(name: String, size: Long)

  def main(sa: Array[String]): Unit =

    val CNT = 10000
    val bars: Array[Bar] = (1 <> CNT).~.map(i => Bar(i.toString,i)).toArray

    J.Benchmark(
      ("scala.Option[Bar]", () => { var sum=0L; for(i <- 0<>>CNT){ Some(bars(i)).filter(_.size % 2 == 0).map(_.name).foreach(sum += _.length)}; sum}),
      ("Opt[Bar]",          () => { var sum=0L; for(i <- 0<>>CNT){ bars(i).?    .filter(_.size % 2 == 0).map(_.name).forval (sum += _.length)}; sum}),
    )