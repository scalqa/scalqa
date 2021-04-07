package scalqaTry.Performance.Stream;  import scalqa.{*, given};  import language.implicitConversions

object MultiFilter:

  def main(sa: Array[String]): Unit =

    val CNT = 10000

    val array: Array[String] = (1 <> CNT).~.map(_.toString).toArray

    J.Benchmark(
      ("Stream",       () =>{var i=0L; for(s <- array.~        if s.charAt(0)!='0' if s.charAt(0)!='2' if s.charAt(0)!='3' if s.charAt(0)!='4' if s.charAt(0)!='5')  i += s.length;  i}),
      ("Array",        () =>{var i=0L; for(s <- array          if s.charAt(0)!='0' if s.charAt(0)!='2' if s.charAt(0)!='3' if s.charAt(0)!='4' if s.charAt(0)!='5')  i += s.length;  i}),
      ("Iterator",     () =>{var i=0L; for(s <- array.iterator if s.charAt(0)!='0' if s.charAt(0)!='2' if s.charAt(0)!='3' if s.charAt(0)!='4' if s.charAt(0)!='5')  i += s.length;  i}),
      ("Stream HEAVY", () =>{var i=0L; array.~.TAKE(_.charAt(0)!='0').TAKE(_.charAt(0)!='2').TAKE(_.charAt(0)!='3').TAKE(_.charAt(0)!='4').TAKE(_.charAt(0)!='5').FOREACH(i += _.length); i}),
    )
