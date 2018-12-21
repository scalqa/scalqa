package scalqa; package Fx; package CheckBox

class _Class extends Button.Like {

  protected override def _createGui = new REAL

  protected type REAL = javafx.scene.control.CheckBox

  def selectedPro: Pro.OM[Boolean] = Custom.ProWO(real.selectedProperty); def selected = real.isSelected; def selected_=(b: Boolean) = real.setSelected(b)

  def onActionSelectedRun(f: => Any) = onActionRun(if (selected) f)

  def onActionUnselectedRun(f: => Any) = onActionRun(if (!selected) f)

  def bind(p: Pro.M[Boolean]) = {
    selected = p()
    p.I.letType[Pro.OM[Boolean]].apply(_.onChangeRun(selected = p()))
    onActionRun(p() = selected)
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
