package scalqa; package lang; import language.implicitConversions

object Byte extends byte.g.companion.Containers[Byte]:
  inline def min       : Byte           = java.lang.Byte.MIN_VALUE
  inline def max       : Byte           = java.lang.Byte.MAX_VALUE
  inline def ordering  : Ordering[Byte] = byte.z.Math

// Members ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  type Opaque   = byte.Opaque.TYPE.DEF;   transparent inline def Opaque = byte.Opaque
  type _methods = byte._methods;          transparent inline def G      = byte.G

package object byte:
  private[lang] type Primitive = Byte;             private[lang] transparent inline def Primitive = Byte
  private[lang] type Raw       = Any.Byte
  private[lang] type Opaque    = Byte.Opaque

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@object Byte -> ### Companion Object for scala.Byte

    This object also defines specialized custom containers for Byte type,
    so the following code can run without boxing:

    ```
        val s: Byte.Stream = 1.Byte <> 5.Byte

        val o: Byte.Opt    = s.readRawOpt  // Holds Byte.Opt(1)

        val l: Byte.Pack   = s.pack       // Holds (2,3,4,5)
    ```

@def min        -> Minimum     \n\n Returns type minimal value: -128
@def max        -> Maximum     \n\n Returns type maximum value: 127
@def ordering   -> Ordering    \n\n Returns type natural ordering
*/