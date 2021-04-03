package scalqa.j.vm; import language.implicitConversions

import scalqa.`def`
import `def`.*

object Predef:

  object Extension extends any.z.Extension    with array.z._extension with string._extension  with scalqa.`val`.stream.custom._extension
                      with boolean._extension with byte._extension    with char._extension    with short._extension
                      with int._extension     with long._extension    with float._extension   with double._extension
                      with scalqa.gen.math.ordering.z._extension

  given xx: Extension.type = Extension

  inline given xxByteMath   : Byte  .G.Math[Byte  ] = Byte  .math
  inline given xxCharMath   : Char  .G.Math[Char  ] = Char  .math
  inline given xxShortMath  : Short .G.Math[Short ] = Short .math
  inline given xxFloatMath  : Float .G.Math[Float ] = Float .math
  inline given xxIntMath    : Int   .G.Math[Int   ] = Int   .math
  inline given xxLongMath   : Long  .G.Math[Long  ] = Long  .math
  inline given xxDoubleMath : Double.G.Math[Double] = Double.math

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/