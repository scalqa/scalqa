package scalqa; package fx; package scene; package event

import javafx.scene.input.InputEvent

class Input(real: InputEvent, val node: Abstract.Delegate.Gui) extends Event(real):
  protected type REAL <: InputEvent

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
