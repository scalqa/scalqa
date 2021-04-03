package scalqa; package fx; package `abstract`; package node; package _Events; import language.implicitConversions

transparent trait _onTouch:
  self: Node =>

  def onTouchPressed   [U](l: Event.Touch => U) : Event.Control = onTouch(l, real.onTouchPressedProperty)
  def onTouchReleased  [U](l: Event.Touch => U) : Event.Control = onTouch(l, real.onTouchReleasedProperty)
  def onTouchMoved     [U](l: Event.Touch => U) : Event.Control = onTouch(l, real.onTouchMovedProperty)
  def onTouchStationary[U](l: Event.Touch => U) : Event.Control = onTouch(l, real.onTouchStationaryProperty)

  // ------------------------------------------------------------------------------------------------
  import javafx.scene.input.{ TouchEvent => EVENT }

  private def onTouch[U](l: Event.Touch => U, op: ObjectProperty[EventHandler[_ >: EVENT]]) =
    _onFxEvent[EVENT, Event.Touch, U](op.cast[ObjectProperty[EventHandler[EVENT]]], new Event.Touch(_, this), l)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**

@def onTouchPressed -> On touch pressed

      Defines a function to be called when a new touch point is pressed


@def onTouchReleased -> On touch released

      Defines a function to be called when a touch point is released


@def onTouchMoved -> On touch moved

      Defines a function to be called when a touch point is moved


@def onTouchStationary -> On touch stationary

      Defines a function to be called when a touch point stays pressed and still

*/
