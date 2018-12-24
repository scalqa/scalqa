package scalqa; package Custom; package Numeric

class _library[A] private[scalqa] (protected val real: math.Numeric[A]) extends AnyVal {

  def custom: Numeric[A] = real match {
    case n: Numeric[A] => n
    case _             => new Z.Wrap(real)
  }

  def divByInt(v: A, int: Int): A = real match {
    case n: Numeric[A]         => n.divByInt(v, int)
    case n: math.Integral[A]   => n.quot(v, n.fromInt(int))
    case n: math.Fractional[A] => n.div(v, n.fromInt(int))
    case _                     => App.Fail.state
  }

  def toNumber(v: A): Number = real match {
    case n: Numeric[A] => n.toNumber(v)
    case n             => n.toDouble(v)
  }

  def toBig(v: A): Util.BigDecimal = real match {
    case n: Numeric[A]       => n.toBig(v)
    case n: math.Integral[A] => Util.BigDecimal.make(n.toLong(v))
    case n                   => Util.BigDecimal.make(n.toDouble(v))
  }

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
