package scalqa; package Float; package Like

abstract class Companion[SELF <: Like] protected extends Any.Value.Float.Companion[SELF] with Numeric.Companion[SELF, Float] {

  def get(v: Float): SELF

  protected def math = Numeric.Math.Float

  import scala.language.implicitConversions

  implicit def zzGet(v: Float): SELF = get(v)

  implicit def zzMathBase(v: SELF): Float = v.value

  implicit def zzGetByThe(v: Float.The): SELF = get(v.real)

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
 *   Companion object type required to be implemented for each new [[Float.Like]] type
 *
 */
