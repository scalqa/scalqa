package scalqa; package lang; package string; import language.implicitConversions

import custom.`type`.{ _Methods as X }

transparent trait _methods extends X._evaluate[String] with X._modify[String] with X._copy[String] with X._transform[String]:
  extension(inline x: String)
    inline def Problem        : Result.Problem = Result.Problem(x)

object _methods:
  trait _evaluate  extends X._evaluate[String]
  trait _modify    extends X._modify[String]
  trait _copy      extends X._copy[String]
  trait _transform extends X._transform[String]

package object _Methods:
  private[_Methods] implicit inline def implicitToString[A<: String | Opaque.String](inline v: A): String = v.cast[String]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@trait _methods -> ### String Extension Methods \n\n Extension methods universaly avaialble for type java.lang.String

*/

