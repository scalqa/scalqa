package scalqa; package Numeric; package BigDecimal

import java.math.{ BigDecimal => J }

sealed class Round(private[BigDecimal] val real: Int)

object Round {
  val Down = new Round(J.ROUND_DOWN)
  val Ceiling = new Round(J.ROUND_CEILING)
  val Floor = new Round(J.ROUND_FLOOR)
  val HalfUp = new Round(J.ROUND_HALF_UP)
  val HalfDown = new Round(J.ROUND_HALF_DOWN)
  val HalfEven = new Round(J.ROUND_HALF_EVEN)
  val Unnecessary = new Round(J.ROUND_UNNECESSARY)
}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
