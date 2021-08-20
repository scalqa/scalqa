package scalqa; package lang; package string; package opaque; package base; package _methods; import language.implicitConversions

transparent trait _modify:

  extension[THIS_OPAQUE <: Opaque](inline x: THIS_OPAQUE)
    @tn("join")    inline def + (inline v: THIS_OPAQUE|String)                           : THIS_OPAQUE  = (x.cast[String] + v.cast[String]).cast[THIS_OPAQUE]
    @tn("joinOpt") inline def +?[A](inline v: Opt[THIS_OPAQUE|String])
                                                        (using inline d: Given.DocDef[A]): THIS_OPAQUE  = x.^.reviseIf(_ => v.nonEmpty, _ + v.toString)
    /**/           inline def padStartTo(inline size:Int, inline pad:String=" ")         : THIS_OPAQUE  = x.cast[String].padStartTo  (size,pad)                          .cast[THIS_OPAQUE]
    /**/           inline def padEndTo  (inline size:Int, inline pad:String=" ")         : THIS_OPAQUE  = x.cast[String].padEndTo    (size,pad)                          .cast[THIS_OPAQUE]
    /**/           inline def label                                                      : THIS_OPAQUE  = x.cast[String].label                                           .cast[THIS_OPAQUE]
    /**/           inline def replace(inline r: Int.<>, inline v: THIS_OPAQUE|String)    : THIS_OPAQUE  = x.cast[String].replace     (r,v.cast[String])                  .cast[THIS_OPAQUE]
    /**/           inline def replace(inline v:THIS_OPAQUE|String,
                                      inline target:THIS_OPAQUE|String)                  : THIS_OPAQUE  = x.cast[String].replace     (v.cast[String],target.cast[String]).cast[THIS_OPAQUE]
    /**/           inline def replaceFirst(inline v: THIS_OPAQUE|String,
                                           inline v2:THIS_OPAQUE|String,inline cnt:Int=1): THIS_OPAQUE  = x.cast[String].replaceFirst(v.cast[String],v2.cast[String],cnt).cast[THIS_OPAQUE]
    /**/           inline def replaceLast( inline v: THIS_OPAQUE|String,
                                           inline v2:THIS_OPAQUE|String,inline cnt:Int=1): THIS_OPAQUE  = x.cast[String].replaceLast (v.cast[String],v2.cast[String],cnt).cast[THIS_OPAQUE]
    /**/           inline def insertAt(inline i: Int, inline v: THIS_OPAQUE|String)      : THIS_OPAQUE  = x.cast[String].insertAt    (i,v.cast[String])                  .cast[THIS_OPAQUE]
    /**/           inline def remove(inline v: THIS_OPAQUE|String)                       : THIS_OPAQUE  = x.cast[String].remove      (v.cast[String])                    .cast[THIS_OPAQUE]
    /**/           inline def lower                                                      : THIS_OPAQUE  = x.cast[String].lower                                           .cast[THIS_OPAQUE]
    /**/           inline def upper                                                      : THIS_OPAQUE  = x.cast[String].upper                                           .cast[THIS_OPAQUE]
    /**/           inline def trimStart                                                  : THIS_OPAQUE  = x.cast[String].trimStart                                       .cast[THIS_OPAQUE]
    /**/           inline def trimStart(inline f: Char => Boolean)                       : THIS_OPAQUE  = x.cast[String].trimStart   (f)                                 .cast[THIS_OPAQUE]
    /**/           inline def trimEnd                                                    : THIS_OPAQUE  = x.cast[String].trimEnd                                         .cast[THIS_OPAQUE]
    /**/           inline def trimEnd  (inline f: Char => Boolean)                       : THIS_OPAQUE  = x.cast[String].trimEnd(f)                                      .cast[THIS_OPAQUE]
    /**/           inline def trim                                                       : THIS_OPAQUE  = x.cast[String].trim                                            .cast[THIS_OPAQUE]
    /**/           inline def trimBoth (inline f: Char => Boolean)                       : THIS_OPAQUE  = x.cast[String].trimBoth(f)                                     .cast[THIS_OPAQUE]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@def + -> Join tag

       Joins value tag to base opaque string.

@def +? -> Optional join

       Joins option value to base opaque string.

       Returns base opaque "as is" for empty option.

@def padStartTo -> Pad start

       Pads start of string to `targetLength`

       @param pad string to pad with.
       ```
       "ABC".padStartTo(10,"_").TP // Prints: _______ABC
       ```

@def padEndTo -> Pad end

       Pads end of string to `targetLength`

       @param pad string to pad with.
       ```
       "ABC".padEndTo(10,"_").TP // Prints: ABC_______
       ```

@def label -> Capitalize

     Capitalizes first character of every word (separated by white spaces)
     ```
     "all string ops".label.TP // Prints: All String Ops
     ```

@def replace -> Replace range with x

     Creates new String with all occurrences of `x` replaced with `target`
     ```
     "0123456789".replace(3 <> 7 ,"_").TP // Prints: 012_89
     ```

@def replace -> Replace all

     Creates new String with all occurrences of `x` replaced with `target`
     ```
     "123123123123".replace("2","_").TP // Prints: 1_31_31_31_3
     ```

@def insertAt -> Insert at position

     Creates new String with `x` inserted at the specified position
     ```
     "0123456789".insertAt(5,"abc").TP // Prints: 01234abc56789
     ```

@def remove -> Remove all

     Creates new String with all occurrences of `x` removed
     ```
     "123123123123".remove("2").TP // Prints: 13131313
     ```

@def lower -> toLowerCase

     Creates new String with all upper case Chars changed to lower case
     ```
     "ABc".lower.TP // Prints: abc
     ```

@def upper -> toUpperCase

     Creates new String with all lower case Chars changed to upper case
     ```
     "aBc".upper.TP // Prints: ABC
     ```

@def trimStart -> Trim start

     Trims start of String from space Chars


@def trimStart ->  Trim start

      Trims start of String from Chars defined by let function

     ```
         "yyxxxxABC".trimStart(_ in 'x' <> 'z') TP           // Prints: ABC

         "yyxxxxABC".trimStart(c => c == 'x' || c == 'y').TP // Prints: ABC
     ```

@def trimEnd -> Trim end

     Trims end of String from space Chars


@def trimEnd ->  Trim end

      Trims end of String from Chars defined by let function

     ```
         "ABCxxyyxx".trimEnd(_ in 'x' <> 'z') TP           // Prints: ABC

         "ABCxxyyxx".trimEnd(c => c == 'x' || c == 'y').TP // Prints: ABC
     ```

@def trim -> Trim both ends

     Trims both ends of String from space Chars

@def trimBoth -> Trim both ends

      Trims both ends of String from Chars defined by let function

     ```
         "yyxxxxABCxxyyxx".trimBoth(_ in 'x' <> 'z') TP           // Prints: ABC

         "yyxxxxABCxxyyxx".trimBoth(c => c == 'x' || c == 'y').TP // Prints: ABC
     ```
*/
