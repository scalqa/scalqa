package scalqa; package Fx; package Event; package Mouse

import javafx.scene.input.{ MouseButton => JAVA }

sealed class Button(v: JAVA) extends Util.Enum.A.Java[Button, JAVA](v, Button) {

  def isLeft = this == Button.Left

  def isRight = this == Button.Right

  def isMiddle = this == Button.Middle

}

object Button extends Util.Enum.A.Java.Setup[Button, JAVA] {

  val * = new Button(JAVA.NONE)
  val Left = new Button(JAVA.PRIMARY)
  val Middle = new Button(JAVA.MIDDLE)
  val Right = new Button(JAVA.SECONDARY)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
