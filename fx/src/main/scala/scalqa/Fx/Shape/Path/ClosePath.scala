package scalqa; package Fx; package Shape; package Path

import javafx.scene.shape.{ ClosePath => JAVA }

class ClosePath private (val real: JAVA) extends AnyVal with Element with A.Delegate.Data[ClosePath, JAVA] {
  protected def setup = ClosePath

}

object ClosePath extends A.Delegate.Data.Setup[ClosePath, JAVA] {

  def make() = new ClosePath(new JAVA)

  def make(v: JAVA) = new ClosePath(v)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
