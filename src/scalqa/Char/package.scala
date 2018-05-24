package scalqa

package object Char {
  type Like = Like._Trait

  val Min = scala.Char.MinValue

  val Max = scala.Char.MaxValue

  protected[scalqa] val Class = classOf[java.lang.Character]

  protected[scalqa] val ClassPrimitive = java.lang.Character.TYPE
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @object Char ->  Package for base '''scala.Char''' type
 *
 * 
 * @val Min -> Minimum value.
 *
 *    Constant {{{'\u005Cu0000'}}}
 *
 *    Integer equivalent 0
 *
 * @val Max -> Maximum value.
 *
 *    Constant {{{'\u005CuFFFF'}}}
 *
 *    Integer equivalent 65,535
 *
 */
