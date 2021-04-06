package scalqa; package fx; package ui; import language.implicitConversions

import javafx.geometry.{ HPos => JHPos }

enum HPos(val real: JHPos) extends Fx.JavaFx.Enum[JHPos]:
  case Left   extends HPos(JHPos.LEFT)
  case Center extends HPos(JHPos.CENTER)
  case Right  extends HPos(JHPos.RIGHT)

object HPos extends Fx.JavaFx.Enum.Companion[HPos, JHPos]:
  implicit inline def xxRequest(inline v: CENTER) : HPos = Center
  implicit inline def xxRequest(inline v: LEFT)   : HPos = Left
  implicit inline def xxRequest(inline v: RIGHT)  : HPos = Right

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
