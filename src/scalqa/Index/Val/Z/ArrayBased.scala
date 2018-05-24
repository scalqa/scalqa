package scalqa; package Index; package Val; package Z

private class ArrayBased[A] private[Z] (protected val raw: Array.Raw[_ >: A]) extends Val[A] with Array.Like[A, Val[A]] {
  protected override type TARGET = Val[A]

  protected override def _get(a: Array[A]) = new ArrayBased(a.raw)

  override def all = new all(this)

  protected override def _target = this

}

private object ArrayBased {

  // ****************************************************************************************************
  class ValWrap[A, B] private[Z] (private val raw: Array.Raw[_ >: B], private val companion: Any.Value.Companion[A, B]) extends Val[A] with Able.Info {
    private[Z] def this(i: Any.Value.Companion[A, B], a: Array[B]) = this(a.raw, i)

    @inline private def array: Array[B] = new Array(raw)

    def apply(i: Int): A = companion.map(array(i))
    def size = array.size

    def _minusRange(vl: Val[A], r: Int.Range): Val[A] = new ValWrap(companion, vl.cast[ValWrap[A, B]].array.copyDrop(r))

    @inline def _plusAt(i: Int, a: A, t: Tag[A]): Val[A] = new ValWrap(companion, array.+@(i, companion.undo(a))(companion.tag))
    @inline def _plusAllAt(i: Int, all: ~[A], sz: Int, t: Tag[A]): Val[A] = new ValWrap(companion, array.+~@(i, all.map(companion.undo))(companion.tag))

    @inline override def +(v: A)(implicit t: Tag[A] = \/): Val[A] =
      new ValWrap[A, B](if (raw.length > 0) raw :+ companion.undo(v) else (t ? v.Class.tag).newArrayRaw(1).I(_(0) = companion.undo(v).cast).cast, companion)

    protected def info = \/.info ~ ("size", size) ~ ("array", array.raw.Class)

    override def all = new all(this)

  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/