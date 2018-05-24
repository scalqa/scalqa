package scalqa; package Array; package View

class Booleans private[Array] (protected val raw: Array.Raw[Boolean]) extends AnyVal with Like[Boolean, Booleans] {

  protected def _get(a: Array[Boolean]) = Booleans.create(a.raw.cast)

}

object Booleans extends Z.Companion[Boolean, Booleans](new Booleans(_), Array.Raw.emptyBooleanArray)

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @class Booleans -> '''Array View of Booleans'''
 *
 *     [[Booleans]] is an unmodifiable view of an Array of [[Boolean]] primitives
 *
 *     It can be treated as an immutable object, as long as the reference to the base array is lost
 *     {{{
 *
 *         val view1: Booleans       = (true ~ false ~ true).toBooleans // view1 is perfectly immutable
 *
 *         val array: Array[Boolean] = Array.get(true, false, true )
 *
 *         val view2: Booleans       = array.Booleans                   // view2 is mutable through array
 *
 *         val view3: Booleans       = view1 +~ view2                   // view3 is perfectly immutable again
 *     }}}
 *
 *     Note: All 'copy' methods return modifiable Array to work with, but it can be converted back to [[Booleans]] in a snap:
 *     {{{
 *         val view4 = view3.copy(1 <> 3).Booleans    // Explicitly
 *
 *         val view5 : Booleans = view3.copy(1 <> 3)  // Implicitly
 *     }}}
 * @object Booleans ->
 *
 *   There are two general ways to create Booleans:
 *
 *     1. Special converter [[Pipe._library._Boolean.toBooleans  toBooleans]] is attached to every [[Pipe]] of [[Boolean]] values
 *        {{{
 *            val v: Booleans = (true ~ true ~ false ~ false).toBooleans
 *        }}}
 *
 *     2. Special built-in constructor [[Array._library._Boolean.Booleans Booleans]] is attached to every [[Array]] of [[Boolean]] values
 *        {{{
 *            val array: Array[Boolean] = Array.get(true, true, false, false)
 *
 *            val v: Booleans = array.Booleans
 *        }}}
 */
