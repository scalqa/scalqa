package scalqa; package Fx; package A; package Node; package _events

trait _onTouch { self: Node =>

  def onTouchPressed(on: Event.Touch => Any) = onTouch(on, real.onTouchPressedProperty)

  def onTouchReleased(on: Event.Touch => Any) = onTouch(on, real.onTouchReleasedProperty)

  def onTouchMoved(on: Event.Touch => Any) = onTouch(on, real.onTouchMovedProperty)

  def onTouchStationary(on: Event.Touch => Any) = onTouch(on, real.onTouchStationaryProperty)

  // ------------------------------------------------------------------------------------------------
  private def onTouch(on: Event.Touch => Any, op: ObjectProperty[EventHandler[_ >: javafx.scene.input.TouchEvent]]) =
    _onFxEvent[javafx.scene.input.TouchEvent, Event.Touch](op.I.asInstanceOfTarget, e => new Event.Touch(e, this), on)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 *  @def onTouchPressed -> On touch pressed
 *
 *    Defines a function to be called when a new touch point is pressed
 *
 *  @def onTouchReleased -> On touch released
 *
 *    Defines a function to be called when a touch point is released
 *
 *  @def onTouchMoved -> On touch moved
 *
 *    Defines a function to be called when a touch point is moved
 *
 *  @def onTouchStationary -> On touch stationary
 *
 *    Defines a function to be called when a touch point stays pressed and still
 */
