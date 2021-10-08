package scalqa.j.vm; import language.implicitConversions

import scalqa.lang.*
import scalqa.Val.Opt
import scalqa.gen.math.{Average, Sum}

object Predef:

  object GlobalExtensionLibrary
      extends any.z._Methods   with array._methods with string._Methods  with More.zMethods
         with boolean._methods with byte._methods  with char._methods    with short._methods
         with int._methods     with long._methods  with float._methods   with double._methods
         with scalqa.gen.math.z.Ordering._methods

  given zzGlobalExtensionLibrary: GlobalExtensionLibrary.type = scalqa.J.illegalState("All library methods must be inlined") // do not inline this "given"

  inline given zzByteNumeric  : Numeric[Byte]   = byte.z.Math
  inline given zzByteSum      : Sum[Byte]       = byte.z.Math

  inline given zzCharOrdering : Ordering[Char]  = char.z.Math

  inline given zzShortNumeric : Numeric[Short]  = short.z.Math
  inline given zzShortSum     : Sum[Short]      = short.z.Math

  inline given zzIntNumeric   : Numeric[Int]    = int.z.Math
  inline given zzIntSum       : Sum[Int]        = int.z.Math

  inline given zzLongNumeric  : Numeric[Long]   = long.z.Math
  inline given zzLongSum      : Sum[Long]       = long.z.Math

  inline given zzFloatNumeric : Numeric[Float]  = float.z.Math
  inline given zzFloatSum     : Sum[Float]      = float.z.Math
  inline given zzFloatAverage : Average[Float]  = float.z.Math

  inline given zzDoubleNumeric: Numeric[Double] = double.z.Math
  inline given zzDoubleSum    : Sum[Double]     = double.z.Math
  inline given zzDoubleAverage: Average[Double] = double.z.Math

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/