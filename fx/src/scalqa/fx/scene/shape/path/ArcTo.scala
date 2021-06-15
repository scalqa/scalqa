package scalqa; package fx; package scene; package shape; package path

import javafx.scene.shape.{ ArcTo => JArcTo }

class ArcTo(val real: JArcTo) extends AnyVal with Z.Base[ArcTo,JArcTo]:
  protected                def setup                                        = ArcTo
  @tn("x_Pro")             def x_*                        : Double.Pro.OM   = Fx.JavaFx.To.pro_OM(real.xProperty)
  /**/                     def x                          : Double          = real.getX
  /**/                     def x_=(v: Double)             : Unit            = real.setX(v)
  @tn("y_Pro")             def y_*                        : Double.Pro.OM   = Fx.JavaFx.To.pro_OM(real.yProperty)
  /**/                     def y                          : Double          = real.getY
  /**/                     def y_=(v: Double)             : Unit            = real.setY(v)
  @tn("radiusX_Pro")       def radiusX_*                  : Double.Pro.OM   = Fx.JavaFx.To.pro_OM(real.radiusXProperty)
  /**/                     def radiusX                    : Double          = real.getRadiusX
  /**/                     def radiusX_=(v: Double)       : Unit            = real.setRadiusX(v)
  @tn("radiusY_Pro")       def radiusY_*                  : Double.Pro.OM   = Fx.JavaFx.To.pro_OM(real.radiusYProperty)
  /**/                     def radiusY                    : Double          = real.getRadiusY
  /**/                     def radiusY_=(v: Double)       : Unit            = real.setRadiusY(v)
  @tn("xAxisRotation_Pro") def xAxisRotation_*            : Double.Pro.OM   = Fx.JavaFx.To.pro_OM(real.XAxisRotationProperty)
  /**/                     def xAxisRotation              : Double          = real.getXAxisRotation
  /**/                     def xAxisRotation_=(v: Double) : Unit            = real.setXAxisRotation(v)
  @tn("sweepFlag_Pro")     def sweepFlag_*                : Boolean.Pro.OM  = Fx.JavaFx.To.pro_OM(real.sweepFlagProperty)
  /**/                     def sweepFlag                  : Boolean         = real.isSweepFlag
  /**/                     def sweepFlag_=(b: Boolean)    : Unit            = real.setSweepFlag(b)
  @tn("largeArcFlag_Pro")  def largeArcFlag_*             : Boolean.Pro.OM  = Fx.JavaFx.To.pro_OM(real.largeArcFlagProperty)
  /**/                     def largeArcFlag               : Boolean         = real.isLargeArcFlag
  /**/                     def largeArcFlag_=(b: Boolean) : Unit            = real.setLargeArcFlag(b)

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
