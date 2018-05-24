package scalqa; package Byte; package Like

abstract class Companion[SELF <: Like] protected extends Any.Value.Byte.Companion[SELF] with Numeric.Companion[SELF, Byte] {

  def get(v: Byte): SELF

  protected def math = Numeric.Math.Byte

  import scala.language.implicitConversions

  implicit def zzGet(v: Byte): SELF = get(v)

  implicit def zzMathBase(v: SELF): Byte = v.value

  implicit def zzGetByThe(v: Byte.The): SELF = get(v.real)

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
 *   Companion object type required to be implemented for each new [[Byte.Like]] type
 *
 */
