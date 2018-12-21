package scalqa; package Fx; package Shape; package Path

import javafx.scene.shape.{ MoveTo => JAVA }

class MoveTo private (val real: JAVA) extends AnyVal with Element with A.Delegate.Data[MoveTo, JAVA] {
  protected def setup = MoveTo

  def xPro: Pro.OM[Double] = Custom.ProWO(real.xProperty); def x = real.getX; def x_=(v: Double) = real.setX(v)

  def yPro: Pro.OM[Double] = Custom.ProWO(real.yProperty); def y = real.getY; def y_=(v: Double) = real.setY(v)

}

object MoveTo extends A.Delegate.Data.Setup[MoveTo, JAVA] {

  def make() = new MoveTo(new JAVA)

  def make(v: JAVA) = new MoveTo(v)

  def make(x: Double, y: Double) = new MoveTo(new JAVA(x, y))
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
