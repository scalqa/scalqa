package scalqa; package Int; package Like

abstract class Companion[SELF <: Like] protected extends Any.Value.Int.Companion[SELF] with Numeric.Companion[SELF, Int] {

  def get(v: Int): SELF

  protected def math = Numeric.Math.Int

  import scala.language.implicitConversions

  implicit def zzGet(v: Int): SELF = get(v)

  implicit def zzGetByThe(v: Int.The): SELF = get(v.real)

  implicit def zzMathBase(v: SELF): Int = v.value

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
 *   Companion object type required to be implemented for each new [[Int.Like]] type
 *
 */
