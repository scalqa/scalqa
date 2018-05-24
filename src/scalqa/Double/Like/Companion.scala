package scalqa; package Double; package Like

import scala.language.implicitConversions

abstract class Companion[SELF <: Like] protected extends Any.Value.Double.Companion[SELF] with Numeric.Companion[SELF, Double] {

  def get(v: Double): SELF

  protected def math = Numeric.Math.Double

  implicit def zzGet(v: Double): SELF = get(v)

  implicit def zzMathBase(v: SELF): Double = v.value

  implicit def zzGetByThe(v: Double.The): SELF = get(v.real)

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
 *   Companion object type required to be implemented for each new [[Double.Like]] type
 *
 */
