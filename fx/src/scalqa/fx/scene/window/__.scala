package scalqa; package fx; package scene; import language.implicitConversions

abstract class Window extends Abstract.Delegate.Gui:
  protected type REAL <: javafx.stage.Window
  protected               def _createReal              : REAL          = new javafx.stage.Window() { setScene(scene.real) }.cast[REAL]
  private[fx] override    def _refPropertyOpt                          = real.onHidingProperty

  @tn("scene_Opt")  final def scene_?                  : Opt[Scene]    = scene
  /**/                    def scene                    : Scene
  /**/                    def hide                     : Unit          = real.hide
  /**/                    def centerOnScreen           : Unit          = real.centerOnScreen

  @tn("width_Pro")  lazy  val width_*                  : Double.Pro.O  = Fx.JavaFx.To.pro_O(real.widthProperty)
  /**/                    def width                    : Double        = real.getWidth
  /**/                    def width_=(b: Double)       : Unit          = real.setWidth(b)
  @tn("height_Pro") lazy  val height_*                 : Double.Pro.O  = Fx.JavaFx.To.pro_O(real.heightProperty)
  /**/                    def height                   : Double        = real.getHeight
  /**/                    def height_=(b: Double)      : Unit          = real.setHeight(b)
  @tn("x_Pro")      lazy  val x_*                      : Double.Pro.O  = Fx.JavaFx.To.pro_O(real.xProperty)
  /**/                    def x                        : Double        = real.getX
  /**/                    def x_=(b: Double)           : Unit          = real.setX(b)
  @tn("y_Pro")      lazy  val y_*                      : Double.Pro.O  = Fx.JavaFx.To.pro_O(real.yProperty)
  /**/                    def y                        : Double        = real.getY
  /**/                    def y_=(b: Double)           : Unit          = real.setY(b)

  /**/                    def onHiding [U](l: () => U) : Event.Control = _onFxEvent(real.onHidingProperty, l)
  /**/                    def onHidden [U](l: () => U) : Event.Control = _onFxEvent(real.onHiddenProperty, l)
  /**/                    def onShowing[U](l: () => U) : Event.Control = _onFxEvent(real.onShowingProperty, l)
  /**/                    def onShown  [U](l: () => U) : Event.Control = _onFxEvent(real.onShownProperty, l)

object Window:
  def apply(r: javafx.stage.Window): Window = Abstract.Delegate.Gui(r.onHidingProperty)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
