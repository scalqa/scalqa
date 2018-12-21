package scalqa; package Fx; package Shape; package Path

import javafx.scene.shape.{ CubicCurveTo => JAVA }

class CubicCurveTo private (val real: JAVA) extends AnyVal with Element with A.Delegate.Data[CubicCurveTo, JAVA] {
  protected def setup = CubicCurveTo

  def xPro: Pro.OM[Double] = Custom.ProWO(real.xProperty); def x = real.getX; def x_=(v: Double) = real.setX(v)

  def yPro: Pro.OM[Double] = Custom.ProWO(real.yProperty); def y = real.getY; def y_=(v: Double) = real.setY(v)

  def controlX1Pro: Pro.OM[Double] = Custom.ProWO(real.controlX1Property); def controlX1 = real.getControlX1; def controlX1_=(v: Double) = real.setControlX1(v)

  def controlX2Pro: Pro.OM[Double] = Custom.ProWO(real.controlX2Property); def controlX2 = real.getControlX2; def controlX2_=(v: Double) = real.setControlX2(v)

  def controlY1Pro: Pro.OM[Double] = Custom.ProWO(real.controlY1Property); def controlY1 = real.getControlY1; def controlY1_=(v: Double) = real.setControlY1(v)

  def controlY2Pro: Pro.OM[Double] = Custom.ProWO(real.controlY2Property); def controlY2 = real.getControlY2; def controlY2_=(v: Double) = real.setControlY2(v)

}

object CubicCurveTo extends A.Delegate.Data.Setup[CubicCurveTo, JAVA] {

  def make() = new CubicCurveTo(new JAVA)

  def make(v: JAVA) = new CubicCurveTo(v)

  def make(controlX1: Double, controlY1: Double, controlX2: Double, controlY2: Double, x: Double, y: Double) = new CubicCurveTo(new JAVA(controlX1, controlY1, controlX2, controlY2, x, y))
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
