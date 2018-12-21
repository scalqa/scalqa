package scalqa; package Fx; package Text

import javafx.scene.text.{ Font => JAVA }

class Font private (val real: JAVA) extends AnyVal with A.Delegate.Data[Font, JAVA] {
  protected def setup = Font

}

object Font extends A.Delegate.Data.Setup[Font, JAVA] {

  def make(f: JAVA) = new Font(f)

  def make(family: String, size: Double) = new Font(JAVA.font(family, size))
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
