package scalqa; package Stream; package Z; package A; package Scala

private[scalqa] object GenTraversableOnce {

  def toStream[@specialized(DATA) A](v: collection.GenTraversableOnce[A])(implicit i: Ilk[A]): Stream[A] with Any.Able.Stream[A] = v match {
    case v: collection.IndexedSeq[A] => IndexedSeq.toStream(v)
    case v: collection.LinearSeq[A]  => LinearSeq.toStream(v)
    case v => {

      val it = v.toIterator

      new Stream[A] with Stream.A.Specialized[A] with Any.Able.Stream[A] {

        @inline def prime = it.hasNext

        @inline def pump = it.next

        @inline def foreach(c: Consumer[A]) = while (it.hasNext) c.accept(it.next)

        override def to[T[A]](implicit c: Stream.Interface.To.Converter[T]): T[A] = customTo(c, it, this)

        @inline override def ilkOpt = i.ilkOpt

        @inline def all = this
      }
    }
  }

  def customTo[A, T[A]](c: Stream.Interface.To.Converter[T], t: scala.TraversableOnce[A], s: Stream[A]): T[A] = c match {
    case Stream.Interface.To.List => t.toList.asInstanceOf[T[A]]
    case Stream.Interface.To.Buffer => t.toBuffer.asInstanceOf[T[A]]
    case Stream.Interface.To.IndexedSeq => t.toIndexedSeq.asInstanceOf[T[A]]
    case Stream.Interface.To.Seq => t.toSeq.asInstanceOf[T[A]]
    case Stream.Interface.To.Vector => t.toVector.asInstanceOf[T[A]]
    case _ => c.make(s)
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
