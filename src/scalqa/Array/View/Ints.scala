package scalqa; package Array; package View

class Ints private[Array] (protected val raw: Array.Raw[Int]) extends AnyVal with Like[Int, Ints] {

  protected def _get(a: Array[Int]) = Ints.create(a.raw.cast)
}

object Ints extends Z.Companion[Int, Ints](new Ints(_), Array.Raw.emptyIntArray)

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @class Ints -> '''Array View of Ints'''
 *
 *     [[Ints]] is an unmodifiable view of an Array of [[Int]] primitives
 *
 *     It can be treated as an immutable object, as long as the reference to the base array is lost
 *     {{{
 *
 *         val view1: Ints       = (1 <> 3).all.toInts // view1 is perfectly immutable
 *
 *         val array: Array[Int] = Array.get(4, 5, 6)
 *
 *         val view2: Ints       = array.Ints          // view2 is mutable through array
 *
 *         val view3: Ints       = view1 +~ view2      // view3 is perfectly immutable again
 *     }}}
 *
 *     Note: All 'copy' methods return modifiable Array to work with, but it can be converted back to [[Ints]] in a snap:
 *     {{{
 *         val view4 = view3.copy(1 <> 3).Ints    // Explicitly
 *
 *         val view5 : Ints = view3.copy(1 <> 3)  // Implicitly
 *     }}}
 * @object Ints ->
 *
 *   There are two general ways to create Ints:
 *
 *     1. Special converter [[Pipe._library._Int.toInts  toInts]] is attached to every [[Pipe]] of [[Int]] values
 *        {{{
 *            val v: Ints = (1 ~ 2 ~ 3 ~ 4).toInts
 *        }}}
 *
 *     2. Special built-in constructor [[Array._library._Int.Ints Ints]] is attached to every [[Array]] of [[Int]] values
 *        {{{
 *            val array: Array[Int] = Array.get(1, 2, 3, 4)
 *
 *            val v: Ints = array.Ints
 *        }}}
 */
