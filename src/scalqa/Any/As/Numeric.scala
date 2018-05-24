package scalqa; package Any; package As

import scalqa.Numeric.Math

abstract class Numeric[-TARGET, NUMERIC_BASE <: scalqa.Numeric] protected {
  type VALUE

  def apply(v: TARGET): VALUE

  def numeric(v: VALUE): NUMERIC_BASE

  def void: NUMERIC_BASE

  def math: Math[VALUE]

  def tag: Tag[VALUE]

}

object Numeric {

  implicit def ForInt: Numeric[Int, Int.The] = TheInt; private object TheInt extends Ints[Int] { def apply(v: Int) = v }
  implicit def ForDouble: Numeric[Double, Double.The] = TheDouble; private object TheDouble extends Doubles[Double] { def apply(v: Double) = v }
  implicit def ForLong: Numeric[Long, Long.The] = TheLong; private object TheLong extends Longs[Long] { def apply(v: Long) = v }
  implicit def ForShort: Numeric[Short, Short.The] = TheShort; private object TheShort extends Shorts[Short] { def apply(v: Short) = v }
  implicit def ForFloat: Numeric[Float, Float.The] = TheFloat; private object TheFloat extends Floats[Float] { def apply(v: Float) = v }

  implicit def ForIntLike: Numeric[Int.Like, Int.The] = TheIntLike; private object TheIntLike extends Ints[Int.Like] { def apply(v: Int.Like) = v.value }
  implicit def ForDoubleLike: Numeric[Double.Like, Double.The] = TheDoubleLike; private object TheDoubleLike extends Doubles[Double.Like] { def apply(v: Double.Like) = v.value }
  implicit def ForLongLike: Numeric[Long.Like, Long.The] = TheLongLike; private object TheLongLike extends Longs[Long.Like] { def apply(v: Long.Like) = v.value }
  implicit def ForShortLike: Numeric[Short.Like, Short.The] = TheShortLike; private object TheShortLike extends Shorts[Short.Like] { def apply(v: Short.Like) = v.value }
  implicit def ForFloatLike: Numeric[Float.Like, Float.The] = TheFloatLike; private object TheFloatLike extends Floats[Float.Like] { def apply(v: Float.Like) = v.value }

  // ----------------------------------------------------------------------------------------------------------------------------------------------------------
  private abstract class Ints[A] extends Numeric[A, Int.The] { type VALUE = Int; def tag = Tag.Int; def void = \/; def numeric(v: Int) = v.The; def math = Math.Int }
  private abstract class Doubles[A] extends Numeric[A, Double.The] { type VALUE = Double; def tag = Tag.Double; def void = \/; def numeric(v: Double) = v.The; def math = Math.Double }
  private abstract class Longs[A] extends Numeric[A, Long.The] { type VALUE = Long; def tag = Tag.Long; def void = \/; def numeric(v: Long) = v.The; def math = Math.Long }
  private abstract class Shorts[A] extends Numeric[A, Short.The] { type VALUE = Short; def tag = Tag.Short; def void = \/; def numeric(v: Short) = v.The; def math = Math.Short }
  private abstract class Floats[A] extends Numeric[A, Float.The] { type VALUE = Float; def tag = Tag.Float; def void = \/; def numeric(v: Float) = v.The; def math = Math.Float }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
