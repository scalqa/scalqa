package scalqa; package Array; package View

class Shorts private[Array] (protected val raw: Array.Raw[Short]) extends AnyVal with Like[Short, Shorts] {

  protected def _get(a: Array[Short]) = Shorts.create(a.raw.cast)

}

object Shorts extends Z.Companion[Short, Shorts](new Shorts(_), Array.Raw.emptyShortArray)
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @class Shorts -> '''Array View of Shorts'''
 *
 *     [[Shorts]] is an unmodifiable view of an Array of [[Short]] primitives
 *
 *     It can be treated as an immutable object, as long as the reference to the base array is lost
 *     {{{
 *
 *         val view1: Shorts       = (1 <> 3).all.map(_.toShort).toBytes // view1 is perfectly immutable
 *
 *         val array: Array[Short] = (4 <> 6).all.map(_.toShort).to[Array]
 *
 *         val view2: Shorts       = array.Shorts                        // view2 is mutable through array
 *
 *         val view3: Shorts       = view1 +~ view2                      // view3 is perfectly immutable again
 *     }}}
 *
 *     Note: All 'copy' methods return modifiable Array to work with, but it can be converted back to [[Shorts]] in a snap:
 *     {{{
 *         val view4 = view3.copy(1 <> 3).Shorts    // Explicitly
 *
 *         val view5 : Shorts = view3.copy(1 <> 3)  // Implicitly
 *     }}}
 * @object Shorts ->
 *
 *   There are two general ways to create Shorts:
 *
 *     1. Special converter [[Pipe._library._Short.toShorts  toShorts]] is attached to every [[Pipe]] of [[Short]] values
 *        {{{
 *            val v: Shorts = (1 <> 3).all.map(_.toShort).toShorts
 *        }}}
 *
 *     2. Special built-in constructor [[Array._library._Short.Shorts Shorts]] is attached to every [[Array]] of [[Short]] values
 *        {{{
 *            val array: Array[Short] = Array.get(1.toShort, 2.toShort)
 *
 *            val v: Shorts = array.Shorts
 *        }}}
 */
