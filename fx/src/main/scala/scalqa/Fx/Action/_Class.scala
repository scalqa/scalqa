package scalqa; package Fx; package Action

import javafx.scene.control.MenuItem;
import javafx.event.ActionEvent;

class _Class(label: String = \/) extends A.Delegate.Gui {
  protected type REAL <: MenuItem
  protected def _createGui: REAL = new MenuItem(label \/ null) { setUserData(_Class.this) }.asInstanceOf[REAL]

  def visiblePro: Pro.OM[Boolean] = Custom.ProWO(real.visibleProperty); def visible = real.isVisible; def visible_=(b: Boolean) = real.setVisible(b)

  def textPro: Pro.OM[String] = Custom.ProWO(real.textProperty); def text = real.getText; def text_=(v: String) = real.setText(v)

  def enablePro: Pro.OM[Boolean] = Custom.ProWO(real.disableProperty).asBiMappedView(BiMap(!_, !_)); def enable = !real.isDisable; def enable_=(b: Boolean) = real.setDisable(!b)

  // ---------------------- ----------------------------------------------------------------------------
  def onAction(run: Event => Any): EventControl = _onFxEvent[ActionEvent](real.onActionProperty, { e: ActionEvent => run(new Event(e)) })

  def onActionRun(run: => Any): EventControl = onAction(e => run)

  def toMenuItem = this match { case v: Menu.Item => v; case _ => new Menu.Item(this) }

}

object _Class {

  implicit def zzMake(n: A.Node) = make(n)

  implicit def zzMake(t: (String, Boolean, () => Any)): Action = new Action(t._1).I(a => { a.enable = t._2; a.onAction(e => t._3()) })

  implicit def zzMake(t: (String, () => Any)): Action = new Action(t._1).I(_.onAction(e => t._2()))

  implicit def zzMake(s: SEPARATOR.type): Action = make(s)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
