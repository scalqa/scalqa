package scalqa; package String; package _library

trait _modify extends Any with __ {

  def padStartTo(targetLength: Int, pad: String = " "): String = { var v = This; while (v.length < targetLength) v = pad + v; v }

  def padEndTo(targetLength: Int, pad: String = " "): String = { var v = This; while (v.length < targetLength) v += pad; v }

  def label: String = This.allChars.zipPrior.map(t => if (t._2.isLetter && !t._1.drop(c => c.isWhitespace)) t._2.upper else t._2).format()

  def *(times: Int): String = if (times <= 0) Empty else Ops * times

  def replaceAt(r: Int.Range, value: String): String = This.copyFirst(r.start) + value + This.copyFrom(r.end)

  def replace(value: String, target: String): String = This.replace(value, target)

  def insertAt(i: Int, value: String): String = This.copyFirst(i) + value + This.copyFrom(i)

  def remove(value: String): String = This.replace(value, "")

  def lower = This.toLowerCase

  def upper = This.toUpperCase

  def trimStart: String = trimEnd(_.isSpaceChar)

  def trimStart(f: Char => Boolean): String = This.charIndexOpt(!f(_)).map(This.copyFrom) or ""

  def trimEnd: String = trimEnd(_.isSpaceChar)

  def trimEnd(f: Char => Boolean): String = This.lastCharIndexOpt(!f(_)).map(_ + 1).map(This.copyFirst) or ""

  def trim: String = This.trim

  def trimBoth(f: Char => Boolean): String = trimStart(f).trimEnd(f)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @def padStartTo -> Pad start
 *
 *     Pads start of string to ''targetLength''
 *
 *     @param pad string to pad with.
 *     {{{ "ABC".padStartTo(10,"_") lp // Prints: _______ABC }}}
 *
 * @def padEndTo -> Pad end
 *
 *     Pads end of string to ''targetLength''
 *
 *     @param pad string to pad with.
 *     {{{ "ABC".padEndTo(10,"_") lp // Prints: ABC_______ }}}
 *
 * @def label -> Capitalize
 *
 *   Capitalizes first character of every word (separated by white spaces)
 *   {{{ "all string ops".label lp // Prints: All String Ops }}}
 *
 * @def * -> Multiply
 *
 *   Multiplies string specified number of ''times''
 *   {{{ "abc" * 5 lp // Prints: abcabcabcabcabc }}}
 *
 * @def replaceAt-> Replace range with value
 *
 *   Creates new String with all occurrences of ''value'' replaced with ''target''
 *   {{{ "0123456789".replaceAt(3 <> 7 ,"_") lp // Prints: 012_89 }}}
 *
 * @def replace(-> Replace all
 *
 *   Creates new String with all occurrences of ''value'' replaced with ''target''
 *   {{{ "123123123123".replace("2","_") lp // Prints: 1_31_31_31_3 }}}
 *
 * @def insertAt-> Insert at position
 *
 *   Creates new String with ''value'' inserted at the specified position
 *   {{{ "0123456789".insertAt(5,"abc") lp // Prints: 01234abc56789 }}}
 *
 * @def remove-> Remove all
 *
 *   Creates new String with all occurrences of ''value'' removed
 *   {{{ "123123123123".remove("2") lp // Prints: 13131313 }}}
 *
 * @def lower-> toLowerCase
 *
 *   Creates new String with all upper case Chars changed to lower case
 *   {{{ "ABc".lower lp // Prints: abc }}}
 *
 * @def upper-> toUpperCase
 *
 *   Creates new String with all lower case Chars changed to upper case
 *   {{{ "aBc".upper lp // Prints: ABC }}}
 *
 * @def trimStart:-> Trim start
 *
 *   Trims start of String from space Chars
 *
 * @def trimStart( -> Trim start
 *
 *    Trims start of String from [[Char]]s defined by filter function
 *
 *   {{{
 *       "yyzzxxABC".trimBoth('x' <> 'z') lp                // Prints: ABC
 *
 *       "yyzzxxABC".trimBoth(c => c == 'x' || c == 'y') lp // Prints: zzxxABC
 *   }}}
 *
 * @def trimEnd:-> Trim end
 *
 *   Trims end of String from space Chars
 *
 * @def trimEnd( -> Trim both ends
 *
 *    Trims end of String from [[Char]]s defined by filter function
 *
 *   {{{
 *       "ABCzzyyxx".trimEnd('x' <> 'z') lp                // Prints: ABC
 *
 *       "ABCzzyyxx".trimEnd(c => c == 'x' || c == 'y') lp // Prints: ABCzz
 *   }}}
 *
 * @def trim:-> Trim both ends
 *
 *   Trims both ends of String from space Chars
 *
 * @def trimBoth -> Trim both ends
 *
 *    Trims both ends of String from [[Char]]s defined by filter function
 *
 *   {{{
 *       "yyzzxxABCzzyyxx".trimBoth('x' <> 'z') lp                // Prints: ABC
 *
 *       "yyzzxxABCzzyyxx".trimBoth(c => c == 'x' || c == 'y') lp // Prints: zzxxABCzz
 *   }}}
 */
