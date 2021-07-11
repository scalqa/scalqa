package scalqa; package fx; package base

abstract class Event(fxEvent: javafx.event.Event) /*extends Abstract.Delegate */ :
  protected type REAL <: javafx.event.Event

  def real: REAL = fxEvent.cast[REAL]

object Event:
  type Id          = gen.event.Id;         transparent inline def Id          = gen.event.Id
  type Control     = gen.event.Control;    transparent inline def Control     = gen.event.Control
  type Store       = gen.event.Store;      transparent inline def Store       = gen.event.Store
  type Mouse       = event.Mouse;          transparent inline def Mouse       = event.Mouse
  type ContextMenu = event.ContextMenu;    transparent inline def ContextMenu = event.ContextMenu
  type Key         = event.Key;            transparent inline def Key         = event.Key
  type Drag        = event.Drag
  type Gesture     = event.Gesture
  type Input       = event.Input
  type MouseDrag   = event.MouseDrag
  type Rotate      = event.Rotate
  type Scroll      = event.Scroll
  type Swipe       = event.Swipe
  type Touch       = event.Touch
  type Zoom        = event.Zoom

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
