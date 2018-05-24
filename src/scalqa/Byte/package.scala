package scalqa

package object Byte {
  type Like = Like._Trait

  val Min = scala.Byte.MinValue

  val Max = scala.Byte.MaxValue

  protected[scalqa] val Class = classOf[java.lang.Byte]

  protected[scalqa] val ClassPrimitive = java.lang.Byte.TYPE

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @object Byte ->  Package for base '''scala.Byte''' type
 *
 * @val Min -> Minimum value.
 *
 *     Constant -2<sup>7</sup>
 *
 *    {{{ -128 }}}
 *
 * @val Max -> Maximum value.
 *
 *     Constant 2<sup>7</sup>-1
 *
 *    {{{ 127 }}}
 *
 */
