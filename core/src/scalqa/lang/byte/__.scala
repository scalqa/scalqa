package scalqa; package lang; import language.implicitConversions

object Byte extends byte.custom.Containers[Byte]:
  inline def min     : Byte               = java.lang.Byte.MIN_VALUE
  inline def max     : Byte               = java.lang.Byte.MAX_VALUE
  inline def ordering: G.Ordering[Byte]   = byte.z.Math
  inline def math    : G.Math[Byte]       = byte.z.Math

  // Members ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  transparent inline def Custom = byte.Custom
  transparent inline def G      = byte.G
  type _methods   = byte._methods;

package byte:
  private[scalqa] type SELF = Byte;             private[scalqa] inline def SELF = lang.Byte
  private[scalqa] type RAW  = Any.Raw.Byte

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@object Byte -> ### Companion for scala.Byte

    This object also defines specialized custom containers for Byte type,
    so the following code can run without boxing:

    ```
        val s: Byte.~    = 1.Byte <> 5.Byte

        val o: Byte.Opt  = s.readRaw_?  // Holds Byte.Opt(1)

        val l: Byte.><   = s.><         // Holds (2,3,4,5)
    ```

@def min      -> Minimum \n\n  Returns type minimal value: -128
@def max      -> Maximum \n\n  Returns type maximum value: 127
@def ordering -> Ordering   \n\n  Returns type natural ordering
@def math     -> Math interface \n\n  Returns type math implementation

*/