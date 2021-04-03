package scalqa; package fx; package scene; package event

import javafx.scene.input.ZoomEvent

class Zoom(real: ZoomEvent, node: Node) extends Gesture(real, node):
  protected type REAL <: ZoomEvent

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
