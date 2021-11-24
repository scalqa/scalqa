package scalqa; package fx; package base; package `abstract`; package node; import language.implicitConversions

abstract class Like protected[fx] extends delegate.Gui:
  protected type REAL <: javafx.scene.Node

  def sceneOpt : Opt[Fx.Scene] = Scene(real.getScene())

object Like:

  def apply(real: javafx.scene.Node): Like = real.onZoomFinishedProperty.get match
    case _ : delegate.Z.RefEventDispatch => Module(real)
    case _ => Node.FxConverter(real)

  given FxConverter: TwoWayFunction[javafx.scene.Node, Like] = TwoWayFunction(apply, _.real)

  implicit def implicitToNode(v: Like) : Fx.Node = v match { case v: Fx.Node => v; case v => Node(v.real) }

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
