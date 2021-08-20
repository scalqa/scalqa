package scalqa; package fx; package base; import language.implicitConversions

import javafx.geometry.{ VPos => JVPos }

enum VPos(val real: JVPos) extends Fx.JavaFx.Enum[JVPos]:
  case Top      extends VPos(JVPos.TOP)
  case Center   extends VPos(JVPos.CENTER)
  case Baseline extends VPos(JVPos.BASELINE)
  case Bottom   extends VPos(JVPos.BOTTOM)

object VPos extends Fx.JavaFx.Enum.Companion[VPos, JVPos]:
  implicit inline def implicitFrom(v: CENTER): VPos = Center
  implicit inline def implicitFrom(v: TOP   ): VPos = Top
  implicit inline def implicitFrom(v: BOTTOM): VPos = Bottom

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
