package scalqa; package Fx; package Window

abstract class _Class protected extends A.Delegate.Gui {
  protected type REAL <: javafx.stage.Window

  protected def _createGui = new javafx.stage.Window() { setScene(scene.real) }.asInstanceOf[REAL]

  def scene: Scene

  // --------------------------------------------------------------------
  def hide = real.hide

  def centerOnScreen = real.centerOnScreen

  // --------------------------------------------------------------------
  lazy val widthPro: Pro.O[Double] = Custom.ProO(real.widthProperty); def width = real.getWidth; def width_=(b: Double) = real.setWidth(b)

  lazy val heightPro: Pro.O[Double] = Custom.ProO(real.heightProperty); def height = real.getHeight; def height_=(b: Double) = real.setHeight(b)

  lazy val xPro: Pro.O[Double] = Custom.ProO(real.xProperty); def x = real.getX; def x_=(b: Double) = real.setX(b)

  lazy val yPro: Pro.O[Double] = Custom.ProO(real.yProperty); def y = real.getY; def y_=(b: Double) = real.setY(b)

  // --------------------------------------------------------------------
  def onHidingRun(on: => Any) = _onFxEvent(real.onHidingProperty, () => on)

  def onHiddenRun(on: => Any) = _onFxEvent(real.onHiddenProperty, () => on)

  def onShowingRun(on: => Any) = _onFxEvent(real.onShowingProperty, () => on)

  def onShownRun(on: => Any) = _onFxEvent(real.onShownProperty, () => on)

  private[Fx] override def _referencePropertyOpt = real.onHidingProperty

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
