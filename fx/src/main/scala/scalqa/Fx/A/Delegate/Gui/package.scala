package scalqa; package Fx; package A; package Delegate

import javafx.event.EventHandler
import javafx.beans.property.ObjectProperty

package object Gui {

  def make[A <: Gui](p: ObjectProperty[_ <: EventHandler[_]]): A = p.get.asInstanceOf[Z.EventHandlerRef].gui.asInstanceOf[A]

}
