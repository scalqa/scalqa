package scalqa; package Fx; package Menu; package Item

import javafx.scene.control.MenuItem;

class _Class protected extends Action {
  protected type REAL <: MenuItem
  protected override def _createGui: REAL = new MenuItem().asInstanceOf[REAL]

  def this(a: Action) { this; _onCreateGuiRun(a.real.asInstanceOf[REAL]) }

  def this(text: String) = { this; _onCreateGuiRun(new MenuItem(text).asInstanceOf[REAL]) }

  def graphicPro = Custom.ProWO(real.graphicProperty).asBiMappedView(Fx.A.Node.Like.Map); def graphic = real.getGraphic; def graphic_=(g: Fx.A.Node.Like) = real.setGraphic(g.real)

  def idPro: Pro.OM[String] = Custom.ProWO(real.idProperty); def id = real.getId; def id_=(v: String) = real.setId(v)

}

object _Class {

  implicit def zzMake(s: SEPARATOR.type) = separator
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
