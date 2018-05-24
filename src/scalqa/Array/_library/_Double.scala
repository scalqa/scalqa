package scalqa; package Array; package _library

class _Double private[Array] (private val raw: Array.Raw[Double]) extends AnyVal {

  def doubles = raw: @inline

  def Doubles = new Doubles(doubles)

}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @class _Double ->
 *
 *     This library is only available for [[Array]] of [[Double]]s ( Array[Double] ) and is invisible for other types
 *
 * @def doubles -> Raw doubles
 *
 *     Underlying Array.Raw[Double]
 *
 *     Same as 'raw', but with strict Double type
 *
 * @def Doubles -> Create view
 *
 *     Built-in constructor to create [[Array.View.Doubles]] instances
 *
 *     Sending [[Doubles]] to another method is like sending this Array[Double],
 *     but without ability to update data
 *
 *     Essentially this is like creating unmodifiable "view"
 *
 *     The data can still be updated in the original array and the change will be reflected in the view.
 *
 */
