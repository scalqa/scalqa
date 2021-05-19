package scalqa; package gen; package math; import language.implicitConversions

abstract class Rounding private[math](val mode: java.math.RoundingMode, private[scalqa] val bigDecimalRounding: Int):
  def apply(v: Byte,   size: Byte)   : Byte   = apply(v.Int, size.Int).Byte
  def apply(v: Short,  size: Short)  : Short  = apply(v.Int, size.Int).Short
  def apply(v: Int,    size: Int)    : Int
  def apply(v: Float,  size: Float)  : Float  = apply(v.Double,size.Double).Float
  def apply(v: Long,   size: Long)   : Long
  def apply(v: Double, size: Double) : Double
  def decimal(v:Double,scale: Int)   : Double =
    val l = v.Long
    val m = Rounding.Multiplier(scale)
    val f = (v - l) * m
    l.Double + (f.Long + extra(f % 1d)) / m.Double

  private[math] def extra(v: Double)  : Long

object Rounding:
  val Up:     Rounding = rounding.Z.Up
  val Down:   Rounding = rounding.Z.Down
  val HalfUp: Rounding = rounding.Z.HalfUp

  given default : Rounding = HalfUp

  implicit inline def implicitDefaultRequest(v: DEFAULT): Rounding = HalfUp
  implicit inline def implicitUpRequest(v: UP)          : Rounding = Up
  implicit inline def implicitDownRequest(v: DOWN)      : Rounding = Down

  private val Multiplier: Array[Int] = ~~(1).unfold(_.last * 10).takeFirst(12).toArray
/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
