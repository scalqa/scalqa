package scalqa.j.vm; import language.implicitConversions

import scalqa.lang.*
import scalqa.Val.Opt

object Predef:

  object GlobalExtensionLibrary
      extends any.z._Methods   with array._methods with string._Methods  with scalqa.`val`.stream.z.util.GlobalMethods
         with boolean._methods with byte._methods  with char._methods    with short._methods
         with int._methods     with long._methods  with float._methods   with double._methods
         with scalqa.gen.math.z.Ordering._methods

  given given_Lib: GlobalExtensionLibrary.type = scalqa.J.illegalState("All library methods must be inlined") // do not inline this "given"

  inline given givenByteMath   : Byte  .G.Math[Byte  ] = Byte  .math
  inline given givenCharMath   : Char  .G.Math[Char  ] = Char  .math
  inline given givenShortMath  : Short .G.Math[Short ] = Short .math
  inline given givenFloatMath  : Float .G.Math[Float ] = Float .math
  inline given givenIntMath    : Int   .G.Math[Int   ] = Int   .math
  inline given givenLongMath   : Long  .G.Math[Long  ] = Long  .math
  inline given givenDoubleMath : Double.G.Math[Double] = Double.math

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/