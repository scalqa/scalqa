package scalqa; package Custom

package object Ordering {

  def make[A](implicit o: scala.Ordering[A]): Ordering[A] = o match {
    case v: Ordering[A] => v
    case _              => new Z.Wrap(o)
  }

  val Void: Ordering[Any] = Z.A.Void

  val String: Ordering[String] = Z.A.String
  val StringIgnoreCase: Ordering[String] = Z.A.StringIgnoreCase
  val AnyToString: Ordering[Any] = Z.A.AnyToString

  val Number: Ordering[Number] = Z.A.Number
  val Byte: Ordering[Byte] = Numeric.Z.Byte
  val Char: Ordering[Char] = Numeric.Z.Char
  val Short: Ordering[Short] = Numeric.Z.Short
  val Int: Ordering[Int] = Numeric.Z.Int
  val Long: Ordering[Long] = Numeric.Z.Long
  val Float: Ordering[Float] = Numeric.Z.Float
  val Double: Ordering[Double] = Numeric.Z.Double
  val Comparable: Ordering[Comparable[_]] = Z.A.Comparable
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
