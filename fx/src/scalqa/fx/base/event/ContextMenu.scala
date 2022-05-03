package scalqa; package fx; package base; package event; import language.implicitConversions

import javafx.scene.input.ContextMenuEvent

class ContextMenu(e: ContextMenuEvent, node: Fx.Node) extends Input(e, node):
  protected type REAL <: ContextMenuEvent
  private var onClosed: Pack[() => Unit]=VOID

  val actions                     : Idx.M[Action] = Idx.M()
  def x                           : Double        = real.getX
  def y                           : Double        = real.getY
  def screenX                     : Double        = real.getScreenX
  def screenY                     : Double        = real.getScreenY
  def showMenu                    : Unit          = ContextMenu.show(this)
  def onMenuClosedRun(l: => Unit) : Unit          = onClosed += (() => l);

object ContextMenu:
  private var currentMenus: Pack[ContextMenu]=VOID

  def show(e: ContextMenu): Unit = synchronized {
    currentMenus += e
    if (currentMenus.size == 1) Fx.Thread.scheduleIn(33.Millis, showCurrent)
  }

  private def showCurrent = synchronized {
    val menu = Popup.Menu()
    menu.items ++= {
      val s = currentMenus.stream.flatMap(_.actions).group.map(_.read)
      val p = s.takeIndexed((i, v) => i > 0 || !v.isInstanceOf[action.z.Separator]).pack
      if (p.lastOpt.isInstanceOf[action.z.Separator]) p.stream.dropLast(1) else p.stream
    }.map(_.toMenuItem)
    currentMenus.stream.flatMap(_.onClosed).pack.self(l => if (l.size > 0) menu.onHidden(() => l.stream.foreach(_())))
    currentMenus.last.self(e => e.node.sceneOpt.forval(s => menu.show(s.window, e.screenX, e.screenY)))
    currentMenus=VOID
  }

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
