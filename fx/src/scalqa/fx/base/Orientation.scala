package scalqa; package fx; package base; import language.implicitConversions

import javafx.geometry.{ Orientation => JOrientation }

enum Orientation(val real: JOrientation) extends Fx.JavaFx.Enum[JOrientation]:
  case Horizontal extends Orientation(JOrientation.HORIZONTAL)
  case Vertical   extends Orientation(JOrientation.VERTICAL)

object Orientation extends Fx.JavaFx.Enum.Companion[Orientation, JOrientation]:
  implicit inline def implicitRequest(v: HORIZONTAL): Orientation = Horizontal
  implicit inline def implicitRequest(v: VERTICAL)  : Orientation = Vertical

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
