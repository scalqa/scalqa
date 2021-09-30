package scalqa; package gen; package math; import language.implicitConversions

abstract class Rounding private[math](val mode: java.math.RoundingMode, private[scalqa] val bigDecimalRounding: Int):
  def apply(v: Byte,   size: Byte)   : Byte     = apply(v.toInt, size.toInt).toByte
  def apply(v: Short,  size: Short)  : Short    = apply(v.toInt, size.toInt).toShort
  def apply(v: Int,    size: Int)    : Int
  def apply(v: Float,  size: Float)  : Float    = apply(v.toDouble,size.toDouble).toFloat
  def apply(v: Long,   size: Long)   : Long
  def apply(v: Double, size: Double) : Double
  def decimal(v:Double,scale: Int)   : Double   = { val l = v.toLong
    /**/                                            val m = Rounding.Multiplier(scale)
    /**/                                            val f = (v - l) * m
    /**/                                            l.toDouble + (f.toLong + extra(f % 1d)) / m.toDouble }

  private[math] def extra(v: Double)  : Long

object Rounding:
  val Up:     Rounding = z.Rounding.Up
  val Down:   Rounding = z.Rounding.Down
  val HalfUp: Rounding = z.Rounding.HalfUp

  given default : Rounding = HalfUp

  implicit inline def implicitRequest(v: DEFAULT): Rounding = HalfUp
  implicit inline def implicitRequest(v: UP)     : Rounding = Up
  implicit inline def implicitRequest(v: DOWN)   : Rounding = Down

  private val Multiplier: Array[Int] = ~~(1).unfold(_.last * 10).takeFirst(12).toArray
/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
