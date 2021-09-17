package scalqa; package fx; package base; package `abstract`; import node.*; import language.implicitConversions

trait Node extends Like with _properties with _Events with _methods:

  private[fx] override def _refPropertyOpt = real.onZoomStartedProperty.?

object Node:

  def apply(v: javafx.scene.Node): Fx.Node = new Fx.Node { protected type REAL = javafx.scene.Node;  def _createReal = v }

  given FxConverter: ReversibleFunction[javafx.scene.Node, Node] = ReversibleFunction(v => Delegate.Gui.apply[Fx.Node](v.onZoomStartedProperty), _.real)

  // Members ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  type Like        = node.Like;          transparent inline def Like = node.Like
  type _events     = node._Events
  type _methods    = node._methods
  type _properties = node._properties

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
