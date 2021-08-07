package scalqa; package lang; import language.implicitConversions

object Double extends double.g.customized.Containers[Double]:
  inline def min     : Double               = java.lang.Double.MIN_VALUE
  inline def max     : Double               = java.lang.Double.MAX_VALUE
  inline def ordering: G.Ordering[Double]   = double.z.Math
  inline def math    : G.Math[Double]       = double.z.Math

  // Members ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  type _methods = double._methods;          transparent inline def G      = double.G
  type Opaque   = double.Opaque;            transparent inline def Opaque = double.Opaque
  type Raw      = Double | double.Opaque;   transparent inline def Raw    = double.Raw

package object double:
  type Raw = Double.Raw
  opaque type Opaque >: Double <: AnyVal = Double

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@object Double -> ### Companion Object for scala.Double

    This object also defines specialized custom containers for Double type,
    so the following code can run without boxing:

    ```

        val s: Double.~    = (1.0 <> 5.0).step_~(1)

        val o: Double.Opt  = s.readRaw_?  // Holds Double.Opt(1.0)

        val l: Double.><   = s.><        // Holds (2.0, 3.0, 4.0)
    ```
@def min      -> Minimum \n\n  Returns type minimal value defined in java.lang.Double.MIN_VALUE
@def max      -> Maximum \n\n  Returns type maximum value defined in java.lang.Double.MAX_VALUE
@def ordering -> Ordering   \n\n  Returns type natural ordering
@def math     -> Math interface \n\n  Returns type math implementation

*/