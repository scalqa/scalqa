package scalqa; package Array; package _library

class _Int private[Array] (private val raw: Array.Raw[Int]) extends AnyVal {

  def ints = raw: @inline

  def Ints = new Ints(ints)

}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @class _Int ->
 *
 *     This library is only available for [[Array]] of [[Int]]s ( Array[Int] ) and is invisible for other types
 *
 * @def ints -> Raw ints
 *
 *     Underlying Array.Raw[Int]
 *
 *     Same as 'raw', but with strict Int type
 *
 * @def Ints -> Create view
 *
 *     Built-in constructor to create [[Array.View.Ints]] instances
 *
 *     Sending [[Ints]] to another method is like sending this Array[Int],
 *     but without ability to update data
 *
 *     Essentially this is like creating unmodifiable "view"
 *
 *     The data can still be updated in the original array and the change will be reflected in the view.
 *
 */
