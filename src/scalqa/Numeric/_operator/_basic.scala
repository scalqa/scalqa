package scalqa; package Numeric; package _operator

trait _basic extends Any with __ {

  @inline def unary_- : THIS = map(math.negate(value))

  @inline def +(v: VALUE): VALUE = math.add(value, v)

  @inline def -(v: VALUE): VALUE = math.subtract(value, v)

  @inline def /(v: VALUE): VALUE = math.divide(value, v)

  @inline def *(v: VALUE): VALUE = math.multiply(value, v)

  @inline def %(v: VALUE): VALUE = math.remainder(value, v)

}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @def unary -> Negate
 *
 *     Negate  this [[Numeric]] value.
 *
 *     Negating negative value will produce positive
 *
 *     Note: If numeric does not support negatives, the operation should fail.
 *
 * @def +(v -> Plus
 *
 *     Converts this [[Numeric]] into base primitive and performs '+' operation.
 *
 * @def -(v -> Minus
 *
 *     Converts this [[Numeric]] into base primitive and performs '-' operation.
 *
 * @def / -> Divide
 *
 *     Converts this [[Numeric]] into base primitive and performs '/' operation.
 *
 * @def * -> Multiply
 *
 *     Converts this [[Numeric]] into base primitive and performs '*' operation.
 *
 * @def % -> Remainder
 *
 *     Converts this [[Numeric]] into base primitive and performs '%*' operation.
 */
