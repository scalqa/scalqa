package scalqa; package `val`; package idx; package z; package as; import language.implicitConversions

private[scalqa] class ArrayWrap[A](a: Array[A], sz: Int) extends Idx[A]:
  def apply(i: Int) = a(i)
  def size          = sz

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
