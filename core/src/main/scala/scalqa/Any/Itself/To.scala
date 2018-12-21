package scalqa; package Any; package Itself

object To {

  abstract class Converter[CONTAINER[Any]] protected {

    def make[A]: (A, Ilk.Tag[A]) => CONTAINER[A]

  }

  implicit val StreamInterface: Converter[~] = new Converter[~] { def make[A] = (v, i) => Stream.Z.A.One(v) }
  implicit val Idx: Converter[scalqa.Idx] = new Converter[scalqa.Idx] { def make[A] = (v, i) => new Idx(v) }
  implicit val Refs: Converter[Refs] = new Converter[Refs] { def make[A] = (v, i) => scalqa.Refs.single(v)(i) }

  // Scala ----------------------------------------------------------------------------------------------------------------
  // "Converter" is not co-variant, so Seq and IndexedSeq are needed both
  implicit val IndexedSeq: Converter[scala.IndexedSeq] = new Converter[scala.IndexedSeq] { def make[A] = (v, i) => new IndexedSeq(v) }
  implicit val Seq: Converter[scala.Seq] = IndexedSeq.asInstanceOf[Converter[scala.Seq]]
  implicit val List: Converter[scala.List] = new Converter[scala.List] { def make[A] = (v, i) => v :: Nil }
  implicit val Vector: Converter[scala.Vector] = new Converter[scala.Vector] { def make[A] = (v, i) => scala.Vector.empty[A] :+ v }
  implicit val Iterator: Converter[scala.Iterator] = new Converter[scala.Iterator] { def make[A] = (v, i) => new Iterator(v) }

  // Java ----------------------------------------------------------------------------------------------------------------
  implicit val JavaList: Converter[java.util.List] = new Converter[java.util.List] { def make[A] = (v, i) => new JavaList(v) }
  implicit val JavaCollection: Converter[java.util.Collection] = JavaList.asInstanceOf[Converter[java.util.Collection]]
  implicit val JavaIterator: Converter[java.util.Iterator] = Iterator.asInstanceOf[Converter[java.util.Iterator]]

  // ******************************************************************************
  private class Idx[A](v: A) extends scalqa.Idx[A] { def size = 1; def apply(i: Int) = v }
  private class IndexedSeq[A](v: A) extends collection.AbstractSeq[A] with scala.IndexedSeq[A] { def length = 1; def apply(i: Int) = v }
  private class Iterator[A](var o: Opt[A]) extends collection.AbstractIterator[A] with java.util.Iterator[A] { def hasNext = o; def next: A = { val v = o.value; o = \/; v } }
  private class JavaList[A](v: A) extends java.util.AbstractList[A] { def size = 1; def get(i: Int) = v }
}
