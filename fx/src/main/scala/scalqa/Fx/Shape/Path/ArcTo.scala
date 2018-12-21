package scalqa; package Fx; package Shape; package Path

import javafx.scene.shape.{ ArcTo => JAVA }

class ArcTo private (val real: JAVA) extends AnyVal with Element with A.Delegate.Data[ArcTo, JAVA] {
  protected def setup = ArcTo

  def xPro: Pro.OM[Double] = Custom.ProWO(real.xProperty); def x = real.getX; def x_=(v: Double) = real.setX(v)

  def yPro: Pro.OM[Double] = Custom.ProWO(real.yProperty); def y = real.getY; def y_=(v: Double) = real.setY(v)

  def xAxisRotationPro: Pro.OM[Double] = Custom.ProWO(real.XAxisRotationProperty); def xAxisRotation = real.getXAxisRotation; def xAxisRotation_=(v: Double) = real.setXAxisRotation(v)

  def radiusXPro: Pro.OM[Double] = Custom.ProWO(real.radiusXProperty); def radiusX = real.getRadiusX; def radiusX_=(v: Double) = real.setRadiusX(v)

  def radiusYPro: Pro.OM[Double] = Custom.ProWO(real.radiusYProperty); def radiusY = real.getRadiusY; def radiusY_=(v: Double) = real.setRadiusY(v)

  def sweepFlagPro: Pro.OM[Boolean] = Custom.ProWO(real.sweepFlagProperty); def sweepFlag = real.isSweepFlag; def sweepFlag_=(b: Boolean) = real.setSweepFlag(b)

  def largeArcFlagPro: Pro.OM[Boolean] = Custom.ProWO(real.largeArcFlagProperty); def largeArcFlag = real.isLargeArcFlag; def largeArcFlag_=(b: Boolean) = real.setLargeArcFlag(b)

}

object ArcTo extends A.Delegate.Data.Setup[ArcTo, JAVA] {

  def make() = new ArcTo(new JAVA)

  def make(v: JAVA) = new ArcTo(v)

  def make(radiusX: Double, radiusY: Double, xAxisRotation: Double, x: Double, y: Double, largeArcFlag: Boolean, sweepFlag: Boolean) =
    new ArcTo(new JAVA(radiusX, radiusY, xAxisRotation, x, y, largeArcFlag, sweepFlag))

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
