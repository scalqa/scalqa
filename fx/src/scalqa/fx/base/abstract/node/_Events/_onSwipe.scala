package scalqa; package fx; package base; package `abstract`; package node; package _Events; import language.implicitConversions

transparent trait _onSwipe:
  self: Fx.Node =>

  def onSwipeDown [U](l: Fx.Event.Swipe => U) : Gen.Event.Control = onSwipe(l, real.onSwipeDownProperty)
  def onSwipeLeft [U](l: Fx.Event.Swipe => U) : Gen.Event.Control = onSwipe(l, real.onSwipeLeftProperty)
  def onSwipeRight[U](l: Fx.Event.Swipe => U) : Gen.Event.Control = onSwipe(l, real.onSwipeRightProperty)
  def onSwipeUp   [U](l: Fx.Event.Swipe => U) : Gen.Event.Control = onSwipe(l, real.onSwipeUpProperty)

  // ------------------------------------------------------------------------------------------------
  import javafx.scene.input.{ SwipeEvent => EVENT }

  private def onSwipe[U](l: Fx.Event.Swipe => U, op: ObjectProperty[EventHandler[_ >: EVENT]]) =
    _onFxEvent[EVENT, Fx.Event.Swipe, U](
        op.cast[ObjectProperty[EventHandler[EVENT]]],
        new Fx.Event.Swipe(_, this),
        l
    )

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**

@def onSwipeDown -> On swipe down

       Defines a function to be called when a downward swipe gesture centered over this node happens


@def onSwipeLeft -> On swipe left

       Defines a function to be called when a leftward swipe gesture centered over this node happens


@def onSwipeRight -> On swipe right

       Defines a function to be called when an rightward swipe gesture centered over this node happens


@def onSwipeUp -> On swipe up

       Defines a function to be called when an upward swipe gesture centered over this node happens


*/
