package scalqa; package  Fx; package Event

import javafx.scene.input.InputEvent

class Input(real: InputEvent, val node: A.Node) extends Event(real) {
  protected type REAL <: InputEvent

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
