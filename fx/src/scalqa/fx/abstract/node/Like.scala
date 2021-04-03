package scalqa; package fx; package `abstract`; package node; import language.implicitConversions

abstract class Like protected[fx] extends Delegate.Gui:
  protected type REAL <: javafx.scene.Node

  def scene_?    : Opt[Fx.Scene] = Scene(real.getScene())

object Like:

  def apply(real: javafx.scene.Node): Like = real.onZoomFinishedProperty.get match
    case _ : delegate.gui.Z.RefEventDispatch => Module(real)
    case _ => Node.FxConverter(real)

  given FxConverter: TwoWayFun[javafx.scene.Node, Like] = TwoWayFun(apply, _.real)

  implicit def xx_Node(v: Like) : Node = v match { case v: Node => v; case v => Node(v.real) }

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
