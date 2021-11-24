package scalqa; package fx; package scene; package pane; import language.implicitConversions

import base.`abstract`.Node

class Border extends Pane:
  protected type REAL = javafx.scene.layout.BorderPane
  protected override def _createReal = new REAL

  def bottomPro           : Pro.OM[Fx.Node] = Fx.JavaFx.To.pro_OM(real.bottomProperty).mutableMapView[Fx.Node]
  def bottom              : Fx.Node         = Fx.Node.FxConverter(real.getBottom)
  def bottom_=(n: Fx.Node): Unit            = real.setBottom(n.real)
  def topPro              : Pro.OM[Fx.Node] = Fx.JavaFx.To.pro_OM(real.topProperty).mutableMapView[Fx.Node]
  def top                 : Fx.Node         = Fx.Node.FxConverter(real.getTop)
  def top_=(n: Fx.Node)   : Unit            = real.setTop(n.real)
  def leftPro             : Pro.OM[Fx.Node] = Fx.JavaFx.To.pro_OM(real.leftProperty).mutableMapView[Fx.Node]
  def left                : Fx.Node         = Fx.Node.FxConverter(real.getLeft)
  def left_=(n: Fx.Node)  : Unit            = real.setLeft(n.real)
  def rightPro            : Pro.OM[Fx.Node] = Fx.JavaFx.To.pro_OM(real.rightProperty).mutableMapView[Fx.Node]
  def right               : Fx.Node         = Fx.Node.FxConverter(real.getRight)
  def right_=(n: Fx.Node) : Unit            = real.setRight(n.real)
  def centerPro           : Pro.OM[Fx.Node] = Fx.JavaFx.To.pro_OM(real.centerProperty).mutableMapView[Fx.Node]
  def center              : Node            = Fx.Node.FxConverter(real.getCenter)
  def center_=(n: Fx.Node): Unit            = real.setCenter(n.real)

object Border:
  def apply()          : Border = Border()
  def node(n: Fx.Node) : Border = Border().self(_.center = n)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
