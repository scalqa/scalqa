package scalqa.j.vm; import language.implicitConversions

import scalqa.lang.*
import scalqa.Val.Opt
import scalqa.gen.math.{Average, Sum}

object Predef:

  object GlobalExtensionLibrary
      extends any.z._Methods   with array._methods with string._Methods  with More.z_Methods
         with boolean._methods with byte._methods  with char._methods    with short._methods
         with int._methods     with long._methods  with float._methods   with double._methods
         with scalqa.gen.math.z.Ordering._methods

  given z_GlobalExtensionLibrary: GlobalExtensionLibrary.type = scalqa.J.illegalState("All library methods must be inlined") // do not inline this "given"

  inline given z_ByteNumeric  : Numeric[Byte]   = byte.z.Math
  inline given z_ByteSum      : Sum[Byte]       = byte.z.Math

  inline given z_CharOrdering : Ordering[Char]  = char.z.Math

  inline given z_ShortNumeric : Numeric[Short]  = short.z.Math
  inline given z_ShortSum     : Sum[Short]      = short.z.Math

  inline given z_IntNumeric   : Numeric[Int]    = int.z.Math
  inline given z_IntSum       : Sum[Int]        = int.z.Math

  inline given z_LongNumeric  : Numeric[Long]   = long.z.Math
  inline given z_LongSum      : Sum[Long]       = long.z.Math

  inline given z_FloatNumeric : Numeric[Float]  = float.z.Math
  inline given z_FloatSum     : Sum[Float]      = float.z.Math
  inline given z_FloatAverage : Average[Float]  = float.z.Math

  inline given z_DoubleNumeric: Numeric[Double] = double.z.Math
  inline given z_DoubleSum    : Sum[Double]     = double.z.Math
  inline given z_DoubleAverage: Average[Double] = double.z.Math

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/