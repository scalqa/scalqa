package scalqa; package `val`; package stream; package z; package _use; import language.implicitConversions

object _read:

  private class stream[A](val base: ~[A], v: Array[AnyRef], sz: Int) extends lang.anyref.Z.Stream_ofArray[A](v,sz)

  def stream[A](s: ~[A], cnt: Int): ~[A] & Able.Size = if (cnt <= 0) EMPTY else
    var o = s.read_?
    if (!o) EMPTY
    else
      val a = new Array[AnyRef](cnt)
      a(0) = o.get.cast[AnyRef]
      var i = 1
      while (i < cnt)
        o = s.read_?
        if (!o) return new stream(s,a,i)
        a(i) = o.get.cast[AnyRef]
        i += 1
      new stream(s,a,i)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/

