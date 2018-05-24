package scalqa; package String

import java.lang.{ StringBuilder => JAVA }

class Builder protected (private val This: JAVA) extends AnyVal with Index[Char] with Able.Add[Any] with Able.Remove.At[Builder] {
  protected override type TARGET = Builder

  def real = This // For docs

  def clear = This.delete(0, size)

  def size: Int = This.length

  def apply(i: Int): Char = This.charAt(i)

  def =+@(position: Int, v: Char): Builder = { This.insert(position, v); this }

  protected def _add(v: Any) = v match { case c: Char => This.append(c); case a => This.append(a.toString) }
  protected def _removeRange(r: Int.Range) = This.delete(r.start, r.end)
  protected def _target: Builder = this

  override def toString = This.toString
}

object Builder {

  def get(): Builder = new Builder(new JAVA)

  def get(initialCapacity: Int, defaultValue: Opt[String] = \/): Builder = new Builder(new JAVA(initialCapacity)).I(b => defaultValue(b =+ _))

  def get(default: String): Builder = new Builder(new JAVA(default))

  import scala.language.implicitConversions
  implicit def zzString(b: Builder): String = b.toString
  implicit def zzText(b: Builder): String.Text = b.toString
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @class Builder ->
 *
 *     [[String.Builder]] is a buffer of [[Char]]s
 *
 *     [[Char]]s can be added and removed by different methods
 *
 *     Ultimately ''toString'' creates a [[String]] out of buffered [[Char]]s
 *
 * @def get() -> With default capacity
 *
 *     Creates a [[Builder]] with default initial size of 16
 *
 * @def get(initialCapacity -> Specified
 *
 *     Creates a [[Builder]] with specified ''initialCapacity'' and optional ''defaultValue''
 *
 * @def get(default -> With default
 *
 *     Creates a [[Builder]] with ''default'' value
 *
 * @def real -> Real implementation
 *
 *     [[Builder]] is a thin wrapper around Java StringBulder
 *
 *     All StringBulder methods can be used with ''real''
 *
 * @def =+@ -> Add Char at position
 *
 *     Adds a Char at given ''position''
 *
 * @def clear -> Remove all
 *
 *     Removes all content
 *
 * @def toString -> Creates String
 *
 *     Creates a [[String]] out of buffered [[Char]]s
 *
 */
