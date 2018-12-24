package scalqa; package Stream; package Z; package extend; package flow; package preview

// This trait does not touch array, so all specialized handling must be in extending class
private[Stream] trait Base[@specialized(DATA) A] extends Preview[A] { self: Stream[A] =>
  protected var allIn = false
  protected var _strt, _end = -1

  def bufHas = _strt < _end
  def bufClear = _strt = _end
  def bufSize = _end - _strt
  protected def bufPop: A
  protected def real: Stream[A]

  def prime = bufHas || real.prime

  def pump = if (bufHas) bufPop else real.pump

  override def foreach(c: Consumer[A]) = { while (bufHas) c.accept(bufPop); real.foreach(c) }

  override def previewIlk: Any.Ilk = real.ilkOpt orOpt previewNextOpt.map(_.I.ilk) or Ilk.Refs

  override def previewSize = if (allIn) bufSize else real.sizeOpt.map(_ + bufSize) or primeAll

  override def previewSizeAtLeast(cnt: Int) = bufSize >= cnt || (real.sizeOpt or prime(cnt)) >= cnt

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
