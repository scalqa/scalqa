package scalqa; package Index; package W; package The

abstract class ArrayBase[A] protected extends W[A] with Able.Info {
  protected var _size = 0

  def size: Int = _size

  def addAt(i: Int, a: A) {
    //    assert(i >= 0 && i <= _size, _failIndex(i))
    if (_arraySize <= _size) if (_arraySize == 0) _arraySetup(a) else _arrayGrow(_size + 1)
    if (i < _size) _arrayCopySelf(i <>> _size, i + 1)
    _size += 1
    _arrayUpdate(i, a)
  }

  def removeAt(r: Int.Range): Unit = {
    assert(r.end <= _size, _failIndex(_size - 1))
    if (r.end < _size) _arrayCopySelf(r.end <>> _size, r.start)
    _size -= r.size;
  }

  def replaceAt(i: Int, a: A): Unit = {
    assert(i >= 0 && i <= _size, _failIndex(i))
    _arrayUpdate(i, a)
  }

  def refreshAt(r: Int.Range): Unit = r.all.letAt(size.Range).map(apply).apply(Able.Refresh.apply)

  override def reposition(r: Int.Range.Reposition): Unit = r.apply(this, _arrayUpdate)

  protected def info = \/.info ~ ("size", size)

  // ----------------------------------------------------------------------------------------------------------------------------------
  protected def _arraySize: Int
  protected def _arrayCopySelf(r: Int.Range, i: Int): Unit
  protected def _arrayUpdate(i: Int, v: A): Unit
  protected def _arraySetup(v: A): Unit
  protected def _arrayGrow(s: Int): Unit
  protected def _failIndex(i: Int) = "Index : " + i + " out of range " + (if (size == 0) "for EMPTY list" else "from 0 end " + size)
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
