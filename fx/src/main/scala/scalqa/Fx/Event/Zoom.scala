package scalqa; package  Fx; package Event

import javafx.scene.input.ZoomEvent

class Zoom(real: ZoomEvent, node: A.Node) extends Gesture(real, node) {
  protected type REAL <: ZoomEvent

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/