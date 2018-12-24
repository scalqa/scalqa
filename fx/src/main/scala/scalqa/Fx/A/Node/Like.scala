package scalqa; package Fx; package A; package Node

abstract class Like protected[Fx] extends Delegate.Gui {
  protected type REAL <: javafx.scene.Node

}
object Like {

  def make(real: javafx.scene.Node): Like = real.onZoomFinishedProperty.get match {
    case v: Delegate.Gui.Z.EventHandlerRef => Module.make(real)
    case _ => Node.Map(real)
  }

  val Map = BiMap[javafx.scene.Node, Like](make, _.real)

  implicit def zzNode(v: Like): A.Node = v.I.as[A.Node](v => A.Node.make(v.real))
}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
