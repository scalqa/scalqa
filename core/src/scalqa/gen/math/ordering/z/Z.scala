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

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
