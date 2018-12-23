package scalqa; package Custom

package object Array {

  def *[A: ClassTag](v: A*): Array[A] = v match {
    case w: collection.mutable.WrappedArray[A] => w.array
    case v => v.toArray
  }

  private[scalqa] def emptyAs[T](a: Array[T], newSize: Int): Array[T] = java.lang.reflect.Array.newInstance(a.getClass.getComponentType, newSize).asInstanceOf[Array[T]]

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
