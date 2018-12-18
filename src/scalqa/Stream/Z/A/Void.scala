package scalqa; package Stream; package Z; package A

private[scalqa] class Void extends Stream.A.Base[Any] with Preview[Any] with Util.Void with Any.Able.Stream[Any] {

  // -----------------------------------------------------------------------
  @inline def prime = false
  @inline def pump = Stream.failEmpty
  @inline override def foreach(f: Consumer[Any]) = ()
  @inline override def take(i: Int) = this
  @inline override def ilkOpt = Ilk.Objects
  @inline override def sizeOpt = 0

  // Buffer ----------------------------------------------------------------
  @inline override def preview = this
  @inline def previewIlk = Ilk.Objects
  @inline def preview(cnt: Int) = this
  @inline def previewNextOpt = Opt.Void
  @inline def previewSize = 0
  @inline def previewSizeAtLeast(cnt: Int) = cnt <= 0
  @inline def takeWhile(f: Filter[Any]) = this
  @inline def prime(cnt: Int) = 0

  // add --------------------------------------------------------------------
  @inline override def +(element: Any): Stream[Any] = One(element)
  @inline override def +~(that: ~[Any]) = that
  @inline override def insertAt(index: Int, element: Any) = this + element
  @inline override def insertAllAt(index: Int, that: ~[Any]) = that
  @inline override def default(element: => Any) = element.I.~

  @inline def all = this

}

private[scalqa] object Void extends Void

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
