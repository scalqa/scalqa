package scalqa; package Fx; package A; package Node; package _events

trait _onContextMenu { self: Node =>

  def onContextMenu(on: Event.ContextMenu => Any) =
    _onFxEvent[javafx.scene.input.ContextMenuEvent, Event.ContextMenu](real.onContextMenuRequestedProperty.I.asInstanceOfTarget, new Event.ContextMenu(_, this), e => { on(e); e.showMenu })

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @def onContextMenu -> On context menu
 *
 *    Defines a function to be called when a context menu has been requested on this Node
 *
 */
