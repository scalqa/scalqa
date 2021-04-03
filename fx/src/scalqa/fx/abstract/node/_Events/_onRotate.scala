package scalqa; package fx; package `abstract`; package node; package _Events; import language.implicitConversions

transparent trait _onRotate:
  self: Node =>

  def onRotate          [U](l: Event.Rotate => U) : Event.Control = _onRotate(l, real.onRotateProperty)
  def onRotationFinished[U](l: Event.Rotate => U) : Event.Control = _onRotate(l, real.onRotationFinishedProperty)
  def onRotationStarted [U](l: Event.Rotate => U) : Event.Control = _onRotate(l, real.onRotationStartedProperty)

  // ------------------------------------------------------------------------------------------------
  import javafx.scene.input.{ RotateEvent => EVENT }

  private def _onRotate[U](l: Event.Rotate => U, op: ObjectProperty[EventHandler[_ >: EVENT]]) =
    _onFxEvent[EVENT, Event.Rotate, U](op.cast[ObjectProperty[EventHandler[EVENT]]], new Event.Rotate(_, this), l)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**

@def onRotate -> On rotate

      Defines a function to be called when user performs a rotation action


@def onRotationFinished -> On rotation finished

      Defines a function to be called when a rotation gesture ends


@def onRotationStarted -> On rotation started

      Defines a function to be called when a rotation gesture is detected


*/
