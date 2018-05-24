package scalqa; package Numeric

trait _Trait extends Any with _convert with _operator._Trait with _use with Able.Void {

  protected def This: THIS = this.cast

  protected def value: VALUE

  protected def companion: Companion[THIS, VALUE]

  protected def math: Math[VALUE] = companion._math
  protected def map = companion.map

}

object _Trait {

  @inline private[Numeric] def companion(v: Numeric): Companion[v.THIS, v.VALUE] = v.companion

  import scala.language.implicitConversions

  implicit def zzLibrary(v: Numeric) = new _library(v)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @trait _Trait ->
 *
 *   [[Numeric]] is the root of all number like objects, which support arithmetic operations, comparisons, conversions, and more
 *
 *   Primitives, like [[Int]], [[Double]], etc., do not implement [[Numeric]], but they all have standard implementation, like [[Int.The]], [[Double.The]], etc
 *
 *
 *
 *
 *
 *
 * @def value -> Base value
 *
 *     Primitive base value of ''this''
 *
 *
 */
