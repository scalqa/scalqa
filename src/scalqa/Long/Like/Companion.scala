package scalqa; package Long; package Like

abstract class Companion[SELF <: Like] protected extends Any.Value.Long.Companion[SELF] with Numeric.Companion[SELF, Long] {

  def get(v: Long): SELF

  protected def math = Numeric.Math.Long

  import scala.language.implicitConversions

  implicit def zzGet(v: Long): SELF = if (v == voidVal) void else get(v)

  implicit def zzMathBase(v: SELF): Long = v.value

  implicit def zzGetByThe(v: Long.The): SELF = get(v.real)

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
 *   Companion object type required to be implemented for each new [[Long.Like]] type
 *
 */
