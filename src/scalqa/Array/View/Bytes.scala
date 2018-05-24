package scalqa; package Array; package View

class Bytes private[Array] (protected val raw: Array.Raw[Byte]) extends AnyVal with Like[Byte, Bytes] {

  protected def _get(a: Array[Byte]) = Bytes.create(a.raw.cast)

}

object Bytes extends Z.Companion[Byte, Bytes](new Bytes(_), Array.Raw.emptyByteArray)
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @class Bytes -> '''Array View of Bytes'''
 *
 *     [[Bytes]] is an unmodifiable view of an Array of [[Byte]] primitives
 *
 *     It can be treated as an immutable object, as long as the reference to the base array is lost
 *     {{{
 *
 *         val view1: Bytes       = (1 <> 3).all.map(_.toByte).toBytes // view1 is perfectly immutable
 *
 *         val array: Array[Byte] = (4 <> 6).all.map(_.toByte).to[Array]
 *
 *         val view2: Bytes       = array.Bytes                        // view2 is mutable through array
 *
 *         val view3: Bytes       = view1 +~ view2                     // view3 is perfectly immutable again
 *     }}}
 *
 *     Note: All 'copy' methods return modifiable Array to work with, but it can be converted back to [[Bytes]] in a snap:
 *     {{{
 *         val view4 = view3.copy(1 <> 3).Bytes    // Explicitly
 *
 *         val view5 : Bytes = view3.copy(1 <> 3)  // Implicitly
 *     }}}
 * @object Bytes ->
 *
 *   There are two general ways to create Bytes:
 *
 *     1. Special converter [[Pipe._library._Byte.toBytes  toBytes]] is attached to every [[Pipe]] of [[Byte]] values
 *        {{{
 *            val v: Bytes = (1 <> 3).all.map(_.toByte).toBytes
 *        }}}
 *
 *     2. Special built-in constructor [[Array._library._Byte.Bytes Bytes]] is attached to every [[Array]] of [[Byte]] values
 *        {{{
 *            val array: Array[Byte] = Array.get(1.toByte, 2.toByte)
 *
 *            val v: Bytes = array.Bytes
 *        }}}
 */
