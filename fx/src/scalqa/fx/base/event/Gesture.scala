package scalqa; package fx; package base; package event

import javafx.scene.input.GestureEvent

class Gesture(real: GestureEvent, node: Fx.Node) extends Input(real, node):
  protected type REAL <: GestureEvent

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
