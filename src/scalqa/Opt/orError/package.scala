package scalqa; package Opt

package object orError {

  val Void = new _Class[Nothing](Z.Empty.Void)

  def get[T](v: => T): orError[T] = try { new orError[T](v) } catch { case t: Throwable => getError(t) }

  def getError[T](m: String): orError[T] = getError(new Exception(m))

  def getError[T](t: Throwable): orError[T] = t match {
    case null => Fail()
    case t: scala.runtime.NonLocalReturnControl[_] => get(t.value.cast[T])
    case t => new orError[T](new Z.Empty(t))
  }

  def getTryCatch[T](v: => orError[T]): orError[T] = try { v } catch { case t: Throwable => getError(t) }

  def get[A](v: scala.util.Try[A]): orError[A] = if (v.isSuccess) get(v.get) else getError(v.failed.get)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/