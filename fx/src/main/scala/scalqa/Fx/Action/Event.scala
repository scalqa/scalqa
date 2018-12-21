package scalqa; package Fx; package Action

import javafx.event.ActionEvent;

class Event(real: ActionEvent) extends Fx.Event(real) {
  protected type REAL <: ActionEvent

}

object Event {

  def apply(e: ActionEvent) = new Event(e)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
