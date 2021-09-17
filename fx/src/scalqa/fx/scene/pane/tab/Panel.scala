package scalqa; package fx; package scene; package pane; package tab; import language.implicitConversions

class Panel extends Abstract.Delegate.Gui:
  def this(label: String) = { this(); text = label }
  def this(label: String, e: Fx.Node.Like) = { this(label); content = e }
  // --------------------------------------------------------------------------------------------------
  protected type REAL = javafx.scene.control.Tab
  protected def _createReal = new REAL
  private[fx] override def _refPropertyOpt = real.onClosedProperty

  closable = false

  @tn("scene_Opt")    def scene_?                           : Opt[Scene]             = real.tabPaneProperty().get.^.?.map(v => Scene(v.getScene))

  /**/                def onSelectionChanged[U](l: () => U) : Event.Control          = _onFxEvent(real.onSelectionChangedProperty, l)
  /**/                def onSelection       [U](l: () => U) : Event.Control          = onSelectionChanged(() => if (selected) l())

  @tn("selected_Pro") def selected_*                        : Boolean.Pro.O          = Fx.JavaFx.To.pro_O(real.selectedProperty);
  /**/                def selected                          : Boolean                = real.selectedProperty.get
  @tn("text_Pro")     def text_*                            : Pro.OM[String]         = Fx.JavaFx.To.pro_OM(real.textProperty);
  /**/                def text                              : String                 = real.getText
  /**/                def text_=(v: String)                 : Unit                   = real.setText(v)
  @tn("closable_Pro") def closable_*                        : Boolean.Pro.OM         = Fx.JavaFx.To.pro_OM(real.closableProperty)
  /**/                def closable                          : Boolean                = real.closableProperty.get
  /**/                def closable_=(v: Boolean)            : Unit                   = real.setClosable(v)
  @tn("disable_Pro")  def disable_*                         : Boolean.Pro.OM         = Fx.JavaFx.To.pro_OM(real.disableProperty)
  /**/                def disable                           : Boolean                = real.disableProperty.get
  /**/                def disable_=(v: Boolean)             : Unit                   = real.setDisable(v)
  @tn("disabled_Pro") def disabled_*                        : Boolean.Pro.O          = Fx.JavaFx.To.pro_O(real.disabledProperty)
  /**/                def disabled                          : Boolean                = real.disabledProperty.get
  @tn("content_Pro")  def content_*                         : Pro.OM[Fx.Node.Like]   = Fx.JavaFx.To.pro_OM(real.contentProperty).mutableMap_^[Fx.Node.Like]
  /**/                def content                           : Fx.Node.Like           = content_*()
  /**/                def content_=(e:Fx.Node.Like)         : Unit                   = content_*() = e

object Panel:
  def apply(r: javafx.scene.control.Tab): Panel = Abstract.Delegate.Gui(r.onClosedProperty)

  given FxConverter: ReversibleFunction[javafx.scene.control.Tab, Panel] = ReversibleFunction(apply, _.real)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
