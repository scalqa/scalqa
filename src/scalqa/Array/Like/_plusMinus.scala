package scalqa; package Array; package Like

trait _plusMinus[A, SELF] extends Any with Able.Plus.Tagged[A] with Able.Plus.At.Tagged[A] with Able.Minus[A] with Able.Minus.At[A] with __[A, _Class] {
  protected type TARGET = SELF

  protected def _minusRange(al: SELF, r: Int.Range): SELF = _get(al.cast[_plusMinus[A, SELF]].This.copyDrop(r).cast).cast

  @inline protected def _plusAt(i: Int, v: A, t: Tag[A]): SELF = _get(copyResize(_raw.length + 1)(t).withinInsertAt(i, v)).cast
  @inline protected def _plusAllAt(i: Int, all: ~[A], s: Int, t: Tag[A]): SELF = _get(copyResize(_raw.length + s)(t).withinInsertAt(i, all)).cast

  @inline protected override def _plus(v: A, t: Tag[A]): SELF = _get({ val a = copyResize(_raw.length + 1)(t); a(size) = v; a }).cast

  @inline override def +(v: A)(implicit t: Tag[A] = \/): SELF = _get(new Array({
    val a = (t ? v.Class.tag).newArrayRaw[A](_raw.length + 1)
    if (_raw.length > 0) System.arraycopy(_raw, 0, a, 0, _raw.length)
    a(_raw.length) = v
    a
  })).cast

  protected def _get(a: Array[A]): Like[A, SELF]
  protected def _target: SELF = this.cast

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
