package scalqa; package Idx.Array; package Buffer

class Floats protected (private[Buffer] var _array: Array[Float]) extends Buffer[Float] {
  def this(iSize: Opt.Int = \/) = this(new Array[Float](iSize orVal App.initSize))

  def apply(i: Int) = _array(i)

  def update(i: Int, v: Float) = _array(i) = v

  private[Buffer] def _arrayResize(sz: Int) = {
    val a = new Array[Float](sz)
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
