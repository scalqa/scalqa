package scalqa; package Array; package _library

class _Short private[Array] (private val raw: Array.Raw[Short]) extends AnyVal {

  def shorts = raw: @inline

  def Shorts = new Shorts(shorts)

}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @class _Short ->
 *
 *     This library is only available for [[Array]] of [[Short]]s ( Array[Short] ) and is invisible for other types
 *
 * @def shorts -> Raw shorts
 *
 *     Underlying Array.Raw[Short]
 *
 *     Same as 'raw', but with strict Short type
 *
 * @def Shorts -> Create view
 *
 *     Built-in constructor to create [[Array.View.Shorts]] instances
 *
 *     Sending [[Shorts]] to another method is like sending this Array[Short],
 *     but without ability to update data
 *
 *     Essentially this is like creating unmodifiable "view"
 *
 *     The data can still be updated in the original array and the change will be reflected in the view.
 *
 */
