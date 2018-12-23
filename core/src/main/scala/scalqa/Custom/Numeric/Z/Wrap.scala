package scalqa; package Custom; package Numeric; package Z

private[scalqa] class Wrap[A](val real: math.Numeric[A]) extends Numeric[A] {

  @inline final def negate(x: A) = real.negate(x)
  @inline final def minus(x: A, y: A) = real.minus(x, y)
  @inline final def plus(x: A, y: A) = real.plus(x, y)
  @inline final def times(x: A, y: A) = real.times(x, y)

  @inline final def fromInt(x: Int) = real.fromInt(x)
  @inline final def toDouble(x: A) = real.toDouble(x)
  @inline final def toFloat(x: A) = real.toFloat(x)
  @inline final def toInt(x: A) = real.toInt(x)
  @inline final def toLong(x: A) = real.toLong(x)

  def compare(x: A, y: A) = real.compare(x, y)
  def divByInt(v: A, int: Int) = real.divByInt(v, int)
  def toNumber(v: A) = Custom.Number.getOpt(v).value
  def toBig(v: A) = real.toDouble(v).Big

  override def zero = real.zero
  override def one = real.one

  override def abs(x: A): A = real.abs(x)
  override def signum(x: A): Int = real.signum(x)

}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
