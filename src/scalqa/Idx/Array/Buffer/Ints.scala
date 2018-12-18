package scalqa; package Idx.Array; package Buffer

class Ints protected (private[Buffer] var _array: Array[Int]) extends Buffer[Int] {
  def this(iSize: Opt.Int = \/) = this(new Array[Int](iSize orVal App.initSize))

  def apply(i: Int): Int = _array(i)

  def update(i: Int, v: Int) = _array(i) = v

  private[Buffer] def _arrayResize(sz: Int) = {
    val a = new Array[Int](sz)
    System.arraycopy(_array, 0, a, 0, size);
    _array = a
  }

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
