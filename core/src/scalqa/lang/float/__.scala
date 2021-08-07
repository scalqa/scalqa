package scalqa; package lang; import language.implicitConversions

object Float extends float.g.customized.Containers[Float]:
  inline def min     : Float               = java.lang.Float.MIN_VALUE
  inline def max     : Float               = java.lang.Float.MAX_VALUE
  inline def ordering: G.Ordering[Float]   = float.z.Math
  inline def math    : G.Math[Float]       = float.z.Math

  // Members ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  type _methods = float._methods;          transparent inline def G      = float.G
  type Opaque   = float.Opaque;            transparent inline def Opaque = float.Opaque
  type Raw      = Float | float.Opaque;    transparent inline def Raw    = float.Raw

package object float:
  type Raw    = Float.Raw
  opaque type Opaque >: Float <: AnyVal = Float

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@object Float -> ### Companion Object for scala.Float

    This object also defines specialized custom containers for Float type,
    so the following code can run without boxing:

    ```

        val s: Float.~    = (1F <> 5F).step_~(1)

        val o: Float.Opt  = s.readRaw_?  // Holds Float.Opt(1.0)

        val l: Float.><   = s.><         // Holds (2.0, 3.0, 4.0)
    ```

@def min      -> Minimum \n\n  Returns type minimal value defined in java.lang.Float.MIN_VALUE
@def max      -> Maximum \n\n  Returns type maximum value defined in java.lang.Float.MAX_VALUE
@def ordering -> Ordering   \n\n  Returns type natural ordering
@def math     -> Math interface \n\n  Returns type math implementation

*/