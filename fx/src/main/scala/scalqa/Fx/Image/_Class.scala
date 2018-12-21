package scalqa; package Fx; package Image

import javafx.scene.image.{ Image => JImage }

class _Class private (val real: JImage) extends AnyVal with A.Delegate.Data[_Class, JImage] with Any.Able.ToInfo {
  protected def setup = _Class

  def widthPro: Pro.O[Double] = Custom.ProO(real.widthProperty); def width = real.getWidth

  def heightPro: Pro.O[Double] = Custom.ProO(real.heightProperty); def height = real.getHeight

  def isError = real.isError

  def toInfo = new Pro.Info(this) += ("width", width) += ("height", height)

}

object _Class extends A.Delegate.Data.Setup[Image, JImage] {

  def make(v: JImage) = new Image(v)

  implicit def zzFx(v: JImage): Image = make(v)

  implicit def zzMake(v: Image): JImage = make(v)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
