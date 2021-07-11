package scalqa; package `val`; package stream; package z; package use; import language.implicitConversions

object read:

  private class stream[A](val base: ~[A], v: Array[Ref], sz: Int) extends lang.array.z.stream.As.Refs[A](v,sz)

  def stream[A](s: ~[A], cnt: Int): ~[A] & Able.Size = if (cnt <= 0) \/ else
    var o = s.read_?
    if (o.isEmpty) \/
    else
      val a = new Array[Ref](cnt)
      a(0) = o.get.cast[Ref]
      var i = 1
      while (i < cnt)
        o = s.read_?
        if (o.isEmpty) return new stream(s,a,i)
        a(i) = o.get.cast[Ref]
        i += 1
      new stream(s,a,i)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/

