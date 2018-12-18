package scalqa; package Any; package Collection

private[scalqa] trait _library[A] extends Any with Any.Wrap[Any.Collection[A]] {

  def ~ : Stream[A] = real.all

  @inline def isEmpty = real.size == 0

  @inline def asMappedView[B](f: A => B): Any.Collection[B] = new Z.MappedView[A, B](real, f)

  def asJavaCollectionView: java.util.Collection[A] = new Z.JavaCollectionView(real)

}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @def asJavaCollectionView -> As Java Collection
 *
 *     Wraps this collection as Java unmodifiable Collection
 *
 */
