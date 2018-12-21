package scalqa; package Fx; package Shape; package Path

import javafx.scene.shape.{ VLineTo => JAVA }

class VLineTo private (val real: JAVA) extends AnyVal with Element with A.Delegate.Data[VLineTo, JAVA] {
  protected def setup = VLineTo

  def yPro: Pro.OM[Double] = Custom.ProWO(real.yProperty); def y = real.getY; def y_=(v: Double) = real.setY(v)

}

object VLineTo extends A.Delegate.Data.Setup[VLineTo, JAVA] {

  def make() = new VLineTo(new JAVA)

  def make(v: JAVA) = new VLineTo(v)

  def make(x: Double) = new VLineTo(new JAVA(x))
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
