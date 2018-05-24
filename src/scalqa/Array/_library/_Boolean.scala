package scalqa; package Array; package _library

class _Boolean private[Array] (private val raw: Array.Raw[Boolean]) extends AnyVal {

  def booleans = raw: @inline

  def Booleans = new Booleans(booleans)

}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @class _Boolean ->
 *
 *     This library is only available for [[Array]] of [[Boolean]]s ( Array[Boolean] ) and is invisible for other types
 *
 * @def booleans -> Raw booleans
 *
 *     Underlying Array.Raw[Boolean]
 *
 *     Same as 'raw', but with strict Boolean type
 *
 * @def Booleans -> Create view
 *
 *     Built-in constructor to create [[Array.View.Booleans]] instances
 *
 *     Sending [[Booleans]] to another method is like sending this Array[Boolean],
 *     but without ability to update data
 *
 *     Essentially this is like creating unmodifiable "view"
 *
 *     The data can still be updated in the original array and the change will be reflected in the view.
 *
 */
