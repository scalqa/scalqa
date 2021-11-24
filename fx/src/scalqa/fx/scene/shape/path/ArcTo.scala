package scalqa; package fx; package scene; package shape; package path

import javafx.scene.shape.{ ArcTo => JArcTo }

class ArcTo(val real: JArcTo) extends AnyVal with Z.Base[ArcTo,JArcTo]:
  protected def setup = ArcTo

  def xPro                       : Double.Pro.OM   = Fx.JavaFx.To.pro_OM(real.xProperty)
  def x                          : Double          = real.getX
  def x_=(v: Double)             : Unit            = real.setX(v)
  def yPro                       : Double.Pro.OM   = Fx.JavaFx.To.pro_OM(real.yProperty)
  def y                          : Double          = real.getY
  def y_=(v: Double)             : Unit            = real.setY(v)
  def radiusXPro                 : Double.Pro.OM   = Fx.JavaFx.To.pro_OM(real.radiusXProperty)
  def radiusX                    : Double          = real.getRadiusX
  def radiusX_=(v: Double)       : Unit            = real.setRadiusX(v)
  def radiusYPro                 : Double.Pro.OM   = Fx.JavaFx.To.pro_OM(real.radiusYProperty)
  def radiusY                    : Double          = real.getRadiusY
  def radiusY_=(v: Double)       : Unit            = real.setRadiusY(v)
  def xAxisRotationPro           : Double.Pro.OM   = Fx.JavaFx.To.pro_OM(real.XAxisRotationProperty)
  def xAxisRotation              : Double          = real.getXAxisRotation
  def xAxisRotation_=(v: Double) : Unit            = real.setXAxisRotation(v)
  def sweepFlagPro               : Boolean.Pro.OM  = Fx.JavaFx.To.pro_OM(real.sweepFlagProperty)
  def sweepFlag                  : Boolean         = real.isSweepFlag
  def sweepFlag_=(b: Boolean)    : Unit            = real.setSweepFlag(b)
  def largeArcFlagPro            : Boolean.Pro.OM  = Fx.JavaFx.To.pro_OM(real.largeArcFlagProperty)
  def largeArcFlag               : Boolean         = real.isLargeArcFlag
  def largeArcFlag_=(b: Boolean) : Unit            = real.setLargeArcFlag(b)

object ArcTo extends Z.Setup[ArcTo,JArcTo]:
  def apply(v: JArcTo)                                                 : ArcTo = new ArcTo(v)
  def apply()                                                          : ArcTo = apply(JArcTo())
  def apply(radiusX: Double, radiusY: Double, xAxisRotation: Double,
      x: Double, y: Double, largeArcFlag: Boolean, sweepFlag: Boolean) : ArcTo = apply(JArcTo(radiusX, radiusY, xAxisRotation, x, y, largeArcFlag, sweepFlag))

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
