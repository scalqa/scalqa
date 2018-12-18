package scalqa; package Stream; package A; package Specialized

trait Indexed[@specialized(DATA) A] extends Specialized[A] with Preview[A] { self: Stream[A] with Preview[A] =>

  protected[Stream] var _position = 0

  protected def _size: Int

  protected def _apply(i: Int): A

  @inline final def prime = _position < _size

  @inline final override def sizeOpt: Opt.Int = _size - _position max 0

  // Buffer --------------------------------------------------------------------------
  def prime(cnt: Int) = _size - _position

  def previewIlk: Any.Class.Ilk = ilkOpt or { if (_position < _size) _apply(_position).Class.ilk else Ilk.Objects }

  def preview(cnt: Int) = Z.preview[A](this, cnt)

  def previewNextOpt = if (_position < _size) _apply(_position) else Opt.Void

  def previewSize = _size - _position

  def previewSizeAtLeast(cnt: Int) = previewSize >= cnt

  def takeWhile(f: Filter[A]): ~[A] = Z.takeWhile[A](this, f)
}

private[scalqa] object Indexed {

  @inline def size(v: Indexed[_]) = v._size

  @inline def apply[@specialized(DATA) A](v: Indexed[A], i: Int): A = v._apply(i)

  def pump[@specialized(DATA) A](x: Indexed[A]): A = {
    val v = x._apply(x._position)
    x._position += 1;
    v
  }

  def foreach[@specialized(DATA) A](v: Indexed[A], c: Consumer[A]): Unit = {
    val sz = v._size
    var i = v._position
    while (i < sz) { c.accept(v._apply(i)); i += 1 }
    v._position = i
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
