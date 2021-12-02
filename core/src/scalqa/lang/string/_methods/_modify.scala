package scalqa; package lang; package string; package _methods; import language.implicitConversions

transparent trait _modify:

  extension(inline x: String)
    @tn("joinTag") inline def ++[A](inline v: A)                (using inline d: Any.Def.Tag[A]): String = x + d.value_tag(v)
    @tn("joinOpt") inline def +?[A](inline v: Opt[A])           (using inline d: Any.Def.Tag[A]): String = x.self.mapIf(_ => v.nonEmpty, _ + v.toString)
    /**/           inline def padStartTo  (inline size: Int, inline pad: String = " ")          : String = Z.padStartTo(x,size,pad)
    /**/           inline def padEndTo    (inline size: Int, inline pad: String = " ")          : String = Z.padEndTo  (x,size,pad)
    /**/           inline def label                                                             : String = Z.label(x)
    /**/           inline def replace     (inline r: Int.Range, inline v: String)               : String = Z.replace(x,r,v)
    /**/           inline def replace     (inline v: String, inline target: String)             : String = x.replace(v, target)
    /**/           inline def replaceFirst(inline v: String, inline v2:String,inline cnt: Int=1): String = z.replace.first(x,v,v2,cnt)
    /**/           inline def replaceLast (inline v: String, inline v2:String,inline cnt: Int=1): String = z.replace.last (x,v,v2,cnt)
    /**/           inline def insertAt(inline i: Int, inline v: String)                         : String = Z.insertAt(x,i,v)
    /**/           inline def remove(inline v: String)                                          : String = x.replace(v, VOID)
    /**/           inline def lower                                                             : String = x.toLowerCase
    /**/           inline def upper                                                             : String = x.toUpperCase
    /**/           inline def trimStart                                                         : String = Z.trimStart(x,_.isSpaceChar)
    /**/           inline def trimStart(inline f: Char => Boolean)                              : String = Z.trimStart(x,f)
    /**/           inline def trimEnd                                                           : String = Z.trimEnd(x,_.isSpaceChar)
    /**/           inline def trimEnd  (inline f: Char => Boolean)                              : String = Z.trimEnd(x,f)
    /**/           inline def trim                                                              : String = x.trim
    /**/           inline def trimBoth (inline f: Char => Boolean)                              : String = Z.trimBoth(x,f)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@def ++ -> Join tag

       Joins value tag to base string.

       Use it instead of '+'. Single plus joins '.toString' instead of '.tag', which often does not make sense especially for 'opaque values'

       Note. This method should logically be called '+'.
             However, it is already defined in 'final class String' and cannot be overridden.

       ```
          val p = 12.Percent

          val s = "Value: " ++ p

          // same result as

          val s = "Value: " + p.tag
       ```

@def +? -> Optional join

       Joins option value to base string.

       Returns String "as is" for empty option.

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
