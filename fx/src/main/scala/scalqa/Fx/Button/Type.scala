package scalqa; package Fx; package Button

import javafx.scene.control.ButtonType

class Type private (val real: ButtonType) extends AnyVal with A.Delegate.Data[Type, ButtonType] {
  protected def setup = Type

}

object Type extends A.Delegate.Data.Setup[Type, ButtonType] {

  def make(v: ButtonType) = new Type(v)

}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
