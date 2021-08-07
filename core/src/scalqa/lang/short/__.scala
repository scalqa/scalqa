package scalqa; package lang; import language.implicitConversions

object Short extends short.g.customized.Containers[Short]:
  inline def min     : Short               = java.lang.Short.MIN_VALUE
  inline def max     : Short               = java.lang.Short.MAX_VALUE
  inline def ordering: G.Ordering[Short]   = short.z.Math
  inline def math    : G.Math[Short]       = short.z.Math

  // Members ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  type _methods = short._methods;          transparent inline def G      = short.G
  type Opaque   = short.Opaque;            transparent inline def Opaque = short.Opaque
  type Raw      = Short | short.Opaque;    transparent inline def Raw    = short.Raw

package object short:
  type Raw    = Short.Raw
  opaque type Opaque >: Short <: AnyVal = Short

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@object Short -> ### Companion Object for scala.Short

    This object also defines specialized custom containers for Short type,
    so the following code can run without boxing:

    ```

        val s: Short.~   = 1.Short <> 5.Short

        val o: Short.Opt = s.readRaw_?  // Holds Short.Opt(1)

        val l: Short.><  = s.><     // Holds (2,3,4,5)
    ```

@def min      -> Minimum \n\n  Returns type minimal value: -2 ^ 15
@def max      -> Maximum \n\n  Returns type maximum value: 2 ^ 15 - 1
@def ordering -> Ordering   \n\n  Returns type natural ordering
@def math     -> Math interface \n\n  Returns type math implementation

*/