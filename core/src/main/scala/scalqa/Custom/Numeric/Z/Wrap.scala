package scalqa; package Custom; package Numeric; package Z

private[scalqa] class Wrap[A](val real: math.Numeric[A]) extends Numeric[A] {

  def negate(x: A) = real.negate(x)
  def minus(x: A, y: A) = real.minus(x, y)
  def plus(x: A, y: A) = real.plus(x, y)
  def times(x: A, y: A) = real.times(x, y)

  def fromInt(x: Int) = real.fromInt(x)
  def toDouble(x: A) = real.toDouble(x)
  def toFloat(x: A) = real.toFloat(x)
  def toInt(x: A) = real.toInt(x)
  def toLong(x: A) = real.toLong(x)

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
