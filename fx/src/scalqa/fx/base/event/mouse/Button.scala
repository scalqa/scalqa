package scalqa; package fx; package base; package event; package mouse

import javafx.scene.input.{ MouseButton => JButton }

enum Button(val real: JButton) extends Fx.JavaFx.Enum[JButton]:
  case None   extends Button(JButton.NONE)
  case Left   extends Button(JButton.PRIMARY)
  case Middle extends Button(JButton.MIDDLE)
  case Right  extends Button(JButton.SECONDARY)

object Button extends Fx.JavaFx.Enum.Companion[Button, JButton]:

  extension (inline x: Button)
    inline def isLeft   : Boolean = x == Button.Left
    inline def isRight  : Boolean = x == Button.Right
    inline def isMiddle : Boolean = x == Button.Middle

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
