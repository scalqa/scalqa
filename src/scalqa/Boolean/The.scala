package scalqa; package Boolean

sealed class The private (val value: Boolean, override val isVoid: Boolean) extends Able.Void {

  def not: The = if (isVoid) this else The.get(!value)

  override def toString = if (isVoid) "void" else value.toString

}

object The {

  val Void = new The(false, true)
  val True = new The(true, false)
  val False = new The(false, false)

  def get(v: Boolean): The = if (v) True else False

  import scala.language.implicitConversions
  implicit def zzGet(v: Boolean) = get(v)
  implicit def zzGet(v: \/.type) = Void
  implicit def zzThe(v: The) = v.value
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @class The -> '''The Boolean'''
 *
 *   "The" is a [[Boolean]] substitute if 3 values are required: True, False, and Void
 *
 * @object The ->
 *
 *   The easiest way to build [[Boolean.The]] is with built-in constructor
 *
 *   {{{
 *       val t : Boolean.The = true.The
 *
 *       val f : Boolean.The = false.The
 *
 *       val v : Boolean.The = \/
 *   }}}
 *
 * @def toString -> Description
 *
 *     Returns "true", "false", or "void"
 *
 * @def not -> Reverse
 *
 *     Returns:
 *
 *     - True if False
 *     - False if True
 *     - Void if Void
 *
 * @val Void -> Void false
 *
 *    Void evaluates to [[Boolean]] ''false'' and tests isVoid positive
 *
 * @val True -> true
 *
 *    Evaluates to [[Boolean]] ''true''
 *
 * @val False -> false
 *
 *    Evaluates to [[Boolean]] ''false''
 */
