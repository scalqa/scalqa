package scalqa; package Stream; package Z; package A; package Scala

private[scalqa] object IndexedSeq {

  def toStream[@specialized(DATA) A](v: scala.IndexedSeq[A])(implicit i: Ilk[A]): Stream[A] with Any.Able.Stream[A] = new Stream[A] with Stream.A.Specialized.Indexed[A] with Any.Able.Stream[A] {

    override val _size = v.size

    override def _apply(i: Int): A = v(i)

    override def pump = { _position += 1; v(_position - 1) }

    override def foreach(c: Consumer[A]) = { var i = _position; while (i < _size) { c.accept(v(i)); i += 1 }; _position = i }

    override def copyTo(b: scalqa.Idx.Array.Buffer.Loader[A]): Unit = {
      val a = b.newArrayBase(v.size - _position);
      v.copyToArray(a, _position);
      b.addFromArray(a)
    }

    override def to[T[A]](implicit c: Stream.Interface.To.Converter[T]): T[A] = if (_position > 0) super.to(c) else GenTraversableOnce.customTo(c, v, this)

    override def ilkOpt = i.ilkOpt

    @inline def all = this
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
