package scalqa; package Fx; package Event

import javafx.scene.input.ContextMenuEvent
import ContextMenu._

class ContextMenu(e: ContextMenuEvent, node: A.Node) extends Input(e, node) {
  protected type REAL <: ContextMenuEvent

  val actions = Idx.M.makeSized[Action](20)

  def onMenuClosedRun(on: => Any) = onMenuClosedJobs += (() => on); private var onMenuClosedJobs: Refs[() => Any] = \/

  def x: Double = real.getX

  def y: Double = real.getY

  def screenX: Double = real.getScreenX

  def screenY: Double = real.getScreenY

  def showMenu = ContextMenu.show(this)

}

object ContextMenu {
  private var allCurrentMenus: Stream[ContextMenu] = \/

  def show(e: ContextMenu) {
    def toItems(a: ~[ContextMenu]): ~[Menu.Item] = {
      var l = a.flatMap(_.actions).group.map(_.next).to[Idx]
      if (l.getOpt(0).letType[Fx.Action.Z.Separator]) l = l.all.dropNext(1).to[Idx]
      if (l.lastOpt.letType[Fx.Action.Z.Separator]) l = l.all.dropLast(1).to[Idx]
      l.all.map(_.toMenuItem)
    }
    val all = e.actions
    if (allCurrentMenus.isVoid) Fx.Thread.runIn(33.Millis, try {
      val menu = Popup.Menu.make
      allCurrentMenus.to[Idx].I(l => {
        l.all.map(_.onMenuClosedJobs).reduceOpt(_ +~ _).apply(t => menu.onHiddenRun(t.all.foreach(_())))
        menu.items +~= toItems(l.all)
      }).lastOpt(e => {
        menu.show(e.node.scene.window, e.screenX, e.screenY)
      })
    } finally { allCurrentMenus = \/ })
    allCurrentMenus += e
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
