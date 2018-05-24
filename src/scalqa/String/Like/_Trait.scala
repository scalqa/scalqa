package scalqa; package String; package Like

trait _Trait extends Any with Any.Value.Ref[String] with Sorting.Itself with Able.Plus[Any] with Able.DataEqual[String] {
  protected override type THIS <: Like
  protected type TARGET = THIS

  override def value: String = super.value: @inline

  def ===(v: String.Like): Boolean = value == v.value

  def =!=(v: String.Like): Boolean = value != v.value

  override def toString = if (isVoid) "" else value.toString

  protected def companion: Companion[THIS]

  protected def sortingPositionTo(that: THIS) = Sorting.Position.getByInt(this.value.compareTo(that.value))

  protected def _dataEqual(v: String): Boolean = v == value

  @inline protected def _add(s1: String, s2: String): String = s1 + s2

  protected def _plus(v: Any): THIS = v.Opt.map(v => companion.get(_add(value, v.toString))) or _target
  protected def _plusAll(a: ~[Any], size: Int): THIS = companion.get(a.dropVoid.map(_.toString).foldAs[String](value, _add))
  protected def _target: THIS = this.cast

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @def toString -> String as is
 *
 *     Returns String value
 *
 *     Note. Void value returns "" instead of "void" for most other types
 *
 * @def ===(v: String.Like -> Value equal
 *
 *   Checks if the base value is equal
 *
 *   {{{
 *     // Generic examples
 *
 *     "abc".Id === "abc".Text lp   // Prints: true
 *
 *     "abc".Id ==  "abc".Text lp   // Prints: false
 *   }}}
 *
 *
 * @def =!=(v: String.Like -> Value not equal
 *
 *   Checks if the base value is not equal
 *
 *   {{{
 *     // Generic examples
 *
 *     "abc".Id =!= "abc".Text lp   // Prints: false
 *
 *     "abc".Id  != "abc".Text lp   // Prints: true
 *   }}}
 */
