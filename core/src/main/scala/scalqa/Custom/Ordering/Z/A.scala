package scalqa; package Custom; package Ordering; package Z

private[Ordering] object A {

  object Void extends Ordering[Any] with Void { def compare(x: Any, y: Any) = 0 }

  object String extends Ordering[String] { def compare(x: String, y: String) = x.compareTo(y) }

  object StringIgnoreCase extends Ordering[String] { def compare(x: String, y: String) = x.compareToIgnoreCase(y) }

  object AnyToString extends Ordering[Any] { def compare(x: Any, y: Any) = x.I.toString.compareToIgnoreCase(y.I.toString) }

  object Comparable extends Ordering[Comparable[_]] { def compare(x: Comparable[_], y: Comparable[_]) = x.compareTo(y.I.asInstanceOfTarget) }

  object Number extends Ordering[Number] { def compare(x: Number, y: Number) = java.lang.Double.compare(x.doubleValue, y.doubleValue) }

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
