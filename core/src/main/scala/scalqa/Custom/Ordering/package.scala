package scalqa; package Custom

package object Ordering {

  def make[A](implicit o: scala.Ordering[A]): Ordering[A] = o match {
    case v: Ordering[A] => v
    case v              => new Z.Wrap(o)
  }

  val Void: Ordering[Any] = A.Void

  val String: Ordering[String] = A.String

  val StringIgnoreCase: Ordering[String] = A.StringIgnoreCase

  val AnyToString: Ordering[Any] = A.AnyToString

  val Byte: Ordering[Byte] = Numeric.Z.Byte
  val Char: Ordering[Char] = Numeric.Z.Char
  val Short: Ordering[Short] = Numeric.Z.Short
  val Int: Ordering[Int] = Numeric.Z.Int
  val Long: Ordering[Long] = Numeric.Z.Long
  val Float: Ordering[Float] = Numeric.Z.Float
  val Double: Ordering[Double] = Numeric.Z.Double
  val Comparable: Ordering[Comparable[_]] = A.Comparable

  private object A {

    object Void extends Ordering[Any] with Void { def compare(x: Any, y: Any) = 0 }

    object String extends Ordering[String] { def compare(x: String, y: String) = x.compareTo(y) }

    object StringIgnoreCase extends Ordering[String] { def compare(x: String, y: String) = x.compareToIgnoreCase(y) }

    object AnyToString extends Ordering[Any] { def compare(x: Any, y: Any) = x.I.toString.compareToIgnoreCase(y.I.toString) }

    object Comparable extends Ordering[Comparable[_]] { def compare(x: Comparable[_], y: Comparable[_]) = x.compareTo(y.I.asInstanceOfTarget) }

  }
}
