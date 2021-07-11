package scalqa; package fx; package scene; package pane; import language.implicitConversions

import base.`abstract`.Node

class Border extends Pane:
  protected type REAL = javafx.scene.layout.BorderPane
  protected override def _createReal = new REAL

  @tn("bottom_Pro") def bottom_*            : Pro.OM[Fx.Node] = Fx.JavaFx.To.pro_OM(real.bottomProperty).mutableMap_^[Fx.Node]
  /**/              def bottom              : Fx.Node         = Fx.Node.FxConverter(real.getBottom)
  /**/              def bottom_=(n: Fx.Node): Unit            = real.setBottom(n.real)
  @tn("top_Pro")    def top_*               : Pro.OM[Fx.Node] = Fx.JavaFx.To.pro_OM(real.topProperty).mutableMap_^[Fx.Node]
  /**/              def top                 : Fx.Node         = Fx.Node.FxConverter(real.getTop)
  /**/              def top_=(n: Fx.Node)   : Unit            = real.setTop(n.real)
  @tn("left_Pro")   def left_*              : Pro.OM[Fx.Node] = Fx.JavaFx.To.pro_OM(real.leftProperty).mutableMap_^[Fx.Node]
  /**/              def left                : Fx.Node         = Fx.Node.FxConverter(real.getLeft)
  /**/              def left_=(n: Fx.Node)  : Unit            = real.setLeft(n.real)
  @tn("right_Pro")  def right_*             : Pro.OM[Fx.Node] = Fx.JavaFx.To.pro_OM(real.rightProperty).mutableMap_^[Fx.Node]
  /**/              def right               : Fx.Node         = Fx.Node.FxConverter(real.getRight)
  /**/              def right_=(n: Fx.Node) : Unit            = real.setRight(n.real)
  @tn("center_Pro") def center_*            : Pro.OM[Fx.Node] = Fx.JavaFx.To.pro_OM(real.centerProperty).mutableMap_^[Fx.Node]
  /**/              def center              : Node            = Fx.Node.FxConverter(real.getCenter)
  /**/              def center_=(n: Fx.Node): Unit            = real.setCenter(n.real)

object Border:
  def apply()          : Border = Border()
  def node(n: Fx.Node) : Border = Border().^(_.center = n)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
