package scalqa; package Fx; package A; package Delegate; package Gui; package Z

import javafx.event.EventHandler
import javafx.event.Event
import javafx.beans.property.ObjectProperty

private[A] class EventHandlerRef(val gui: Gui, property: ObjectProperty[EventHandler[Event]]) extends EventHandler[Event] {

  def handle(e: Event): Unit = gui.fireFxEvent[Event](property, e)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
