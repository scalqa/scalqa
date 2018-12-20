package scalqa; package Idx; package Z; package A

private[scalqa] class JavaProxy[A](val real: java.util.List[A]) extends JavaProxy.Like[A]

private[scalqa] object JavaProxy {

  trait Like[A] extends Idx[A] with Any.Wrap[java.util.List[A]] {

    def size = real.size

    def apply(i: Int) = real.get(i)
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
