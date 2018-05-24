package scalqa; package Lookup; package Val

abstract class _Class[A, B] private[Val] extends Lookup[A, B] with Able.Void with Able.Plus[(A, B)] with Able.Minus[A] {
  protected type TARGET = _Class[A, B]

  protected def _target = this

}

object _Class {

  import scala.language.implicitConversions

  implicit def zzGet[A, B](v: \/.type): _Class[A, B] = Void.cast; private val Void = new Z.The[Any, Any](ScalaVoid)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
