package scalqa; package `def`; package string; package _Extension; import language.implicitConversions

transparent trait _modify[A<: String | Opaque.String]:
  self: z.Lib[A] =>

  extension(x: A)
    /**/                  def join(   v: A|String)                          : A   = (x.real + v).cast[A]
    /**/                  def joinAll(v: ~[A|String])                       : A   = v.foldAs(x)(_ + _)
    @tn("_join")   inline def + (inline v: A|String)                        : A   = x.join(v)
    @tn("_joinAll")inline def ++(inline v: ~[A|String])                     : A   = x.joinAll(v)
    /**/                  def padStartTo(sz: Int, pad: String = " ")        : A   = { var v = x.real; while (v.length < sz) v = pad + v; v.cast[A] }
    /**/                  def padEndTo  (sz: Int, pad: String = " ")        : A   = { var v = x.real; while (v.length < sz) v += pad; v.cast[A] }
    /**/                  def label                                         : A   = x.char_~.zipPrior.map(t => if (t._2.isLetter && !t._1.drop(_.isWhitespace)) t._2.toUpper else t._2).makeString().cast[A]
    /**/                  def replace(r: Int.<>, v: A|String)               : A   = (x.takeFirst(r.start) + v + x.dropFirst(r.endX)).cast[A]
    /**/           inline def replace(v: A|String, target: A|String)        : A   = x.real.replace(v, target).cast[A]
    /**/                  def replaceFirst(v:A|String,v2:A|String,cnt:Int=1): A   = Z.replaceFirst(x.real,v,v2,cnt).cast[A]
    /**/                  def replaceLast( v:A|String,v2:A|String,cnt:Int=1): A   = Z.replaceLast (x.real,v,v2,cnt).cast[A]
    /**/                  def insertAt(i: Int, v: A|String)                 : A   = (x.takeFirst(i) + v + x.dropFirst(i)).cast[A]
    /**/           inline def remove(v: A|String)                           : A   = x.real.replace(v, \/).cast[A]
    /**/           inline def lower                                         : A   = x.toLowerCase.cast[A]
    /**/           inline def upper                                         : A   = x.toUpperCase.cast[A]
    /**/           inline def trimStart                                     : A   = x.real.trimStart(_.isSpaceChar).cast[A]
    /**/                  def trimStart(f: Char => Boolean)                 : A   = x.charIndex_?(!f(_)).map(x.dropFirst(_)) or "".cast[A]
    /**/           inline def trimEnd                                       : A   = x.real.trimEnd(_.isSpaceChar).cast[A]
    /**/                  def trimEnd(f: Char => Boolean)                   : A   = x.lastCharIndex_?(!f(_)).map(_ + 1).map(x.takeFirst(_)) or "".cast[A]
    /**/           inline def trim                                          : A   = x.real.trim.cast[A]
    /**/                  def trimBoth(f: Char => Boolean)                  : A   = x.real.trimStart(f).trimEnd(f).cast[A]

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
     ``` "all string ops".tag TP // Prints: All String Ops ```


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
         "yyxxxxABC".trimBoth('x' <> 'z') TP                // Prints: ABC

         "yyxxxxABC".trimBoth(c => c == 'x' || c == 'y') TP // Prints: xxxxABC
     ```


@def trimEnd -> Trim end

     Trims end of String from space Chars


@def trimEnd ->  Trim both ends

      Trims end of String from Chars defined by let function

     ```
         "ABCxxyyxx".trimEnd('x' <> 'z') TP                // Prints: ABC

         "ABCxxyyxx".trimEnd(c => c == 'x' || c == 'y') TP // Prints: ABCxx
     ```


@def trim -> Trim both ends

     Trims both ends of String from space Chars


@def trimBoth -> Trim both ends

      Trims both ends of String from Chars defined by let function

     ```
         "yyxxxxABCxxyyxx".trimBoth('x' <> 'z') TP                // Prints: ABC

         "yyxxxxABCxxyyxx".trimBoth(c => c == 'x' || c == 'y') TP // Prints: xxxxABCxx
     ```

*/
