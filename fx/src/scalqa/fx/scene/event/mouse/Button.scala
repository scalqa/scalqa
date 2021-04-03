package scalqa; package fx; package scene; package event; package mouse

import javafx.scene.input.{ MouseButton => JButton }

enum Button(val real: JButton) extends Fx.JavaFx.Enum[JButton]:
  case None   extends Button(JButton.NONE)
  case Left   extends Button(JButton.PRIMARY)
  case Middle extends Button(JButton.MIDDLE)
  case Right  extends Button(JButton.SECONDARY)

  def isLeft   : Boolean = this == Button.Left
  def isRight  : Boolean = this == Button.Right
  def isMiddle : Boolean = this == Button.Middle

object Button extends Fx.JavaFx.Enum.Companion[Button, JButton]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
