package scalqa; package Fx; package Menu

class Bar extends Fx.A.Control {
  protected type REAL = javafx.scene.control.MenuBar
  protected override def _createGui = new REAL

  def this(p: ~[Menu]) = {
    this
    p(m => real.getMenus.add(m.real))
  }

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
