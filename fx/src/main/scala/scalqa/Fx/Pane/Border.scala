package scalqa; package Fx; package Pane

import Fx.A.Node

class Border extends Pane {
  protected type REAL = javafx.scene.layout.BorderPane
  protected override def _createGui = new REAL

  def bottomPro = Custom.ProWO(real.bottomProperty).asBiMappedView(Node.Map); def bottom = Fx.A.Node.Map(real.getBottom); def bottom_=(n: Node) = real.setBottom(n.real)

  def topPro = Custom.ProWO(real.topProperty).asBiMappedView(Node.Map); def top = Node.Map(real.getTop); def top_=(n: Node) = real.setTop(n.real)

  def leftPro = Custom.ProWO(real.leftProperty).asBiMappedView(Node.Map); def left = Node.Map(real.getLeft); def left_=(n: Node) = real.setLeft(n.real)

  def rightPro = Custom.ProWO(real.rightProperty).asBiMappedView(Node.Map); def right = Node.Map(real.getRight); def right_=(n: Node) = real.setRight(n.real)

  def centerPro = Custom.ProWO(real.centerProperty).asBiMappedView(Node.Map); def center = Node.Map(real.getCenter); def center_=(n: Node) = real.setCenter(n.real)

}

object Border {

  def make = new Border()

  def withCenter(n: Fx.A.Node) = new Border().I(_.center = n)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
