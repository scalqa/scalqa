package scalqa; package lang; import language.implicitConversions

object Long extends long.custom.Containers[Long]:
  inline def min     : Long               = java.lang.Long.MIN_VALUE
  inline def max     : Long               = java.lang.Long.MAX_VALUE
  inline def ordering: G.Ordering[Long] = long.z.Math
  inline def math    : G.Math[Long]       = long.z.Math

  // Members ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  transparent inline def Custom = long.Custom
  transparent inline def G      = long.G
  type _methods   = long._methods

package object long:
  private[scalqa] type SELF = Long;          private[scalqa] inline def SELF = lang.Long
  private[scalqa] type RAW  = Any.Raw.Long

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@object Long -> ### Companion Object for scala.Long

    This object also defines specialized custom containers for Long type,
    so the following code can run without boxing:

    ```

        val s: Long.~    = 1L <> 5L

        val o: Long.Opt  = s.readRaw_?  // Holds Long.Opt(1)

        val l: Long.><   = s.><        // Holds (2,3,4,5)
    ```

@def min      -> Minimum \n\n  Returns type minimal value: -2 ^ 63
@def max      -> Maximum \n\n  Returns type maximum value: 2 ^ 63 - 1
@def ordering -> Ordering   \n\n  Returns type natural ordering
@def math     -> Math interface \n\n  Returns type math implementation

*/