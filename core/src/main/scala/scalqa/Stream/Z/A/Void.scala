package scalqa; package Stream; package Z; package A

private[scalqa] class Void extends Stream.A.Base[Any] with Preview[Any] with Util.Void with Any.Able.Stream[Any] {

  // -----------------------------------------------------------------------
  def prime = false
  def pump = Stream.failEmpty
  override def foreach(f: Consumer[Any]) = ()
  override def take(i: Int) = this
  override def ilkOpt = Ilk.Refs
  override def sizeOpt = 0

  // Buffer ----------------------------------------------------------------
  override def preview = this
  def previewIlk = Ilk.Refs
  def preview(cnt: Int) = this
  def previewNextOpt = Opt.Void
  def previewSize = 0
  def previewSizeAtLeast(cnt: Int) = cnt <= 0
  def takeWhile(f: Filter[Any]) = this
  def prime(cnt: Int) = 0

  // add --------------------------------------------------------------------
  override def +(element: Any): Stream[Any] = One(element)
  override def +~(that: ~[Any]) = that
  override def insertAt(index: Int, element: Any) = this + element
  override def insertAllAt(index: Int, that: ~[Any]) = that
  override def default(element: => Any) = element.I.~

  def all = this

}

private[scalqa] object Void extends Void

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
