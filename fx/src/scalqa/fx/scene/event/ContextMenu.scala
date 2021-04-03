package scalqa; package fx; package scene; package event; import language.implicitConversions

import javafx.scene.input.ContextMenuEvent

class ContextMenu(e: ContextMenuEvent, node: Node) extends Input(e, node):
  protected type REAL <: ContextMenuEvent
  private var onClosed: ><[() => Unit] = \/

  val actions                     : Idx.M[Action] = Idx.M()
  def x                           : Double        = real.getX
  def y                           : Double        = real.getY
  def screenX                     : Double        = real.getScreenX
  def screenY                     : Double        = real.getScreenY
  def showMenu                    : Unit          = ContextMenu.show(this)
  def onMenuClosedRun(l: => Unit) : Unit          = onClosed += (() => l);

object ContextMenu:
  private var currentMenus: ><[ContextMenu] = \/

  def show(e: ContextMenu): Unit = synchronized {
    currentMenus += e
    if (currentMenus.size == 1) fx.Thread.scheduleIn(33.Millis, showCurrent)
  }

  private def showCurrent = synchronized {
    val menu = Popup.Menu()
    menu.items ++= {
      val a = currentMenus.~.flatMap(_.actions).group.map(_.read).takeIndexed((i, v) => i > 0 || !v.isInstanceOf[control.action.z.Separator]).><
      if (a.last_?.isInstanceOf[control.action.z.Separator]) a.~.dropLast(1) else a.~
    }.map(_.toMenuItem)
    currentMenus.~.flatMap(_.onClosed).><.^(l => if (l.size > 0) menu.onHidden(() => l.~.foreach(_())))
    currentMenus.last.^(e => e.node.scene_?.forval(s => menu.show(s.window, e.screenX, e.screenY)))
    currentMenus = \/
  }

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
