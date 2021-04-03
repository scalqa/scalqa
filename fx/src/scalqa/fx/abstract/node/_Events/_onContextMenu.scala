package scalqa; package fx; package `abstract`; package node; package _Events; import language.implicitConversions


transparent trait _onContextMenu:
  self: Node =>

  def onContextMenu[U](l: Event.ContextMenu => U) : Event.Control =
    _onFxEvent[javafx.scene.input.ContextMenuEvent, Event.ContextMenu, U](
      real.onContextMenuRequestedProperty.cast[ObjectProperty[EventHandler[javafx.scene.input.ContextMenuEvent]]],
      new Event.ContextMenu(_, this),
      Event.Id.map1(l, e => { val v = l(e); e.showMenu; v })
    )

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**

@def onContextMenu -> On context menu

      Defines a function to be called when a context menu has been requested on this Node


*/
