package sample.Performance.Stream;  import scalqa.{*, given};  import language.implicitConversions

object FilterMapFlatFold:

  def main(sa: Array[String]): Unit =

    val CNT = 100

    val ints  : Array[Int]         = (1 <> CNT).~.toArray
    val array : Array[String]      = ints.~.map(_.toString).toArray
    val sList : scala.List[String] = array.toList
    val vector: Vector[String]     = array.toVector

    J.Benchmark(
      ("Vector",       () => {for(s <- vector         if s.length%2==0; i <- ints  ) yield i.toLong+1L}.fold(0L)(_ + _)),
      ("scala.List",   () => {for(s <- sList          if s.length%2==0; i <- ints  ) yield i.toLong+1L}.fold(0L)(_ + _)),
      ("Array",        () => {for(s <- array          if s.length%2==0; i <- ints  ) yield i.toLong+1L}.fold(0L)(_ + _)),
      ("Iterator",     () => {for(s <- array.iterator if s.length%2==0; i <- ints  ) yield i.toLong+1L}.fold(0L)(_ + _)),
      ("Stream",       () => {for(s <- array.~        if s.length%2==0; i <- ints.~) yield i.toLong+1L}.fold(0L)(_ + _)),
      ("Stream direct",() => array.~.take(_.length%2==0).flatMap (_ => ints.~).map(_.toLong+1L).fold(0L)(_ + _)),
      ("Stream HEAVY", () => array.~.TAKE(_.length%2==0).FLAT_MAP(_ => ints.~).MAP(_.toLong+1L).FOLD(0L)(_ + _)),
    )

