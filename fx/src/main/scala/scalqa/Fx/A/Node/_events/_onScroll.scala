package scalqa; package Fx; package A; package Node; package _events

trait _onScroll { self: Node =>

  def onScroll(on: Event.Scroll => Any) = _onScroll(on, real.onScrollProperty)

  def onScrollFinished(on: Event.Scroll => Any) = _onScroll(on, real.onScrollFinishedProperty)

  def onScrollStarted(on: Event.Scroll => Any) = _onScroll(on, real.onScrollStartedProperty)

  // ------------------------------------------------------------------------------------------------
  private def _onScroll(on: Event.Scroll => Any, op: ObjectProperty[EventHandler[_ >: javafx.scene.input.ScrollEvent]]) =
    _onFxEvent[javafx.scene.input.ScrollEvent, Event.Scroll](op.I.asInstanceOfTarget, e => new Event.Scroll(e, this), on)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 *  @def onScroll( -> On scroll
 *
 *   Defines a function to be called when user performs a scrolling action
 *
 *  @def onScrollFinished -> On scroll finished
 *
 *    Defines a function to be called when a scrolling gesture ends
 *
 *  @def onScrollStarted -> On scroll started
 *
 *    Defines a function to be called when a scrolling gesture is detected
 *
 */
