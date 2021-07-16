package scalqa; package lang; package string; package custom; package `type`; package `_Methods`; import language.implicitConversions

transparent trait _modify[A<: String | Opaque.String]:

  extension(x: A)
    /**/                  def join( v: A|String)                                                 : A   = (x.cast[String] + v).cast[A] //Method join can be overridden for Opaque.String types

  extension(inline x: A)
    /**/           inline def joinAll(inline v: ~[A|String])                                     : A   = v.foldAs(x)(_ + _)
    @tn("_join")   inline def + (inline v: A|String)                                             : A   = x.join(v)
    @tn("_joinAll")inline def ++(inline v: ~[A|String])                                          : A   = joinAll(v)
    /**/           inline def padStartTo(inline sz: Int, inline pad: String = " ")               : A   = Z.padStartTo(x.cast[String],sz,pad).cast[A]
    /**/           inline def padEndTo  (inline sz: Int, inline pad: String = " ")               : A   = Z.padEndTo  (x.cast[String],sz,pad).cast[A]
    /**/           inline def label                                                              : A   = Z.label(x.cast[String]).cast[A]
    /**/           inline def replace(inline r: Int.<>, inline v: A|String)                      : A   = Z.replace(x.cast[String],r,v.cast[String]).cast[A]
    /**/           inline def replace(inline v: A|String, inline target: A|String)               : A   = x.real.replace(v, target).cast[A]
    /**/           inline def replaceFirst(inline v:A|String,inline v2:A|String,inline cnt:Int=1): A   = z.replace.first(x.real,v,v2,cnt).cast[A]
    /**/           inline def replaceLast( inline v:A|String,inline v2:A|String,inline cnt:Int=1): A   = z.replace.last (x.real,v,v2,cnt).cast[A]
    /**/           inline def insertAt(inline i: Int, inline v: A|String)                        : A   = Z.insertAt(x.cast[String],i,v.cast[String]).cast[A]
    /**/           inline def remove(inline v: A|String)                                         : A   = x.real.replace(v, \/).cast[A]
    /**/           inline def lower                                                              : A   = x.toLowerCase.cast[A]
    /**/           inline def upper                                                              : A   = x.toUpperCase.cast[A]
    /**/           inline def trimStart                                                          : A   = Z.trimStart(x.cast[String],_.isSpaceChar).cast[A]
    /**/           inline def trimStart(inline f: Char => Boolean)                               : A   = Z.trimStart(x.cast[String],f).cast[A]
    /**/           inline def trimEnd                                                            : A   = Z.trimEnd(x.cast[String],_.isSpaceChar).cast[A]
    /**/           inline def trimEnd  (inline f: Char => Boolean)                               : A   = Z.trimEnd(x.cast[String],f).cast[A]
    /**/           inline def trim                                                               : A   = x.real.trim.cast[A]
    /**/           inline def trimBoth (inline f: Char => Boolean)                               : A   = Z.trimBoth(x.cast[String],f).cast[A]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**

@def padStartTo -> Pad start

       Pads start of string to `targetLength`

       @param pad string to pad with.
       ``` "ABC".padStartTo(10,"_") TP // Prints: _______ABC ```


@def padEndTo -> Pad end

       Pads end of string to `targetLength`

       @param pad string to pad with.
       ``` "ABC".padEndTo(10,"_") TP // Prints: ABC_______ ```


@def label -> Capitalize

     Capitalizes first character of every word (separated by white spaces)
     ``` "all string ops".label TP // Prints: All String Ops ```


@def replace -> Replace range with x

     Creates new String with all occurrences of `x` replaced with `target`
     ``` "0123456789".replace(3 <> 7 ,"_") TP // Prints: 012_89 ```


@def replace -> Replace all

     Creates new String with all occurrences of `x` replaced with `target`
     ``` "123123123123".replace("2","_") TP // Prints: 1_31_31_31_3 ```


@def insertAt -> Insert at position

     Creates new String with `x` inserted at the specified position
     ``` "0123456789".insertAt(5,"abc") TP // Prints: 01234abc56789 ```


@def remove -> Remove all

     Creates new String with all occurrences of `x` removed
     ``` "123123123123".remove("2") TP // Prints: 13131313 ```


@def lower -> toLowerCase

     Creates new String with all upper case Chars changed to lower case
     ``` "ABc".lower TP // Prints: abc ```


@def upper -> toUpperCase

     Creates new String with all lower case Chars changed to upper case
     ``` "aBc".upper TP // Prints: ABC ```


@def trimStart -> Trim start

     Trims start of String from space Chars


@def trimStart ->  Trim start

      Trims start of String from Chars defined by let function

     ```
         "yyxxxxABC".trimStart(_ in 'x' <> 'z') TP           // Prints: ABC

         "yyxxxxABC".trimStart(c => c == 'x' || c == 'y') TP // Prints: ABC
     ```

@def trimEnd -> Trim end

     Trims end of String from space Chars


@def trimEnd ->  Trim both ends

      Trims end of String from Chars defined by let function

     ```
         "ABCxxyyxx".trimEnd(_ in 'x' <> 'z') TP           // Prints: ABC

         "ABCxxyyxx".trimEnd(c => c == 'x' || c == 'y') TP // Prints: ABC
     ```

@def trim -> Trim both ends

     Trims both ends of String from space Chars

@def trimBoth -> Trim both ends

      Trims both ends of String from Chars defined by let function

     ```
         "yyxxxxABCxxyyxx".trimBoth(_ in 'x' <> 'z') TP           // Prints: ABC

         "yyxxxxABCxxyyxx".trimBoth(c => c == 'x' || c == 'y') TP // Prints: ABC
     ```
*/
