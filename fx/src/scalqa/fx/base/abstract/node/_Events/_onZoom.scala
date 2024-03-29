package scalqa; package fx; package base; package `abstract`; package node; package _events; import language.implicitConversions

transparent trait _onZoom:
  self: Fx.Node =>

  def onZoom        [U](l: Fx.Event.Zoom => U) : Gen.Event.Control = _onZoom(l, real.onZoomProperty)
  def onZoomStarted [U](l: Fx.Event.Zoom => U) : Gen.Event.Control = _onZoom(l, real.onZoomStartedProperty)
  def onZoomFinished[U](l: Fx.Event.Zoom => U) : Gen.Event.Control = _onZoom(l, real.onZoomFinishedProperty)

  // ------------------------------------------------------------------------------------------------
  import javafx.scene.input.{ ZoomEvent => EVENT }

  private def _onZoom[U](l: Fx.Event.Zoom => U, op: ObjectProperty[EventHandler[_ >: EVENT]]) =
    _onFxEvent[EVENT, Fx.Event.Zoom, U](op.cast[ObjectProperty[EventHandler[EVENT]]], new Fx.Event.Zoom(_, this), l)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**

@def onZoom ->  On zoom

       Defines a function to be called when user performs a zooming action


@def onZoomStarted -> On zoom

       Defines a function to be called when a zooming gesture is detected


@def onZoomFinished -> On zoom

       Defines a function to be called when a zooming gesture ends

*/
