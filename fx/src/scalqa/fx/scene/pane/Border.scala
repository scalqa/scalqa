package scalqa; package fx; package scene; package pane; import language.implicitConversions

import base.`abstract`.Node

class Border extends Pane:
  protected type REAL = javafx.scene.layout.BorderPane
  protected override def _createReal = new REAL

  @tn("bottom_Pro") def bottom_*          : Pro.OM[Node] = Fx.JavaFx.To.pro_OM(real.bottomProperty).mutableMap_^[Node]
  /**/              def bottom            : Node         = Node.FxConverter(real.getBottom)
  /**/              def bottom_=(n: Node) : Unit         = real.setBottom(n.real)
  @tn("top_Pro")    def top_*             : Pro.OM[Node] = Fx.JavaFx.To.pro_OM(real.topProperty).mutableMap_^[Node]
  /**/              def top               : Node         = Node.FxConverter(real.getTop)
  /**/              def top_=(n: Node)    : Unit         = real.setTop(n.real)
  @tn("left_Pro")   def left_*            : Pro.OM[Node] = Fx.JavaFx.To.pro_OM(real.leftProperty).mutableMap_^[Node]
  /**/              def left              : Node         = Node.FxConverter(real.getLeft)
  /**/              def left_=(n: Node)   : Unit         = real.setLeft(n.real)
  @tn("right_Pro")  def right_*           : Pro.OM[Node] = Fx.JavaFx.To.pro_OM(real.rightProperty).mutableMap_^[Node]
  /**/              def right             : Node         = Node.FxConverter(real.getRight)
  /**/              def right_=(n: Node)  : Unit         = real.setRight(n.real)
  @tn("center_Pro") def center_*          : Pro.OM[Node] = Fx.JavaFx.To.pro_OM(real.centerProperty).mutableMap_^[Node]
  /**/              def center            : Node         = Node.FxConverter(real.getCenter)
  /**/              def center_=(n: Node) : Unit         = real.setCenter(n.real)

object Border:
  def apply()            : Border = Border()
  def node(n: Node) : Border = Border().^(_.center = n)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
