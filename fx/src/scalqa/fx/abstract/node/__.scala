package scalqa; package fx; package `abstract`; import node.*; import language.implicitConversions

trait Node extends Like with _properties with _events with _methods:

  private[fx] override def _refPropertyOpt = real.onZoomStartedProperty.?

object Node:

  def apply(v: javafx.scene.Node): Node = new Node { protected type REAL = javafx.scene.Node;  def _createReal = v }

  given FxConverter: TwoWayFun[javafx.scene.Node, Node] = TwoWayFun(v => Delegate.Gui.apply[Node](v.onZoomStartedProperty), _.real)

  // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  type Like        = node.Like;         val Like = node.Like
  type _events     = node._events
  type _methods    = node._methods
  type _properties = node._properties

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
