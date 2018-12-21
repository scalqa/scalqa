package scalqa; package Fx; package Popup;

class Menu extends Control {
  protected type REAL = javafx.scene.control.ContextMenu
  protected override def _createGui = new REAL

  lazy val items: Idx.M[Fx.Menu.Item] = Idx.M.wrap(real.getItems).asBiMappedView(Fx.Menu.Item.map)

  def show(n: A.Node, s: Side, x: Double, y: Double) = real.show(n.real, s.real, x, y)

  def show(n: A.Node): Unit = show(n, RIGHT, 0, 0)
}
object Menu {

  def make = new Menu

  def make(p: ~[_ <: Action]): Menu = make.I(_.items +~= p.map(Fx.Menu.Item.make))

}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
