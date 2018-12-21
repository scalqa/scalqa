package scalqa; package Fx; package A; package Delegate; package Gui

import javafx.beans.property.ObjectProperty
import javafx.event.Event
import javafx.event.EventHandler

trait _eventBase extends Any.Ref.Extra.Event0 with Any.Ref.Extra.Event {

  protected def _onFxEvent[T <: Event](op: ObjectProperty[EventHandler[T]], on: T => Any): EventControl = {
    if (op.get == null) op.set(new EventHandler[T] { def handle(e: T) = { _fireFxEvent[T](op, e) } });
    _addEvent(op, on)
  }

  protected def _onFxEvent[T <: Event](op: ObjectProperty[EventHandler[T]], on: () => Any): EventControl = _onFxEvent[T](op, { e: T => on() })

  protected def _onFxEvent[T <: Event, E](op: ObjectProperty[EventHandler[T]], as: T => E, on: E => Any): EventControl = _onFxEvent[T](op, { e: T => on(as(e)) })

  protected def _fireFxEvent[P1](scope: AnyRef, p1: P1) = _fireEvent[P1 => Any](scope, _(p1))

  // --------------------------------------------------------------------------------------------------------------------
  private[Fx] def fireFxEvent[P1](scope: AnyRef, p1: P1) = _fireFxEvent(scope, p1)

  private[Fx] def onFxEvent[T <: Event](op: ObjectProperty[EventHandler[T]], on: T => Any) = _onFxEvent(op, on)

  private[Fx] def onFxEvent[T <: Event](op: ObjectProperty[EventHandler[T]], on: () => Any): EventControl = _onFxEvent[T](op, { e: T => on() })

  private[Fx] def onFxEvent[T <: Event, E](op: ObjectProperty[EventHandler[T]], as: T => E, on: E => Any): EventControl = _onFxEvent[T](op, { e: T => on(as(e)) })

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
