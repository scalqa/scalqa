package scalqa; package `val`; package stream; package _use; package _transform; import language.implicitConversions

transparent trait _toString:

  extension[A] (inline x: ~[A])
    inline def toText                             (using inline t: Any.Def.Tag[A]): String = z._use._print.toText(x,false)
    inline def makeString(inline separator:String)(using inline t: Any.Def.Tag[A]): String = z._use.transform.makeString(x,separator)


/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**

@def makeString -> Convert ot String

     The result is a concatenation of all elements with given separator

     ```
         ('a' <> 'j').~.makeString("")            // Returns abcdefghij

         ('a' <> 'j').~.makeString("|")           // Returns a|b|c|d|e|f|g|h|i|j

     ```
@def toText -> Elements as multi-line String

      Returns all elements as String formatted table

      If elements implement [[Able.Doc]], each 'doc' property value is placed in a different column

      If elements implement `scala.Product` (like all Tuples), each Product element is placed in a different column

      ```
         ('a' <> 'e').~.map(v => (v + "1", v + "2", v + "3", v + "4", v + "5")).toText.TP

         // Output
         -- -- -- -- --
         ?  ?  ?  ?  ?
         -- -- -- -- --
         a1 a2 a3 a4 a5
         b1 b2 b3 b4 b5
         c1 c2 c3 c4 c5
         d1 d2 d3 d4 d5
         e1 e2 e3 e4 e5
         -- -- -- -- --
      ```
*/
