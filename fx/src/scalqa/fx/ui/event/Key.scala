package scalqa; package fx; package ui; package event; import language.implicitConversions

import javafx.scene.input.KeyEvent
import javafx.beans.property.ObjectProperty;
import javafx.event.EventHandler;

class Key(e: KeyEvent, node: Abstract.Delegate.Gui) extends Input(e, node):
  protected type REAL <: KeyEvent

  def text          : String  = real.getText
  def isAltDown     : Boolean = real.isAltDown
  def isControlDown : Boolean = real.isControlDown
  def isShiftDown   : Boolean = real.isShiftDown

object Key:

  def subscribe[U](node: Abstract.Delegate.Gui, l: Ui.Event.Key => U, op: ObjectProperty[EventHandler[_ >: KeyEvent]]) =
    node._onFxEvent[KeyEvent, Ui.Event.Key, U](
      op.cast[ObjectProperty[EventHandler[KeyEvent]]],
      new Ui.Event.Key(_, node),
      l
    )

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
