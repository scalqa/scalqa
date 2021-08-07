package scalqa; package gen; package math; package ordering; import language.implicitConversions

object Z:

  object OrderingForComparable extends Ordering[Comparable[Any]]:
    override def compare(x: Comparable[Any], y: Comparable[Any]) = x.compareTo(y)

  object Boolean          extends Ordering[Boolean]:
    def compare(x: Boolean, y: Boolean) = if (!x && y) -1 else if (x && !y) 1 else 0

  object AnyAsString      extends Ordering[Any]:
    private def str(v: Any): String = if (v == null) \/ else v.toString
    def compare(x: Any, y: Any) = str(x).compareToIgnoreCase(str(y))

  object Number extends Ordering[Number]:
    def compare(x: Number, y: Number) = java.lang.Double.compare(x.doubleValue, y.doubleValue)


  // ------------------------------------------------------------------------------------------------------------------
  import scala.math.{ Ordering as SMO }

  def join[A](x: SMO[A], c: SMO[A])                         : SMO[A]           = if (x.^.isVoid) c else if (c.^.isVoid) x else z.View.Joined[A](x, c)
  def rank_View[A](x: SMO[A],fun: A => Int)                 : Ordering[A]      = z.View.ByRank[A](x, fun)
  def opt_View[A](x: SMO[A],voidPosition: Int)              : Ordering[Opt[A]] = z.View.Option[A](x, voidPosition)
  def voidFirst_View[A](x: SMO[A])  (using Given.VoidDef[A]): Ordering[A]      = z.View.VoidPositionFirst[A](x)
  def voidLast_View [A](x: SMO[A])  (using Given.VoidDef[A]): Ordering[A]      = z.View.VoidPositionLast[A](x)
  def compare_Opt[A](x: SMO[A],v:Opt[A], w:Opt[A], none:Int): Int              = if (v.isEmpty) if (w.nonEmpty) none else 0 else if (w.isEmpty) none * -1 else x.compare(v.cast[A], w.cast[A])

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
