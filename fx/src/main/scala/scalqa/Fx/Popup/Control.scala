package scalqa; package Fx.Popup

import javafx.scene.control.PopupControl

class Control extends Window {

  protected type REAL <: PopupControl

  protected override def _createGui: REAL = new PopupControl().asInstanceOf[REAL]

}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
