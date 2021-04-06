package scalqa; package fx; package control; package popup; import language.implicitConversions

import javafx.scene.control.PopupControl

class Control extends Window:
  protected type REAL <: PopupControl
  protected override def _createReal: REAL = new PopupControl().cast[REAL]


/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
