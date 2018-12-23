package scalqa; package Stream; package Z; package A

private[scalqa] class Void extends Stream.A.Base[Any] with Preview[Any] with Util.Void with Any.Able.Stream[Any] {

  // -----------------------------------------------------------------------
  @inline final def prime = false
  @inline final def pump = Stream.failEmpty
  @inline final override def foreach(f: Consumer[Any]) = ()
  @inline final override def take(i: Int) = this
  @inline final override def ilkOpt = Ilk.Refs
  @inline final override def sizeOpt = 0

  // Buffer ----------------------------------------------------------------
  @inline final override def preview = this
  @inline final def previewIlk = Ilk.Refs
  @inline final def preview(cnt: Int) = this
  @inline final def previewNextOpt = Opt.Void
  @inline final def previewSize = 0
  @inline final def previewSizeAtLeast(cnt: Int) = cnt <= 0
  @inline final def takeWhile(f: Filter[Any]) = this
  @inline final def prime(cnt: Int) = 0

  // add --------------------------------------------------------------------
  @inline final override def +(element: Any): Stream[Any] = One(element)
  @inline final override def +~(that: ~[Any]) = that
  @inline final override def insertAt(index: Int, element: Any) = this + element
  @inline final override def insertAllAt(index: Int, that: ~[Any]) = that
  @inline final override def default(element: => Any) = element.I.~

  @inline final def all = this

}

private[scalqa] object Void extends Void

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
