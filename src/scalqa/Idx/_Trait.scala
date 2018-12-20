package scalqa; package Idx

trait _Trait[@specialized(DATA) +A] extends Any with Any.Collection[A] {

  def apply(idx: Int): A

  def all: ~[A] = Z.stream(this)

}

object _Trait extends Util.Void.Setup.Typed[Idx](Void) {

  implicit def zzLibrary[A](v: Idx[A]) = new _library._Class(v)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @trait _Trait -> `Indexed Collection`
 *
 *    In Indexed Collection elements can be accessed by positional index from 0 to size exclusive
 *
 *    It is a greatly simplified equivalent of java.util.List and scala.IndexedSeq
 *
 * @def apply -> Returns element at position
 *
 *    @param idx element position, must be in range (0 <>> size)
 *
 *    {{{
 *      val index = Idx.*(1,4,7,10)
 *      index(1).lp  // Prints: 4
 *      index(3).lp  // Prints: 10
 *    }}}
 *
 * @def all: -> Returns a Stream of all elements
 *
 *    The element order is same as in the Idx.
 *
 *    {{{
 *      val index = Idx.*(1,3,5,7)
 *      index.all.lp
 *      // Output
 *      ~(1, 3, 5, 7)
 *    }}}
 */
