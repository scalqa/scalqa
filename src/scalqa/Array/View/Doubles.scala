package scalqa; package Array; package View

class Doubles private[Array] (protected val raw: Array.Raw[Double]) extends AnyVal with Like[Double, Doubles] {

  protected def _get(a: Array[Double]) = Doubles.create(a.raw.cast)

}

object Doubles extends Z.Companion[Double, Doubles](new Doubles(_), Array.Raw.emptyDoubleArray)
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @class Doubles -> '''Array View of Doubles'''
 *
 *     [[Doubles]] is an unmodifiable view of an Array of [[Double]] primitives
 *
 *     It can be treated as an immutable object, as long as the reference to the base array is lost
 *     {{{
 *
 *         val view1: Doubles = (1.0 ~ 2.0 ~ 3.0).toDoubles        // view1 is perfectly immutable
 *
 *         val array: Array[Double] = Array.get(4.0, 5.0, 6.0)
 *
 *         val view2: Doubles = array.Doubles                      // view2 is mutable through array
 *
 *         val view3: Doubles = view1 +~ view2                     // view3 is perfectly immutable again
 *     }}}
 *
 *     Note: All 'copy' methods return modifiable Array to work with, but it can be converted back to [[Doubles]] in a snap:
 *     {{{
 *         val view4 = view3.copy(1 <> 3).Doubles    // Explicitly
 *
 *         val view5 : Doubles = view3.copy(1 <> 3)  // Implicitly
 *     }}}
 * @object Doubles ->
 *
 *   There are two general ways to create Doubles:
 *
 *     1. Special converter [[Pipe._library._Double.toDoubles  toDoubles]] is attached to every [[Pipe]] of [[Double]] values
 *        {{{
 *            val v: Doubles = (1.0 ~ 2.0 ~ 3.0).toDoubles
 *        }}}
 *
 *     2. Special built-in constructor [[Array._library._Double.Doubles Doubles]] is attached to every [[Array]] of [[Double]] values
 *        {{{
 *            val array: Array[Double] = Array.get(1.0, 2.0, 3.0)
 *
 *            val v: Doubles = array.Doubles
 *        }}}
 */
