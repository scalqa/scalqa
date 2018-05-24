package scalqa; package Pipe; package Z; package transform

private[Pipe] object toScala {

  object List extends To[List](false, classOf[List[_]]) {

    override def apply[A](src: Flow[A], t: Tag[A]): List[A] = { var l: List[A] = Nil; src.synchronize(v => l = v :: l); l }

  }

  // ****************************************************************************************************************
  object Iterator extends To[scala.Iterator](true, classOf[scala.Iterator[Any]]) {

    override def apply[A](src: Flow[A], t: Tag[A]) = asIterator(src.sequential)
  }

  // ****************************************************************************************************************
  object Vector extends To[scala.Vector](false, classOf[scala.Vector[_]]) {

    override def apply[A](src: Flow[A], t: Tag[A]): scala.Vector[A] = Iterator(src, t).toVector
  }

  // ****************************************************************************************************************
  object Buffer extends To[collection.mutable.Buffer](false, classOf[collection.mutable.Buffer[_]]) {

    override def apply[A](src: Flow[A], t: Tag[A]): collection.mutable.Buffer[A] = Iterator(src, t).toBuffer
  }

  // ****************************************************************************************************************
  class IndexedSeq[A](protected val real: Index[A]) extends scala.IndexedSeq[A] {

    def apply(i: Int) = real(i);

    def length = real.size;
  }

  object IndexedSeq extends To[scala.IndexedSeq](false, classOf[scala.IndexedSeq[Any]]) {

    override def apply[A](src: Flow[A], t: Tag[A]) = new IndexedSeq(toIndex(src, t))
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/