package scalqa; package Array; package View

class Longs private[Array] (protected val raw: Array.Raw[Long]) extends AnyVal with Like[Long, Longs] {

  protected def _get(a: Array[Long]) = Longs.create(a.raw.cast)

}

object Longs extends Z.Companion[Long, Longs](new Longs(_), Array.Raw.emptyLongArray)

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @class Longs -> '''Array View of Longs'''
 *
 *     [[Longs]] is an unmodifiable view of an Array of [[Long]] primitives
 *
 *     It can be treated as an immutable object, as long as the reference to the base array is lost
 *     {{{
 *
 *         val view1: Longs       = (1L ~ 2L ~ 3L).toLongs // view1 is perfectly immutable
 *
 *         val array: Array[Long] = Array.get(4L, 5L, 6L)
 *
 *         val view2: Longs       = array.Longs            // view2 is mutable through array
 *
 *         val view3: Longs       = view1 +~ view2         // view3 is perfectly immutable again
 *     }}}
 *
 *     Note: All 'copy' methods return modifiable Array to work with, but it can be converted back to [[Longs]] in a snap:
 *     {{{
 *         val view4 = view3.copy(1 <> 3).Longs    // Explicitly
 *
 *         val view5 : Longs = view3.copy(1 <> 3)  // Implicitly
 *     }}}
 * @object Longs ->
 *
 *   There are two general ways to create Longs:
 *
 *     1. Special converter [[Pipe._library._Long.toLongs  toLongs]] is attached to every [[Pipe]] of [[Long]] values
 *        {{{
 *            val v: Longs = (1L ~ 2L ~ 3L).toLongs
 *        }}}
 *
 *     2. Special built-in constructor [[Array._library._Long.Longs Longs]] is attached to every [[Array]] of [[Long]] values
 *        {{{
 *            val array: Array[Long] = Array.get(1L, 2L, 3L)
 *
 *            val v: Longs = array.Longs
 *        }}}
 */
