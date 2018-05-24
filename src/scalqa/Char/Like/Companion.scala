package scalqa; package Char; package Like

abstract class Companion[SELF <: Like] protected extends Any.Value.Char.Companion[SELF] with Numeric.Companion[SELF, Char] {

  def get(v: Char): SELF

  protected def math = Numeric.Math.Char

  import scala.language.implicitConversions

  implicit def zzGet(v: Char): SELF = get(v)

  implicit def zzMathBase(v: SELF): Char = v.value

  implicit def zzGetByThe(v: Char.The): SELF = get(v.real)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @class Companion ->
 *
 *   Companion object type required to be implemented for each new [[Char.Like]] type
 *
 */
