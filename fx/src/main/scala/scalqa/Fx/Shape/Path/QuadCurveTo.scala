package scalqa; package Fx; package Shape; package Path

import javafx.scene.shape.{ QuadCurveTo => JAVA }

class QuadCurveTo private (val real: JAVA) extends AnyVal with Element with A.Delegate.Data[QuadCurveTo, JAVA] {
  protected def setup = QuadCurveTo

  def xPro: Pro.OM[Double] = Custom.ProWO(real.xProperty); def x = real.getX; def x_=(v: Double) = real.setX(v)

  def yPro: Pro.OM[Double] = Custom.ProWO(real.yProperty); def y = real.getY; def y_=(v: Double) = real.setY(v)

  def controlXPro: Pro.OM[Double] = Custom.ProWO(real.controlXProperty); def controlX = real.getControlX; def controlX_=(v: Double) = real.setControlX(v)

  def controlYPro: Pro.OM[Double] = Custom.ProWO(real.controlYProperty); def controlY = real.getControlY; def controlY_=(v: Double) = real.setControlY(v)

}

object QuadCurveTo extends A.Delegate.Data.Setup[QuadCurveTo, JAVA] {

  def make() = new QuadCurveTo(new JAVA)

  def make(v: JAVA) = new QuadCurveTo(v)

  def make(controlX: Double, controlY: Double, x: Double, y: Double) = new QuadCurveTo(new JAVA(controlX, controlY, x, y))
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
