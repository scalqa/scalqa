package scalqa; package Fx; package A; package Region; package Background

import javafx.scene.layout.{ BackgroundImage => JAVA }

class Image private (val real: JAVA) extends A.Delegate.Data[Image, JAVA] {
  def setup = Image

}

object Image extends A.Delegate.Data.Setup[Image, JAVA] {

  def make(v: JAVA) = new Image(v)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
