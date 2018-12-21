package scalqa; package Fx; package Button

import javafx.event.ActionEvent

abstract class Like protected extends Label.Like {
  protected type REAL <: javafx.scene.control.ButtonBase

  def arm: Unit = real.arm

  def disarm = real.disarm

  def armedPro: Pro.O[Boolean] = Custom.ProO(real.armedProperty); def armed = real.isArmed

  def onAction(run: Action.Event => Any): EventControl = _onFxEvent[ActionEvent, Action.Event](real.onActionProperty, e => new Action.Event(e), run)

  def onActionRun(run: => Any): EventControl = onAction(e => run)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @def arm: -> Arm
 *
 *    Arms the button
 *
 * @def disarm -> Disarms
 *
 *    Disarms the button
 *
 * @def armedPro -> Armed
 *
 *     Indicates that the button has been "armed" such that a mouse release will cause the button's action to be invoked
 *
 *     This is subtly different from pressed
 *
 *     Pressed indicates that the mouse has been pressed on a Node and has not yet been released
 *
 *     arm however also takes into account whether the mouse is actually over the button and pressed
 *
 *  @def onAction( -> On action
 *
 *    The button's action, which is invoked whenever the button is fired
 *
 *    This may be due to the user clicking on the button with the mouse, or by a touch event, or by a key press, or if the developer programmatically invokes the fire() method
 *
 *  @def onActionRun( -> Run on action
 *
 *    Overload of [[onAction]]
 *
 */
