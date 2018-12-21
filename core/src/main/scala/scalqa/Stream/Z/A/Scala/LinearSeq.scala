package scalqa; package Stream; package Z; package A; package Scala

private[scalqa] object LinearSeq {

  def toStream[@specialized(DATA) A](v: collection.LinearSeq[A])(implicit i: Ilk[A]): Stream[A] with Any.Able.Stream[A] = {
    class stream extends Stream[A] with Stream.A.Specialized[A] with Any.Able.Stream[A] {
      protected var real: collection.LinearSeq[A] = v

      @inline def prime = real.nonEmpty

      @inline def pump = { val v = real.head; real = real.tail; v }

      override def foreach(c: Consumer[A]) = { var v = real; real = Nil; while (v.nonEmpty) { c.accept(v.head); v = v.tail } }

      override def to[T[A]](implicit c: Stream.Interface.To.Converter[T]): T[A] = GenTraversableOnce.customTo(c, real, this)

      override def copyTo(b: scalqa.Idx.Array.Buffer.Loader[A]) = { var v = real; real = Nil; while (v.nonEmpty) { b.add(v.head); v = v.tail } }

      override def ilkOpt = i.ilkOpt

      @inline def all = this
    }
    new stream
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
