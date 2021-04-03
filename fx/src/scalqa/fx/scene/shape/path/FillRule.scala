package scalqa; package fx; package scene; package shape; package path

import javafx.scene.shape.{ FillRule => JFillRule }

enum FillRule(val real: JFillRule) extends Fx.JavaFx.Enum[JFillRule]:
  case EvenOdd extends FillRule(JFillRule.EVEN_ODD)
  case NonZero extends FillRule(JFillRule.NON_ZERO)

object FillRule extends Fx.JavaFx.Enum.Companion[FillRule,JFillRule]


/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
