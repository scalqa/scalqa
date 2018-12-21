package scalqa; package Fx; package A; package Region; package Background

import javafx.scene.layout.{ BackgroundFill => JAVA }

class Fill private (val real: JAVA) extends A.Delegate.Data[Fill, JAVA] {

  def setup = Fill
}

object Fill extends A.Delegate.Data.Setup[Fill, JAVA] {

  def make(v: JAVA) = new Fill(v)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
