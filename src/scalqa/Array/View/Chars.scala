package scalqa; package Array; package View

class Chars private[Array] (protected val raw: Array.Raw[Char]) extends AnyVal with Like[Char, Chars] {

  protected def _get(a: Array[Char]) = Chars.create(a.raw.cast)

}

object Chars extends Z.Companion[Char, Chars](new Chars(_), Array.Raw.emptyCharArray) {
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @class Chars -> '''Array View of Chars'''
 *
 *     [[Chars]] is an unmodifiable view of an Array of [[Char]] primitives
 *
 *     It can be treated as an immutable object, as long as the reference to the base array is lost
 *     {{{
 *
 *         val view1: Chars       = ('A' ~ 'B' ~ 'C').toChars      // view1 is perfectly immutable
 *
 *         val array: Array[Char] = Array.get('D', 'E', 'F')
 *
 *         val view2: Chars       = array.Chars                    // view2 is mutable through array
 *
 *         val view3: Chars       = view1 +~ view2                 // view3 is perfectly immutable again
 *     }}}
 *
 *     Note: All 'copy' methods return modifiable Array to work with, but it can be converted back to [[Chars]] in a snap:
 *     {{{
 *         val view4 = view3.copy(1 <> 3).Chars    // Explicitly
 *
 *         val view5 : Chars = view3.copy(1 <> 3)  // Implicitly
 *     }}}
 * @object Chars ->
 *
 *   There are two general ways to create Chars:
 *
 *     1. Special converter [[Pipe._library._Char.toChars  toChars]] is attached to every [[Pipe]] of [[Char]] values
 *        {{{
 *            val v: Chars = ('A' ~ 'B' ~ 'C').toChars
 *        }}}
 *
 *     2. Special built-in constructor [[Array._library._Char.Chars Chars]] is attached to every [[Array]] of [[Char]] values
 *        {{{
 *            val array: Array[Char] = Array.get('A', 'B', 'C')
 *
 *            val v: Chars = array.Chars
 *        }}}
 */
