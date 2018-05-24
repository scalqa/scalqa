package scalqa; package Pipe; package Z; package transform

import java.{ util => J }

private[scalqa] object toJava {

  // ****************************************************************************************************************
  class List[A](protected val real: Index[A]) extends Index.Z.Java.Base[A] with Able.Info {
    def get(i: Int): A = real(i)
    def size = real.size
  }
  object List extends To[J.List](true, classOf[J.List[Any]]) {
    override def apply[A](src: Flow[A], t: Tag[A]) = new List(src.sequential.as(To.Index, t))
  }
  // ****************************************************************************************************************
  object Iterator extends To[J.Iterator](true, classOf[J.Iterator[Any]]) {

    override def apply[A](src: Flow[A], t: Tag[A]) = asIterator(src.sequential)
  }

  // ****************************************************************************************************************
  object Stream extends To[J.stream.Stream](true, classOf[J.stream.Stream[Any]]) {

    override def apply[A](src: Flow[A], t: Tag[A]) = J.stream.StreamSupport.stream(Spliterator(src, t), false)
  }

  // ****************************************************************************************************************
  class Spliterator[A](protected val all: Pipe[A], protected val splitSize: Int, allowMoreSplits: Boolean = true) extends J.Spliterator[A] {

    def characteristics = J.Spliterator.SUBSIZED | all.sizeOpt.isVoid ? (0, J.Spliterator.SIZED)

    def estimateSize = all.sizeOpt.map(_.toLong) or Long.Max

    def tryAdvance(f: J.function.Consumer[_ >: A]) = all.pumpOpt(EVERY).apply(f.accept(_))

    def trySplit = {
      var c: Coll.Val[A] = \/
      all.pumpOpt(v => { c += v; c.size >= splitSize })
      if (c.isEmpty) null else new Sub(c)
    }

    // ***************************************************************************
    class Sub[A](c: Coll[A]) extends Spliterator[A](c.all, c.size / 2) {
      override def characteristics = J.Spliterator.SIZED | J.Spliterator.SUBSIZED
      override def trySplit = if (allowMoreSplits) super.trySplit else null
    }
  }

  object Spliterator extends To[J.Spliterator](true, classOf[J.Spliterator[Any]]) {

    override def apply[A](src: Flow[A], t: Tag[A]) = new Spliterator(src.sequential, 1)

    def apply[A](src: Pipe[A], splitSize: Int) = new Spliterator(src, splitSize)
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/