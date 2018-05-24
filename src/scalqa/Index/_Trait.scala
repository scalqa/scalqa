package scalqa; package Index

trait _Trait[+A] extends Any with Coll[A] {

  def apply(idx: Int): A

  override def all: ~[A] = if (size == 0) \/ else new Z.all(this)

}

object _Trait extends Able.Void.Companion.Typed[Index](Void) {

  import scala.language.implicitConversions

  implicit def zzLibrary[A](v: Index[A]) = new _library(v)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @def apply -> Returns element at position
 *
 *    @param idx element position, must be in range (0 <>> size)
 *
 *    {{{
 *      val index = Index.get(1,4,7,10)
 *      index(1).lp  // Prints: 4
 *      index(3).lp  // Prints: 10
 *    }}}
 *
 * @def all: -> Returns a Pipe of all elements
 *
 *    The element order is same as in the Index.
 *
 *    {{{
 *      val index = Index.get(1,3,5,7)
 *      index.all.lp
 *      // Output
 *      ~(1, 3, 5, 7)
 *    }}}
 *
 * @trait _Trait -> '''Index Collection'''
 *
 *    In "Index Collection" elements can be accessed by positional index from 0 to size exclusive
 *
 *    It is a rough equivalent of java.util.List and scala.IndexedSeq
 */
