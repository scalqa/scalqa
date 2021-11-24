package scalqa; package fx; package scene; package pane; package tab; import language.implicitConversions

class Panel extends Abstract.Delegate.Gui:
  def this(label: String) = { this(); text = label }
  def this(label: String, e: Fx.Node.Like) = { this(label); content = e }
  // --------------------------------------------------------------------------------------------------
  protected type REAL = javafx.scene.control.Tab
  protected def _createReal = new REAL
  private[fx] override def _refPropertyOpt = real.onClosedProperty

  closable = false

  def sceneOpt                           : Opt[Scene]             = real.tabPaneProperty().get.??.map(v => Scene(v.getScene))

  def onSelectionChanged[U](l: () => U) : Event.Control          = _onFxEvent(real.onSelectionChangedProperty, l)
  def onSelection       [U](l: () => U) : Event.Control          = onSelectionChanged(() => if (selected) l())

  def selectedPro                       : Boolean.Pro.O          = Fx.JavaFx.To.pro_O(real.selectedProperty);
  def selected                          : Boolean                = real.selectedProperty.get
  def textPro                           : Pro.OM[String]         = Fx.JavaFx.To.pro_OM(real.textProperty);
  def text                              : String                 = real.getText
  def text_=(v: String)                 : Unit                   = real.setText(v)
  def closablePro                       : Boolean.Pro.OM         = Fx.JavaFx.To.pro_OM(real.closableProperty)
  def closable                          : Boolean                = real.closableProperty.get
  def closable_=(v: Boolean)            : Unit                   = real.setClosable(v)
  def disablePro                        : Boolean.Pro.OM         = Fx.JavaFx.To.pro_OM(real.disableProperty)
  def disable                           : Boolean                = real.disableProperty.get
  def disable_=(v: Boolean)             : Unit                   = real.setDisable(v)
  def disabledPro                       : Boolean.Pro.O          = Fx.JavaFx.To.pro_O(real.disabledProperty)
  def disabled                          : Boolean                = real.disabledProperty.get
  def contentPro                        : Pro.OM[Fx.Node.Like]   = Fx.JavaFx.To.pro_OM(real.contentProperty).mutableMapView[Fx.Node.Like]
  def content                           : Fx.Node.Like           = contentPro()
  def content_=(e:Fx.Node.Like)         : Unit                   = contentPro() = e

object Panel:
  def apply(r: javafx.scene.control.Tab): Panel = Abstract.Delegate.Gui(r.onClosedProperty)

  given FxConverter: TwoWayFunction[javafx.scene.control.Tab, Panel] = TwoWayFunction(apply, _.real)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
