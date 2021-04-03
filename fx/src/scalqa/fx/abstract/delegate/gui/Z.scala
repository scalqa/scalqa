package scalqa; package fx; package `abstract`; package delegate; package gui; import language.implicitConversions

import javafx.beans.property.ObjectProperty
import javafx.event.{EventHandler, Event}

private[`abstract`] object Z:

  class EventDispatch[T <: Event,U](store: Gen.Event.Store, property: ObjectProperty[EventHandler[T]]) extends EventHandler[T]:
    def handle(v: T) =
      var e = store.get(property)
      while (!e.isVoid)
        val f = e.value.cast[T => U]
        if (f != null) try { f(v) } catch { case Gen.Event.CancelRequest => e.cancel }
        e = e.next

  // **********************************************************************************************************************************************
  class RefEventDispatch(val gui: Delegate.Gui, s: Gen.Event.Store, p: ObjectProperty[EventHandler[Event]]) extends EventDispatch[Event,Unit](s,p)

  // **********************************************************************************************************************************************

  class MappedEvent[T<:Event,E,U](map: T=>E, run: E=>U) extends (T=>U):
    def apply(v: T): U =
      val mv = map(v)
      run(mv)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
