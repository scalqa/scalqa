package scalqa; package Custom

sealed abstract class Rounding {

  private[scalqa] def bigDecimalRound: Int

  private[scalqa] def remainder(value: Long, remainder: Long): Long

  private[scalqa] def scale(d: Double, scale: Int): Double = {
    val l = d.toLong
    val m: Long = Rounding.Multiplier(scale.abs)
    if (scale < 0) {
      remainder(l, m)
    } else {
      val f = (d - l) * m
      l.toDouble + (f.toLong + extra(f % 1d): @inline) / m.toDouble
    }
  }

  private[scalqa] def extra(v: Double): Long
}

object Rounding extends {
  private val Multiplier: Longs = 1L.I.unfold(_.last * 10L).letNext(12).toPrimitive[Longs]

  val Up: Rounding = A.Up
  val Down: Rounding = A.Down
  val Void: Rounding = A.Void

  implicit def zzMakeUp(v: UP.type) = Up
  implicit def zzMakeDown(v: DOWN.type) = Down
  implicit def zzMakeVoid(v: \/) = Void

  // *******************************************************************
  private object A {

    object Up extends Rounding {
      def bigDecimalRound = java.math.BigDecimal.ROUND_CEILING
      def remainder(v: Long, r: Long) = { val rv = v - v % r; if (rv < v) rv + r else rv }
      def extra(v: Double) = if (v > 0) 1 else 0
    }
    object Down extends Rounding {
      def bigDecimalRound = java.math.BigDecimal.ROUND_FLOOR
      def remainder(v: Long, r: Long) = v - v % r
      def extra(v: Double) = if (v < 0) -1 else 0
    }

    object Void extends Rounding with Void {
      def bigDecimalRound = java.math.BigDecimal.ROUND_HALF_UP
      def remainder(v: Long, r: Long) = { val dif = v % r; val rv = v - dif; if (rv < v && dif >= r) rv + r else rv }
      def extra(v: Double) = if (v >= 0.5D) 1 else if (v <= -0.5D) -1 else 0
    }
  }
}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
