package scalqa; package lang; package string; package z; import language.implicitConversions

object replace:

  def first(v: String, s1: String, s2: String, cnt:Int): String =
    var p = v.indexOf(s1, 0)
    if(p < 0) v else
      val b = StringBuilder(v)
      var i = 0
      while(p >= 0)
        b.replace(p,p+s1.length, s2)
        i += 1
        p = if(i<cnt) b.indexOf(s1, p + s2.length) else -1
      b.toString

  def last (v: String, s1: String, s2: String, cnt:Int): String =
    var p = v.lastIndexOf(s1, v.length - 1)
    if(p < 0) v else
      val b = StringBuilder(v)
      var i = 0
      while(p >= 0)
        b.replace(p,p+s1.length, s2)
        i += 1
        p = if(i<cnt) b.lastIndexOf(s1, p - 1) else -1
      b.toString

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
