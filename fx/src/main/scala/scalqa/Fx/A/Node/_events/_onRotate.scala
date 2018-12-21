package scalqa; package Fx; package A; package Node; package _events

trait _onRotate { self: Node =>

  def onRotate(on: Event.Rotate => Any) = _onRotate(on, real.onRotateProperty)

  def onRotationFinished(on: Event.Rotate => Any) = _onRotate(on, real.onRotationFinishedProperty)

  def onRotationStarted(on: Event.Rotate => Any) = _onRotate(on, real.onRotationStartedProperty)

  // ------------------------------------------------------------------------------------------------
  private def _onRotate(on: Event.Rotate => Any, op: ObjectProperty[EventHandler[_ >: javafx.scene.input.RotateEvent]]) =
    _onFxEvent[javafx.scene.input.RotateEvent, Event.Rotate](op.I.asInstanceOfTarget, e => new Event.Rotate(e, this), on)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 *  @def onRotate -> On rotate
 *
 *    Defines a function to be called when user performs a rotation action
 *
 *  @def onRotationFinished -> On rotation finished
 *
 *    Defines a function to be called when a rotation gesture ends
 *
 *  @def onRotationStarted -> On rotation started
 *
 *    Defines a function to be called when a rotation gesture is detected
 *
 */
