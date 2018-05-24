package scalqa; package Array; package _library

class _Char private[Array] (private val raw: Array.Raw[Char]) extends AnyVal {

  def chars = raw: @inline

  def Chars = new Chars(chars)

}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @class _Char ->
 *
 *     This library is only available for [[Array]] of [[Char]]s ( Array[Char] ) and is invisible for other types
 *
 * @def chars -> Raw chars
 *
 *     Underlying Array.Raw[Char]
 *
 *     Same as 'raw', but with strict Char type
 *
 * @def Chars -> Create view
 *
 *     Built-in constructor to create [[Array.View.Chars]] instances
 *
 *     Sending [[Chars]] to another method is like sending this Array[Char],
 *     but without ability to update data
 *
 *     Essentially this is like creating unmodifiable "view"
 *
 *     The data can still be updated in the original array and the change will be reflected in the view.
 *
 */
