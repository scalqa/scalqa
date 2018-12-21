package scalqa; package Fx; package A; package Node; package _events

trait _onKey { self: Node =>

  def onKeyPressed(on: Event.Key => Any) = Event.Key.subscribe(this.I.asInstanceOfTarget, on, real.onKeyPressedProperty)

  def onKeyReleased(on: Event.Key => Any) = Event.Key.subscribe(this.I.asInstanceOfTarget, on, real.onKeyReleasedProperty)

  def onKeyTyped(on: Event.Key => Any) = Event.Key.subscribe(this.I.asInstanceOfTarget, on, real.onKeyTypedProperty)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @def onKeyPressed -> On key pressed
 *
 *     Defines a function to be called when this Node or its child Node has input focus and a key has been pressed
 *
 * @def onKeyReleased -> On key released
 *
 *     Defines a function to be called when this Node or its child Node has input focus and a key has been released
 *
 * @def onKeyPressed -> On key typed
 *
 *     Defines a function to be called when this Node or its child Node has input focus and a key has been typed
 *
 */
