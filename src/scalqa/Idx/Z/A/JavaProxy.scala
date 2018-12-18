package scalqa; package Idx; package Z; package A

private[scalqa] trait JavaProxy[A] extends Idx[A] with Any.Wrap[java.util.List[A]] {

  def size = real.size

  def apply(i: Int) = real.get(i)

}

private[scalqa] object JavaProxy {

  def apply[A](l: java.util.List[A]): Idx[A] = new JavaProxy[A] { def real = l }

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
