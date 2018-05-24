package scalqa; package Array; package _library

class _Byte private[Array] (private val raw: Array.Raw[Byte]) extends AnyVal {

  def bytes = raw: @inline

  def Bytes = new Bytes(bytes)

}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @class _Byte ->
 *
 *    This library is only available for [[Array]] of [[Byte]]s ( Array[Byte] ) and is invisible for other types
 *
 * @def bytes -> Raw bytes
 *
 *     Underlying Array.Raw[Byte]
 *
 *     Same as 'raw', but with strict Byte type
 *
 * @def Bytes -> Create view
 *
 *     Built-in constructor to create [[Array.View.Bytes]] instances
 *
 *     Sending [[Bytes]] to another method is like sending this Array[Byte],
 *     but without ability to update data
 *
 *     Essentially this is like creating unmodifiable "view"
 *
 *     The data can still be updated in the original array and the change will be reflected in the view.
 *
 */
