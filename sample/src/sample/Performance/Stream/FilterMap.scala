package sample.Performance.Stream;  import scalqa.{*, given};  import language.implicitConversions

object FilterMap:

  def main(sa: Array[String]): Unit =

    val CNT = 10000

    val array: Array[String] = (1 <> CNT).~.map(_.toString).toArray

    J.Benchmark(
      ("Stream",       () =>{var i=0L; {for(s <- array.~        if s.length%2==0) yield s.length * 123L}.foreach(i += _); i}),
      ("Array",        () =>{var i=0L; {for(s <- array          if s.length%2==0) yield s.length * 123L}.foreach(i += _); i}),
      ("Iterator",     () =>{var i=0L; {for(s <- array.iterator if s.length%2==0) yield s.length * 123L}.foreach(i += _); i}),
    )

