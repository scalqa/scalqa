package scalqa; package fx; package base; import language.implicitConversions

import javafx.geometry.{ Side => JSide }

enum Side(val real: JSide) extends Fx.JavaFx.Enum[JSide]:
  case Bottom extends Side(JSide.BOTTOM)
  case Left   extends Side(JSide.LEFT)
  case Right  extends Side(JSide.RIGHT)
  case Top    extends Side(JSide.TOP)

object Side extends Fx.JavaFx.Enum.Companion[Side, JSide]:
  implicit inline def implicitRequest(v: LEFT)  : Side = Left
  implicit inline def implicitRequest(v: RIGHT) : Side = Right
  implicit inline def implicitRequest(v: TOP   ): Side = Top
  implicit inline def implicitRequest(v: BOTTOM): Side = Bottom

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
