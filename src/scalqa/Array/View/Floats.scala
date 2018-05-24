package scalqa; package Array; package View

class Floats private[Array] (protected val raw: Array.Raw[Float]) extends AnyVal with Like[Float, Floats] {

  protected def _get(a: Array[Float]) = Floats.create(a.raw.cast)

}

object Floats extends Z.Companion[Float, Floats](new Floats(_), Array.Raw.emptyFloatArray)
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @class Floats -> '''Array View of Floats'''
 *
 *     [[Floats]] is an unmodifiable view of an Array of [[Float]] primitives
 *
 *     It can be treated as an immutable object, as long as the reference to the base array is lost
 *     {{{
 *
 *         val view1: Floats       = (1F ~ 2F ~ 3F).toFloats // view1 is perfectly immutable
 *
 *         val array: Array[Float] = Array.get(4F, 5F, 6F)
 *
 *         val view2: Floats       = array.Floats            // view2 is mutable through array
 *
 *         val view3: Floats       = view1 +~ view2          // view3 is perfectly immutable again
 *     }}}
 *
 *     Note: All 'copy' methods return modifiable Array to work with, but it can be converted back to [[Floats]] in a snap:
 *     {{{
 *         val view4 = view3.copy(1 <> 3).Floats    // Explicitly
 *
 *         val view5 : Floats = view3.copy(1 <> 3)  // Implicitly
 *     }}}
 * @object Floats ->
 *
 *   There are two general ways to create Floats:
 *
 *     1. Special converter [[Pipe._library._Float.toFloats  toFloats]] is attached to every [[Pipe]] of [[Float]] values
 *        {{{
 *            val v: Floats = (1F ~ 2F ~ 3F).toFloats
 *        }}}
 *
 *     2. Special built-in constructor [[Array._library._Float.Floats Floats]] is attached to every [[Array]] of [[Float]] values
 *        {{{
 *            val array: Array[Float] = Array.get(1F, 2F, 3F)
 *
 *            val v: Floats = array.Floats
 *        }}}
 */
