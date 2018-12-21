package scalqa; package Fx; package A; package Node; package _events

trait _onZoom { self: Node =>

  def onZoom(on: Event.Zoom => Any): EventControl = _onZoom(on, real.onZoomProperty)

  def onZoomStarted(on: Event.Zoom => Any) = _onZoom(on, real.onZoomStartedProperty)

  def onZoomFinished(on: Event.Zoom => Any) = _onZoom(on, real.onZoomFinishedProperty)

  // ------------------------------------------------------------------------------------------------
  private def _onZoom(on: Event.Zoom => Any, op: ObjectProperty[EventHandler[_ >: javafx.scene.input.ZoomEvent]]) =
    _onFxEvent[javafx.scene.input.ZoomEvent, Event.Zoom](op.I.asInstanceOfTarget, e => new Event.Zoom(e, this), on)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 *  @def onZoom( -> On zoom
 *
 *     Defines a function to be called when user performs a zooming action
 *
 *  @def onZoomStarted -> On zoom
 *
 *     Defines a function to be called when a zooming gesture is detected
 *
 *  @def onZoomFinished -> On zoom
 *
 *     Defines a function to be called when a zooming gesture ends
 */
