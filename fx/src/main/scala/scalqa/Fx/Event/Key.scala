package scalqa; package Fx; package Event

import javafx.scene.input.KeyEvent
import javafx.beans.property.ObjectProperty;
import javafx.event.EventHandler;

class Key(e: KeyEvent, node: A.Node) extends Input(e, node) {
  protected type REAL <: KeyEvent

  def text = real.getText

  def isAltDown = real.isAltDown

  def isControlDown = real.isControlDown

  def isShiftDown = real.isShiftDown

}

object Key {

  def subscribe(node: A.Node, on: Event.Key => Any, op: ObjectProperty[EventHandler[_ >: javafx.scene.input.KeyEvent]]) =
    node.onFxEvent[javafx.scene.input.KeyEvent, Event.Key](op.I.asInstanceOfTarget, e => new Event.Key(e, node), on)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
