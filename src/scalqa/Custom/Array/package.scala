package scalqa; package Custom

package object Array {

  def make[A: ClassTag](v: A*): Array[A] = v match {
    case w: collection.mutable.WrappedArray[A] => w.array
    case v => v.toArray
  }

  private[scalqa] def emptyAs[T](a: Array[T], newSize: Int): Array[T] = java.lang.reflect.Array.newInstance(a.getClass.getComponentType, newSize).asInstanceOf[Array[T]]

}
