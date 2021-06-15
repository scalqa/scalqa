package scalqa; package fx; package base; package `abstract`; package node; import _Events.*

transparent trait _events extends Like with _onMouseAndDrag with _onKey with _onRotate with _onScroll with _onSwipe with _onTouch with _onZoom with _onContextMenu:
  self: Node =>

package _Events:
  private[_Events] type ObjectProperty[A]                     = javafx.beans.property.ObjectProperty[A]
  private[_Events] type EventHandler[A <: javafx.event.Event] = javafx.event.EventHandler[A]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
