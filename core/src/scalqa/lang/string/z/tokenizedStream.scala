package scalqa; package lang; package string; package z; import language.implicitConversions

object tokenizedStream:

  def apply(text: String, doc: ~[String]): ~[(String, Int.<>, String)] =
    val b = doc.flatMap(tag => text.indexesOf_~(tag).zipValue(_ => tag))
      .sortBy(_._1)
      .zipNext
      .map(t => (t._1._2, t._1._1 + t._1._2.length <>> t._2.map(_._1).or(text.length)))
      .map(t => (t._1, t._2, text.take_<>(t._2)))
      .enablePreview
    b.preview_?.
      map(t => t._2.start - t._1.length).take(_ > 0).
      map(0 <>> _).
      map(r => ~~(("", r, text.take_<>(r))) ++ b).or(b).default(("", 0 <>> text.length, text))

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
