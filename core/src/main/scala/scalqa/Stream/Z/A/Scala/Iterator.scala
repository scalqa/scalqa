package scalqa; package Stream; package Z; package A; package Scala

private[scalqa] object Iterator {

  def toStream[@specialized(DATA) A](it: java.util.Iterator[A])(implicit i: Ilk[A]): Stream[A] with Any.Able.Stream[A] = new Stream.A.Base[A] with Any.Able.Stream[A] {

    @inline def prime = it.hasNext

    @inline def pump = it.next

    @inline override def ilkOpt = i.ilkOpt

    @inline def all = this
  }

  def make[A](src: Stream[A]): scala.Iterator[A] with java.util.Iterator[A] = new collection.AbstractIterator[A] with java.util.Iterator[A] {

    @inline def hasNext = src.prime

    @inline def next = if (src.prime) src.pump else Stream.failEmpty
  }
}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
