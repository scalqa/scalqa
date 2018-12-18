package scalqa; package Idx.Array; package Buffer

class Refs[A] protected (private[Buffer] var _array: Array[AnyRef]) extends Buffer[A] {
  def this(iSize: Opt.Int = \/) = this(new Array[AnyRef](iSize orVal App.initSize))

  def apply(idx: Int): A = _array(idx).asInstanceOf[A]

  def update(i: Int, v: A) = _array(i) = v.asInstanceOf[AnyRef]

  private[Buffer] def _arrayResize(sz: Int): Unit = {
    val a = new Array[AnyRef](sz)
    System.arraycopy(_array, 0, a, 0, size)
    _array = a
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
