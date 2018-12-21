package scalqa; package Fx; package Menu

class Button extends Button.Like {
  protected type REAL = javafx.scene.control.MenuButton
  protected override def _createGui = new REAL

  def this(text: String, n: Fx.A.Node.Like) = { this; _onCreateGuiRun(new REAL(text, n.real)) }

  def this(text: String, n: Fx.A.Node.Like, it: ~[Item]) = { this(text, n); items +~= it }

  def this(text: String) = this(text, null)

  def items = Idx.M.wrap(real.getItems).asBiMappedView(Item.map)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
