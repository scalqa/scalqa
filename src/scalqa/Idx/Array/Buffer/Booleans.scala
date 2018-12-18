package scalqa; package Idx.Array; package Buffer

class Booleans protected (private[Buffer] var _array: Array[Boolean]) extends Buffer[Boolean] {
  def this(iSize: Opt.Int = \/) = this(new Array[Boolean](iSize orVal App.initSize))

  def apply(i: Int) = _array(i)

  def update(i: Int, v: Boolean) = _array(i) = v

  private[Buffer] def _arrayResize(sz: Int) = {
    val a = new Array[Boolean](sz)
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
