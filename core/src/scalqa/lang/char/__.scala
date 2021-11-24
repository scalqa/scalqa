package scalqa; package lang; import language.implicitConversions

object Char extends char.g.companion.Containers[Char]:
  inline def min       : Char           = java.lang.Character.MIN_VALUE
  inline def max       : Char           = java.lang.Character.MAX_VALUE
  inline def ordering  : Ordering[Char] = char.z.Math

  // Members ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  type Opaque   = char.Opaque.TYPE.DEF;   transparent inline def Opaque = char.Opaque
  type _methods = char._methods;          transparent inline def G      = char.G

package object char:
  private[lang] type Primitive = Char;            private[lang] transparent inline def Primitive = Char
  private[lang] type Raw       = Any.Char
  private[lang] type Opaque    = Char.Opaque

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@object Char -> ### Companion Object for scala.Char

    This object also defines specialized custom containers for Char type,
    so the following code can run without boxing:

    ```

        val s: Char.Stream = 'a' <> 'd'

        val o: Char.Opt    = s.readRawOpt  // Holds Char.Opt('a')

        val l: Char.Pack   = s.pack       // Holds ('b','c','d')
    ```

@def min        -> Minimum     \n\n Returns type minimal value: '\u0000'
@def max        -> Maximum     \n\n Returns type maximum value: '\uFFFF'
@def ordering   -> Ordering    \n\n Returns type natural ordering
*/