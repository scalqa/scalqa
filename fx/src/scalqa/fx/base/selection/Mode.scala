package scalqa; package fx; package base; package selection

import javafx.scene.control.{ SelectionMode => JMode }

enum Mode(val real: JMode) extends Fx.JavaFx.Enum[JMode]:
  case Single   extends Mode(JMode.SINGLE)
  case Multiple extends Mode(JMode.MULTIPLE)

  def isSingle   : Boolean = this == Mode.Single
  def isMultiple : Boolean = this == Mode.Multiple

object Mode extends Fx.JavaFx.Enum.Companion[Mode, JMode]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
