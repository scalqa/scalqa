package sample.Performance.Opt;  import scalqa.{*, given};  import language.implicitConversions

object MixingWith_for:

  def main(sa: Array[String]): Unit =

    val CNT = 10000

    inline def scalaOption(i: Int) : Option[Int] =
      val o1:Option[Int] = if(i%2!=0) Some(i) else None
      val o2:Option[Int] = if(i%3!=0) Some(i) else None
      val o3:Option[Int] = if(i%4!=0) Some(i) else None
      for(x <- o1; y <- o2; z <- o3) yield x+y+z

    inline def optInt(i: Int) : Opt[Int] =
      val o1:Opt[Int]    = if(i%2!=0) i else \/
      val o2:Opt[Int]    = if(i%3!=0) i else \/
      val o3:Opt[Int]    = if(i%4!=0) i else \/
      for(x <- o1; y <- o2; z <- o3) yield x+y+z

    inline def intOpt(i: Int) : Int.Opt =
      val o1:Int.Opt     = if(i%2!=0) i else \/
      val o2:Int.Opt     = if(i%3!=0) i else \/
      val o3:Int.Opt     = if(i%4!=0) i else \/
      for(x <- o1; y <- o2; z <- o3) yield x+y+z

    inline def intOptMix(i: Int) : Int.Opt =
      val o1:Int.Opt     = if(i%2!=0) i else \/
      val o2:Int.Opt     = if(i%3!=0) i else \/
      val o3:Int.Opt     = if(i%4!=0) i else \/
      o1.mix(o2, _ + _).mix(o3, _ + _)

    J.Benchmark(
      ("for <- scala.Option[Int]", () => {var s=0L; for(i <- 0 <> CNT) scalaOption(i).foreach(s += _); s}),
      ("for <- Opt[Int]",          () => {var s=0L; for(i <- 0 <> CNT) optInt(i)     .forval (s += _); s}),
      ("for <- Int.Opt",           () => {var s=0L; for(i <- 0 <> CNT) intOpt(i)     .foreach(s += _); s}),
      ("Int.Opt.mix",              () => {var s=0L; for(i <- 0 <> CNT) intOptMix(i)  .foreach(s += _); s}),
    )
