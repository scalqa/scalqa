package scalqa; package fx; package ui; package `abstract`; package node; package _Events; import language.implicitConversions

transparent trait _onScroll:
  self: Node =>

  def onScroll        [U](l: Ui.Event.Scroll => U) : Gen.Event.Control = _onScroll(l, real.onScrollProperty)
  def onScrollFinished[U](l: Ui.Event.Scroll => U) : Gen.Event.Control = _onScroll(l, real.onScrollFinishedProperty)
  def onScrollStarted [U](l: Ui.Event.Scroll => U) : Gen.Event.Control = _onScroll(l, real.onScrollStartedProperty)

  // ------------------------------------------------------------------------------------------------
  import javafx.scene.input.{ ScrollEvent => EVENT }

  private def _onScroll[U](l: Ui.Event.Scroll => U, op: ObjectProperty[EventHandler[_ >: EVENT]]) =
    _onFxEvent[EVENT, Ui.Event.Scroll, U](op.cast[ObjectProperty[EventHandler[EVENT]]], new Ui.Event.Scroll(_, this), l)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**

@def onScroll ->  On scroll

     Defines a function to be called when user performs a scrolling action


@def onScrollFinished -> On scroll finished

      Defines a function to be called when a scrolling gesture ends


@def onScrollStarted -> On scroll started

      Defines a function to be called when a scrolling gesture is detected


*/
