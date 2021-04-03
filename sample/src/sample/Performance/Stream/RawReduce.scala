package sample.Performance.Stream;  import scalqa.{*, given};  import language.implicitConversions

object RawReduce:

  def main(arg: Array[String]): Unit =

    val COUNT = 10000

    val array : Array[Percent] = (1 <> COUNT).~.map(_.Percent).toArray

    J.Benchmark(
      ("Iterator",     () => array.iterator.reduce(_ + _)),
      ("Array",        () => array         .reduce(_ + _)),
      ("Stream ",      () => array.~       .reduce(_ + _)),
      ("Stream HEAVY", () => array.~       .REDUCE(_ + _)),
    )
