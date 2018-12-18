package scalqa; package Any; package Collection; package Z

private[scalqa] class JavaCollectionView[A](real: Any.Collection[A]) extends java.util.AbstractCollection[A] {

  def iterator = real.all.to[java.util.Iterator];

  def size = real.size

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
