package scalqa; package Fx; package Shape; package Path

import javafx.scene.shape.{ HLineTo => JAVA }

class HLineTo private (val real: JAVA) extends AnyVal with Element with A.Delegate.Data[HLineTo, JAVA] {
  protected def setup = HLineTo

  def xPro: Pro.OM[Double] = Custom.ProWO(real.xProperty); def x = real.getX; def x_=(v: Double) = real.setX(v)

}

object HLineTo extends A.Delegate.Data.Setup[HLineTo, JAVA] {

  def make() = new HLineTo(new JAVA)

  def make(v: JAVA) = new HLineTo(v)

  def make(x: Double) = new HLineTo(new JAVA(x))
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
