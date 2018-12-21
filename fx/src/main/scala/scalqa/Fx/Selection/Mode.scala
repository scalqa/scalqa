package scalqa; package Fx.Selection

import javafx.scene.control.{ SelectionMode => JAVA }

sealed class Mode(v: JAVA) extends Util.Enum.A.Java[Mode, JAVA](v, Mode) {

  def isSingle = this == Mode.Single

  def isMultiple = this == Mode.Multiple

}

object Mode extends Util.Enum.A.Java.Setup[Mode, JAVA] {

  val Single = new Mode(JAVA.SINGLE)
  val Multiple = new Mode(JAVA.MULTIPLE)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
