package scalqa; package lang; import language.implicitConversions

object Char extends char.custom.Containers[Char]:
  inline def min     : Char               = java.lang.Character.MIN_VALUE
  inline def max     : Char               = java.lang.Character.MAX_VALUE
  inline def ordering: G.Ordering[Char] = char.z.Math
  inline def math    : G.Math[Char]       = char.z.Math

  // Members ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  transparent inline def Custom = char.Custom
  transparent inline def G      = char.G
  type _methods   = char._methods

package char:
  private[scalqa] type SELF = Char;             private[scalqa] inline def SELF = lang.Char
  private[scalqa] type RAW  = Any.Raw.Char

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@object Char -> ### Companion for scala.Char

    This object also defines specialized custom containers for Char type,
    so the following code can run without boxing:

    ```

        val s: Char.~    = 'a' <> 'd'

        val o: Char.Opt  = s.readRaw_?  // Holds Char.Opt('a')

        val l: Char.><   = s.><         // Holds ('b','c','d')
    ```

@def min      -> Minimum \n\n  Returns type minimal value: '\u0000'
@def max      -> Maximum \n\n  Returns type maximum value: '\uFFFF'
@def ordering -> Ordering   \n\n  Returns type natural ordering
@def math     -> Math interface \n\n  Returns type math implementation

*/