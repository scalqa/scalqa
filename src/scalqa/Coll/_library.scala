package scalqa; package Coll

class _library[A] private[Coll] (protected val This: Coll[A]) extends AnyVal with Z.LibraryBase[A] {

  def asJavaCollection: java.util.Collection[A] = new Z.As.Java(This)

}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @def asJavaCollection -> As Java Collection
 *
 *     Wraps this collection as Java unmodifiable Collection
 *
 */
