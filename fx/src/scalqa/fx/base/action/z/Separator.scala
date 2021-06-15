package scalqa; package fx; package base; package action; package z

private[fx] class Separator extends Action:
  protected type REAL = javafx.scene.control.SeparatorMenuItem
  protected override def _createReal : REAL      = new REAL

  override           def toMenuItem : Menu.Item = Menu.Item(this)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
