package scalqa; package Coll; package Z; package As

private[scalqa] class Java[A](real: Coll[A]) extends java.util.AbstractCollection[A] {

  def iterator = real.all.as[java.util.Iterator];

  def size = real.size

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/