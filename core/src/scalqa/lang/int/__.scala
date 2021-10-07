package scalqa; package lang; import language.implicitConversions

object Int extends int.g.companion.Containers[Int]:
  inline def min       : Int           = java.lang.Integer.MIN_VALUE
  inline def max       : Int           = java.lang.Integer.MAX_VALUE
  inline def ordering  : Ordering[Int] = int.z.Math

  // Members ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  type Opaque   = int.Opaque.TYPE.DEF;   transparent inline def Opaque = int.Opaque
  type _methods = int._methods;          transparent inline def G      = int.G

package object int:
  private[lang] type Primitive = Int;                private[lang] transparent inline def Primitive = Int
  private[lang] type Raw       = Any.Int
  private[lang] type Opaque    = Int.Opaque

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@object Int -> ### Companion Object for scala.Int

    This object also defines specialized custom containers for Int type,
    so the following code can run without boxing:

    ```

        val s: Int.~    = 1 <> 5

        val o: Int.Opt  = s.readRaw_?  // Holds Int.Opt(1)

        val l: Int.>< = s.><     // Holds (2,3,4,5)
    ```

@def min        -> Minimum     \n\n Returns type minimal value: -2 ^ 31
@def max        -> Maximum     \n\n Returns type maximum value: 2 ^ 31 - 1
@def ordering   -> Ordering    \n\n Returns type natural ordering
*/