package scalqa; package fx; package scene; package shape; import language.implicitConversions

class Circle(radiusO: Opt[Double]) extends Shape:
  protected def _createReal = radiusO.map(new REAL(_)) or new REAL
  protected type REAL = javafx.scene.shape.Circle

  def centerXPro           : Double.Pro.OM  = Fx.JavaFx.To.pro_OM(real.centerXProperty)
  def centerX              : Double         = real.getCenterX
  def centerX_=(b: Double) : Unit           = real.setCenterX(b)
  def centerYPro           : Double.Pro.OM  = Fx.JavaFx.To.pro_OM(real.centerYProperty)
  def centerY              : Double         = real.getCenterY
  def centerY_=(b: Double) : Unit           = real.setCenterY(b)
  def radiusPro            : Double.Pro.OM  = Fx.JavaFx.To.pro_OM(real.radiusProperty)
  def radius               : Double         = real.getRadius
  def radius_=(b: Double)  : Unit           = real.setRadius(b)

object Circle:

  def apply(radius: Opt[Double] = \/) : Circle = new Circle(radius)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
