package sample;  import scalqa.{*, given};  import language.implicitConversions

object Test0:

  def main(sa: Array[String]): Unit =
    "22221dd222ssss2A".tp


//
//    val array: Array[String] = (1 <> CNT).~.map(_.toString).toArray
//
//    array.~       .map(_.length % 256).flatMap(_ => 1 <> 12).map(_.Char).map(_.Byte).map(_.Int.Percent).map(_.real.Long.Nanos).doc.tp
//
//    J.Benchmark(
//      ("Stream",       () =>{var i=0L; array.~       .map(_.length % 256).flatMap(_ => 1 <> 12).map(_.Char).map(_.Byte).map(_.Int.Percent).map(_.real.Long.Nanos).foreach(i += _.nanosTotal); i}),
//      ("Stream",       () =>{var i=0L; array.~       .MAP(_.length % 256).FLAT_MAP(_ => 1 <> 12).MAP(_.Char).MAP(_.Byte).MAP(_.Int.Percent).MAP(_.real.Long.Nanos).FOREACH(i += _.nanosTotal); i}),
//      ("Array",        () =>{var i=0L; array         .map(_.length % 256).flatMap(_ => 1 to 12).map(_.Char).map(_.Byte).map(_.Int.Percent).map(_.real.Long.Nanos).foreach(i += _.nanosTotal); i}),
//      ("Iterator",     () =>{var i=0L; array.iterator.map(_.length % 256).flatMap(_ => 1 to 12).map(_.Char).map(_.Byte).map(_.Int.Percent).map(_.real.Long.Nanos).foreach(i += _.nanosTotal); i}),
//    )

