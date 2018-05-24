package scalqa; package Array; package _library

class _Float private[Array] (private val raw: Array.Raw[Float]) extends AnyVal {

  def floats = raw: @inline

  def Floats = new Floats(floats)

}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @class _Float ->
 *
 *     This library is only available for [[Array]] of [[Float]]s ( Array[Float] ) and is invisible for other types
 *
 * @def floats -> Raw floats
 *
 *     Underlying Array.Raw[Float]
 *
 *     Same as 'raw', but with strict Float type
 *
 * @def Floats -> Create view
 *
 *     Built-in constructor to create [[Array.View.Floats]] instances
 *
 *     Sending [[Floats]] to another method is like sending this Array[Float],
 *     but without ability to update data
 *
 *     Essentially this is like creating unmodifiable "view"
 *
 *     The data can still be updated in the original array and the change will be reflected in the view.
 *
 */
