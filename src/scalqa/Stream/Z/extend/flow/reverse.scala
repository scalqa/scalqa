package scalqa; package Stream; package Z; package extend; package flow

import Stream.A.Specialized.Indexed

private[Stream] object reverse {

  @inline def apply[@specialized(DATA) A](s: Stream[A]): Stream[A] = {

    abstract class Base extends Stream[A] with A.Extended.All[A] with Indexed[A] {
      @inline def real = s
      @inline def pump = _pumpIndexed
      @inline def foreach(f: Consumer[A]) = _consumeIndexed(f)
      override def sortedOpt: Opt[Ordering[A]] = real.sortedOpt.map(_.reverse)
    }

    class Idx(s: Indexed[A]) extends Base {
      @inline val _size = Indexed.size(s)
      @inline def _apply(i: Int): A = Indexed(s, _size - 1 - i)
    }

    class General extends Base {
      lazy val bin = s.to[Idx.Array.Buffer]
      @inline def _size = bin.size
      @inline def _apply(i: Int): A = bin(_size - 1 - i)
    }

    s match {
      case v: Indexed[_] => new Idx(v.asInstanceOf[Indexed[A]])
      case v             => new General
    }
  }
}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
