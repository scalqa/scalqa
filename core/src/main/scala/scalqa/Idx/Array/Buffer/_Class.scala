package scalqa; package Idx.Array; package Buffer

abstract class _Class[@specialized(DATA) A] private[Buffer] extends Loader[A] with Idx.M[A] with Any.Able.ToInfo {
  private[Buffer] var _size = 0
  private[Buffer] var _arrayLen = _array.length

  @inline protected def array = _array

  @inline final def size: Int = _size
  @inline final override def all: Stream[A] = Custom.Array.Z.stream[A](_array.asInstanceOf[Array[A]], _size)

  @inline final def loader: Loader[A] = Z.DefaultLoader(this)

  @inline final override def addAt(i: Int, a: A) = Z.add.at(i, a, this)
  @inline final override def addAllAt(i: Int, all: ~[A]): Unit = Z.add.allAt(i, all, this)
  @inline final override def addAll(s: ~[A]) = s.copyTo(this)
  override def add(v: A): Unit = {
    val sz = _size
    if (_arrayLen <= sz) growArray(sz + 1)
    update(sz, v): @inline
    _size = sz + 1
  }

  @inline final def removeAt(r: Idx.Range): Unit = Z.update.removeAt(r, this)
  def refreshAt(r: Idx.Range): Unit = r.all.letAt(size.Range).map(apply).letType[Any.Able.Refresh].foreach(_.refresh)
  override def reposition(r: Idx.Range.Reposition): Unit = r.apply(this, update)

  def toArray(implicit ct: ClassTag[A]): Array[A] = { val a = ct.newArray(size); System.arraycopy(_array, 0, a, 0, size); a }
  def copyTo(a: Array[A]): Unit = System.arraycopy(_array, 0, a, 0, size min a.length)
  def arrayBase[B >: A]: Array[B] = { if (_size != _array.length) _arrayResize(size); _array.asInstanceOf[Array[B]] }

  def toInfo = new Pro.Info(this) += (("size", _size))

  private[Buffer] def growArray(need: Long): Unit = {
    var l = if (_arrayLen <= 1) 2L else _arrayLen * 2L
    while (l < need) l *= 2L
    _arrayLen = if (l > Int.MaxValue) Int.MaxValue else l.toInt
    _arrayResize(_arrayLen): @inline
  }
}

object _Class {

  implicit def zzMake[A: Ilk](v: NEW.type): Buffer[A] = Buffer.make[A]

}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
