package scalqa; package Sorting; package The

object JavaComparable extends Z.Default[java.lang.Comparable[_]] {

  protected def position(x: java.lang.Comparable[_], y: java.lang.Comparable[_]) = Position.getByInt(x.compareTo(y.cast))

}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
