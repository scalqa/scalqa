package scalqa; package fx; package base; package selection

import javafx.scene.control.{ SelectionMode => JMode }

enum Mode(val real: JMode) extends Fx.JavaFx.Enum[JMode]:
  case Single   extends Mode(JMode.SINGLE)
  case Multiple extends Mode(JMode.MULTIPLE)

object Mode extends Fx.JavaFx.Enum.Companion[Mode, JMode]:

  extension (inline x: Mode)
    inline def isSingle   : Boolean = x == Mode.Single
    inline def isMultiple : Boolean = x == Mode.Multiple

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
