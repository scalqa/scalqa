package scalqa; package Fx; package Shape

class Circle(radiusOpt: Opt[Double]) extends Shape with Any.Able.ToInfo {
  protected def _createGui = radiusOpt.map(new REAL(_)) or new REAL
  protected type REAL = javafx.scene.shape.Circle

  def centerXPro: Pro.OM[Double] = Custom.ProWO(real.centerXProperty); def centerX = real.getCenterX; def centerX_=(b: Double) = real.setCenterX(b)

  def centerYPro: Pro.OM[Double] = Custom.ProWO(real.centerYProperty); def centerY = real.getCenterY; def centerY_=(b: Double) = real.setCenterY(b)

  def radiusPro: Pro.OM[Double] = Custom.ProWO(real.radiusProperty); def radius = real.getRadius; def radius_=(b: Double) = real.setRadius(b)

  // -----------------------------------------------------------------------------------------------------
  def toInfo = new Pro.Info(this) += (("x", centerX)) += (("y", centerY)) += (("radius", radius))

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
