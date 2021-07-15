package scalqa; package lang; import language.implicitConversions

object Int extends int.custom.Containers[Int]:
  inline def min     : Int               = java.lang.Integer.MIN_VALUE
  inline def max     : Int               = java.lang.Integer.MAX_VALUE
  inline def ordering: G.Ordering[Int] = int.z.Math
  inline def math    : G.Math[Int]       = int.z.Math

  // Members ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  transparent inline def Custom = int.Custom
  transparent inline def G      = int.G
  type _methods   = int._methods

package object int:
  private[scalqa] type SELF = Int;             private[scalqa] inline def SELF = lang.Int
  private[scalqa] type RAW  = Any.Raw.Int

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

@def min      -> Minimum \n\n  Returns type minimal value: -2 ^ 31
@def max      -> Maximum \n\n  Returns type maximum value: 2 ^ 31 - 1
@def ordering -> Ordering   \n\n  Returns type natural ordering
@def math     -> Math interface \n\n  Returns type math implementation

*/