package scalqa; package Fx; package A; package Node; package _events

trait _onSwipe { self: Node =>

  def onSwipeDown(on: Event.Swipe => Any) = onSwipe(on, real.onSwipeDownProperty)

  def onSwipeLeft(on: Event.Swipe => Any) = onSwipe(on, real.onSwipeLeftProperty)

  def onSwipeRight(on: Event.Swipe => Any) = onSwipe(on, real.onSwipeRightProperty)

  def onSwipeUp(on: Event.Swipe => Any) = onSwipe(on, real.onSwipeUpProperty)

  // ------------------------------------------------------------------------------------------------
  private def onSwipe(on: Event.Swipe => Any, op: ObjectProperty[EventHandler[_ >: javafx.scene.input.SwipeEvent]]) =
    _onFxEvent[javafx.scene.input.SwipeEvent, Event.Swipe](op.I.asInstanceOfTarget, e => new Event.Swipe(e, this), on)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 *  @def onSwipeDown -> On swipe down
 *
 *     Defines a function to be called when a downward swipe gesture centered over this node happens
 *
 *  @def onSwipeLeft -> On swipe left
 *
 *     Defines a function to be called when a leftward swipe gesture centered over this node happens
 *
 *  @def onSwipeRight -> On swipe right
 *
 *     Defines a function to be called when an rightward swipe gesture centered over this node happens
 *
 *  @def onSwipeUp -> On swipe up
 *
 *     Defines a function to be called when an upward swipe gesture centered over this node happens
 *
 */
