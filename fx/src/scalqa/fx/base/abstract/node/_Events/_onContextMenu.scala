package scalqa; package fx; package base; package `abstract`; package node; package _events; import language.implicitConversions


transparent trait _onContextMenu:
  self: Fx.Node =>

  def onContextMenu[U](l: Fx.Event.ContextMenu => U) : Gen.Event.Control =
    _onFxEvent[javafx.scene.input.ContextMenuEvent, Fx.Event.ContextMenu, U](
      real.onContextMenuRequestedProperty.cast[ObjectProperty[EventHandler[javafx.scene.input.ContextMenuEvent]]],
      new Fx.Event.ContextMenu(_, this),
      Gen.Event.Id.map1(l, e => { val v = l(e); e.showMenu; v })
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
