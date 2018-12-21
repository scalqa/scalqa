package scalqa; package Util

class Trilean private (private val byte: Byte) extends AnyVal with Any.Able.Void {

  override def isVoid = byte == 0

  def toBoolean: Boolean = byte == 1

  def ! : Trilean = if (isVoid) this else Trilean.make(!toBoolean)

  override def toString = if (isVoid) "void" else toBoolean.toString

}

object Trilean {

  val Void = new Trilean(0)
  val True = new Trilean(1)
  val False = new Trilean(-1)

  @inline def make(v: Boolean): Trilean = if (v) True else False

  implicit def zzMake(v: Boolean) = make(v)
  implicit def zzMake(v: \/) = Void
  implicit def zzBoolean(v: Trilean): Boolean = v.toBoolean
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @class Trilean -> `Three-valued logic`
 *
 *   "Trilean" is a Boolean substitute if 3 values are required: True, False, and Void
 *
 * @object Trilean ->
 *
 *   The easiest way to build [[Trilean]] is with Boolean implicit convertions
 *
 *   {{{
 *       val t : Trilean = true
 *
 *       val f : Trilean = false
 *
 *       val v : Trilean = \/
 *   }}}
 *
 * @def toBoolean -> To Boolean
 *
 *     True converts to 'true'
 *
 *     False and Void convert to 'false'
 *
 * @def toString -> Description
 *
 *     Returns "true", "false", or "void"
 *
 * @def ! -> Reverse
 *
 *     Returns:
 *
 *     - True if False
 *     - False if True
 *     - Void if Void
 *
 * @val Void -> Void false
 *
 *    Void evaluates to Boolean `false` and tests isVoid positive
 *
 * @val True -> true
 *
 *    Evaluates to Boolean `true`
 *
 * @val False -> false
 *
 *    Evaluates to Boolean `false`
 */
