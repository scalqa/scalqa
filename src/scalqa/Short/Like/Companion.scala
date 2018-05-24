package scalqa; package Short; package Like

abstract class Companion[SELF <: Like] protected extends Any.Value.Short.Companion[SELF] with Numeric.Companion[SELF, Short] {

  def get(v: Short): SELF

  protected def math = Numeric.Math.Short

  import scala.language.implicitConversions

  implicit def zzGet(v: Short): SELF = get(v)

  implicit def zzMathBase(v: SELF): Short = v.value

  implicit def zzGetByThe(v: Short.The): SELF = get(v.real)

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
 *   Companion object type required to be implemented for each new [[Short.Like]] type
 *
 */
