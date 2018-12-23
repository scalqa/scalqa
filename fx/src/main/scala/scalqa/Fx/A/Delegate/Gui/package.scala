package scalqa; package Fx; package A; package Delegate

import javafx.event.EventHandler
import javafx.beans.property.ObjectProperty

package object Gui {

  def make[A <: Gui](p: ObjectProperty[_ <: EventHandler[_]]): A = p.get.asInstanceOf[Z.EventHandlerRef].gui.asInstanceOf[A]

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
