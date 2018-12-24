package scalqa; package Stream; package Z; package consume; package convert

import Stream.A.Specialized.Indexed

private[Stream] object copyTo {

  def apply[@specialized(DATA) A](s: Stream[A], b: Idx.Array.Buffer.Loader[A]) = s match {
    case x: Indexed[_] =>
      val v = x.asInstanceOf[Stream[A] with Indexed[A]]
      var i = v._position; val sz = Indexed.size(v)
      while (i < sz) { b.add(Indexed(v, i)); i += 1 }
      v._position = sz
    case _ =>
      s.foreach(new Consumer[A] { def accept(v: A) = b add v })
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
