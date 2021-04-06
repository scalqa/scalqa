package scalqa; package lang; package string; package _Extension; import language.implicitConversions

object Z:

  def indent(text: String, tag: String): String = if (tag == null || tag.length == 0) text else
    val sep = "\n" + " " * tag.length
    tag + text.line_~.makeString(sep)


  def replaceFirst(v: String, s1: String, s2: String, cnt:Int): String =
    var p = v.indexOf(s1, 0)
    if(p < 0) v else
      val b = StringBuilder(v)
      var i = 0
      while(p >= 0)
        b.replace(p,p+s1.length, s2)
        i += 1
        p = if(i<cnt) b.indexOf(s1, p + s2.length) else -1
      b.toString

  def replaceLast (v: String, s1: String, s2: String, cnt:Int): String =
    var p = v.lastIndexOf(s1, v.length - 1)
    if(p < 0) v else
      val b = StringBuilder(v)
      var i = 0
      while(p >= 0)
        b.replace(p,p+s1.length, s2)
        i += 1
        p = if(i<cnt) b.lastIndexOf(s1, p - 1) else -1
      b.toString

  def tokenizedStream(text: String, doc: ~[String]): ~[(String, Int.<>, String)] =
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
