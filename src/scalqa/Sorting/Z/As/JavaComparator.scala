package scalqa; package Sorting; package Z; package As

private[Sorting] class JavaComparator[A](o: Sorting[A]) extends java.util.Comparator[A] {

  def compare(x: A, y: A): Int = o(x, y).signum

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/