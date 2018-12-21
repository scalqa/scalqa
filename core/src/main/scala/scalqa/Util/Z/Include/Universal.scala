package scalqa.Util.Z.Include

import scalqa.Util.{ Universal => V }

private[scalqa] trait Universal {

  val NOW = V.NOW

  val NEW = V.NEW

  val DEFAULT = V.DEFAULT

  val AS_IS = V.AS_IS

  val ANY = V.ANY
  val NONE = V.NONE

  val ON = V.ON
  val OFF = V.OFF

  val LEFT = V.LEFT
  val RIGHT = V.RIGHT

  val CENTER = V.CENTER

  val TOP = V.TOP
  val BOTTOM = V.BOTTOM

  val HORIZONTAL = V.HORIZONTAL
  val VERTICAL = V.VERTICAL

  val UP = V.UP
  val DOWN = V.DOWN

  val SEPARATOR = V.SEPARATOR

  val SUCCESS = V.SUCCESS

  type \/ = V.VOID.type; val \/ = V.VOID
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @type \/ -> Alias
 *
 *    Universal void type and value
 *
 *    Globally used to assign void values
 *
 *    Types with void values have to define implicit conversions
 *
 *    {{{
 *      class Foo
 *
 *      object Foo{
 *        val Void = new Foo with Void
 *
 *        implicit def zzMake(v: \/) = Void
 *      }
 *
 *      var f: Foo = \/
 *
 *      var i: Int = \/
 *      var t: Time = \/
 *      var s: ~[Int] = \/
 *      var x: Idx[Int] = \/
 *      var o: Opt[String] = \/
 *    }}}
 *
 * @val UP -> Universal value
 *
 *    Globally available Universal value object [[Util.Universal.UP UP]]
 *
 *    See [[Util.Universal]] for usage
 *
 * @val DOWN -> Universal value
 *
 *    Globally available Universal value object [[Util.Universal.DOWN DOWN]]
 *
 *    See [[Util.Universal]] for usage
 *
 * @val NOW -> Universal value
 *
 *    Globally available Universal value object [[Util.Universal.NOW NOW]]
 *
 *    See [[Util.Universal]] for usage
 *
 * @val NEW -> Universal value
 *
 *    Globally available Universal value object [[Util.Universal.NEW NEW]]
 *
 *    See [[Util.Universal]] for usage
 *
 * @val AS_IS -> Universal value
 *
 *    Globally available Universal value object [[Util.Universal.AS_IS AS_IS]]
 *
 *    See [[Util.Universal]] for usage
 *
 * @val DEFAULT -> Universal value
 *
 *    Globally available Universal value object [[Util.Universal.DEFAULT DEFAULT]]
 *
 *    See [[Util.Universal]] for usage
 *
 * @val ANY -> Universal value
 *
 *    Globally available Universal value object [[Util.Universal.ANY ANY]]
 *
 *    See [[Util.Universal]] for usage
 *
 * @val NONE -> Universal value
 *
 *    Globally available Universal value object [[Util.Universal.NONE NONE]]
 *
 *    See [[Util.Universal]] for usage
 *
 * @val BOTTOM -> Universal value
 *
 *    Globally available Universal value object [[Util.Universal.BOTTOM BOTTOM]]
 *
 *    See [[Util.Universal]] for usage
 *
 * @val CENTER -> Universal value
 *
 *    Globally available Universal value object [[Util.Universal.CENTER CENTER]]
 *
 *    See [[Util.Universal]] for usage
 *
 * @val LEFT -> Universal value
 *
 *    Globally available Universal value object [[Util.Universal.LEFT LEFT]]
 *
 *    See [[Util.Universal]] for usage
 *
 * @val RIGHT -> Universal value
 *
 *    Globally available Universal value object [[Util.Universal.RIGHT RIGHT]]
 *
 *    See [[Util.Universal]] for usage
 *
 * @val ON -> Universal value
 *
 *    Globally available Universal value object [[Util.Universal.ON ON]]
 *
 *    See [[Util.Universal]] for usage
 *
 * @val OFF -> Universal value
 *
 *    Globally available Universal value object [[Util.Universal.OFF OFF]]
 *
 *    See [[Util.Universal]] for usage
 *
 * @val TOP -> Universal value
 *
 *    Globally available Universal value object [[Util.Universal.TOP TOP]]
 *
 *    See [[Util.Universal]] for usage
 *
 * @val HORIZONTAL -> Universal value
 *
 *    Globally available Universal value object [[Util.Universal.HORIZONTAL HORIZONTAL]]
 *
 *    See [[Util.Universal]] for usage
 *
 * @val VERTICAL -> Universal value
 *
 *    Globally available Universal value object [[Util.Universal.VERTICAL VERTICAL]]
 *
 *    See [[Util.Universal]] for usage
 *
 * @val SEPARATOR -> Universal value
 *
 *    Globally available Universal value object [[Util.Universal.SEPARATOR SEPARATOR]]
 *
 *    See [[Util.Universal]] for usage
 *
 * @val SUCCESS -> Universal value
 *
 *    Globally available Universal value object [[Util.Universal.SUCCESS SUCCESS]]
 *
 *    See [[Util.Universal]] for usage
 */
