package scalqa; package Fx; package Shape; package Path

import javafx.scene.shape.{ FillRule => JAVA }

class FillRule protected[Path] (p: JAVA) extends Util.Enum.A.Java[FillRule, JAVA](p, FillRule)

object FillRule extends Util.Enum.A.Java.Setup[FillRule, JAVA] {

  val EvenOdd = new FillRule(JAVA.EVEN_ODD)
  val NonZero = new FillRule(JAVA.NON_ZERO)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
