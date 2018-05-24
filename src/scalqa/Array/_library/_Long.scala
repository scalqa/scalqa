package scalqa; package Array; package _library

class _Long private[Array] (private val raw: Array.Raw[Long]) extends AnyVal {

  def longs = raw: @inline

  def Longs = new Longs(longs)

}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @class _Long ->
 *
 *     This library is only available for [[Array]] of [[Long]]s ( Array[Long] ) and is invisible for other types
 *
 * @def longs -> Raw longs
 *
 *     Underlying Array.Raw[Long]
 *
 *     Same as 'raw', but with strict Long type
 *
 * @def Longs -> Create view
 *
 *     Built-in constructor to create [[Array.View.Longs]] instances
 *
 *     Sending [[Longs]] to another method is like sending this Array[Long],
 *     but without ability to update data
 *
 *     Essentially this is like creating unmodifiable "view"
 *
 *     The data can still be updated in the original array and the change will be reflected in the view.
 *
 */
