package scalqa; package Fx; package Action; package Z

private[Fx] class Separator extends Action {
  protected type REAL = javafx.scene.control.SeparatorMenuItem
  protected override def _createGui = new REAL

  override def toMenuItem = new Menu.Item(this)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
