package scalqa; package Fx; package Paint; package Color

import javafx.scene.paint.{ Color => JColor }

class _Class private (val real: JColor) extends AnyVal with Paint with A.Delegate.Data[_Class, JColor] {
  protected def setup = _Class

}

object _Class extends A.Delegate.Data.Setup[_Class, JColor] {

  def make(v: JColor) = new Color(v)

}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
