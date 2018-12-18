package scalqa; package Idx.Array; package Buffer

trait Loader[@specialized(DATA) A] {
  private[Buffer] def _array: Array[_]
  private[Buffer] def _arrayResize(size: Int): Unit
  private[Buffer] def _size: Int
  private[Buffer] def _size_=(v: Int)

  private[Buffer] def loadLimit = Int.MaxValue
  private[Buffer] def failLimit = App.Fail("Load limit of " + loadLimit + " is exceeded")

  def add(v: A)

  final def newArrayBase[B >: A](size: Int): Array[B] = Custom.Array.emptyAs(_array.asInstanceOf[Array[B]], size)

  final def addFromArray(a: Array[A], from: Int, len: Int) {
    val sz = _size + len
    if (sz > loadLimit) failLimit
    if (_array.length < sz) _arrayResize(sz)

    if (_array.getClass.isAssignableFrom(a.getClass)) {
      System.arraycopy(a, from, _array, _size, len)
    } else {
      var i = from
      val end = i + len
      while (i < end) { add(a(i)); i += 1 }
    }

    _size = sz
  }

  final def addFromArray(a: Array[A]): Unit = addFromArray(a, 0, a.length)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
