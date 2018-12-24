package scalqa; package Fx; package Pane; package Tab

class Panel extends Fx.A.Delegate.Gui {
  def this(label: String) = { this; text = label }
  def this(label: String, e: Fx.A.Node.Like) = { this(label); content = e }
  // --------------------------------------------------------------------------------------------------
  protected type REAL = javafx.scene.control.Tab
  protected def _createGui = new REAL

  closable = false
  // --------------------------------------------------------------------------------------------------

  def textPro: Pro.OM[String] = Custom.ProWO(real.textProperty); def text = real.getText; def text_=(v: String) = real.setText(v)

  def closablePro: Pro.OM[Boolean] = Custom.ProWO(real.closableProperty); def closable = real.closableProperty.get; def closable_=(v: Boolean) = real.setClosable(v)

  def disablePro: Pro.OM[Boolean] = Custom.ProWO(real.disableProperty); def disable = real.disableProperty.get; def disable_=(v: Boolean) = real.setDisable(v)

  def disabledPro: Pro.O[Boolean] = Custom.ProO(real.disabledProperty); def disabled = real.disabledProperty.get

  def contentPro: Pro.OM[Fx.A.Node.Like] = Custom.ProWO(real.contentProperty).asBiMappedView(Fx.A.Node.Like.Map); def content = contentPro(); def content_=(e: Fx.A.Node.Like): Unit =  contentPro() = e 

  private[Fx] override def _referencePropertyOpt = real.onClosedProperty.Opt

}

object Panel {

  def apply(r: javafx.scene.control.Tab): Panel = Fx.A.Delegate.Gui.make(r.onClosedProperty)

  lazy val biMap = BiMap[javafx.scene.control.Tab, Panel](apply, _.real)
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
