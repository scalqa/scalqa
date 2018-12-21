package scalqa; package Fx; package Text

class Area(text: Opt[String]) extends InputControl(text) {
  protected type REAL = javafx.scene.control.TextArea

  protected override def _createGui = new REAL

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
