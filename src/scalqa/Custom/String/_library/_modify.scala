package scalqa; package Custom; package String; package _library

trait _modify[TYPE] extends Any with Any.Datum[TYPE, String] {

  private[String] def undo(v: TYPE): String

  def +-(v: Any): TYPE = make(real + " " + v)

  def +(v: Any): TYPE = make(real + v)

  def +~(v: ~[Any]): TYPE = make(v.foldAs(real)(_ + _))

  def padStartTo(targetLength: Int, pad: String = " "): TYPE = { var v = real; while (v.length < targetLength) v = pad + v; make(v) }

  def padEndTo(targetLength: Int, pad: String = " "): TYPE = { var v = real; while (v.length < targetLength) v += pad; make(v) }

  def label: TYPE = make(real.allChars.zipPrior.map(t => if (t._2.isLetter && !t._1.drop(c => c.isWhitespace)) t._2.upper else t._2).format())

  def replace(r: Idx.Range, v: String): TYPE = make(real.copyFirst(r.start) + v + real.copyFrom(r.end))

  def replace(value: String, target: String): TYPE = make(real.replace(value, target))

  def insertAt(i: Int, v: String): TYPE = make(real.copyFirst(i) + v + real.copyFrom(i))

  def remove(sub: String): TYPE = make(real.replace(sub, ""))

  def lower = make(real.toLowerCase)

  def upper = make(real.toUpperCase)

  def trimStart: TYPE = trimStart(_.isSpaceChar)

  def trimStart(f: Char => Boolean): TYPE = make(real.charIndexOpt(!f(_)).map(real.copyFrom) or "")

  def trimEnd: TYPE = trimEnd(_.isSpaceChar)

  def trimEnd(f: Char => Boolean): TYPE = make(real.lastCharIndexOpt(!f(_)).map(_ + 1).map(real.copyFirst) or "")

  def trim: TYPE = make(real.trim)

  def trimBoth(f: Char => Boolean): TYPE = make(undo(trimStart(f)).trimEnd(f))

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @def +( -> Plus
 *
 *   Creates a new instance with specified value added
 *
 * @def +~ -> Plus all
 *
 *   Creates a new instance with added stream values
 *
 * @def padStartTo -> Pad start
 *
 *     Pads start of string to `targetLength`
 *
 *     @param pad string to pad with.
 *     {{{ "ABC".padStartTo(10,"_") lp // Prints: _______ABC }}}
 *
 * @def padEndTo -> Pad end
 *
 *     Pads end of string to `targetLength`
 *
 *     @param pad string to pad with.
 *     {{{ "ABC".padEndTo(10,"_") lp // Prints: ABC_______ }}}
 *
 * @def label -> Capitalize
 *
 *   Capitalizes first character of every word (separated by white spaces)
 *   {{{ "all string ops".label lp // Prints: All String Ops }}}
 *
 * @def replace(r -> Replace range with real
 *
 *   Creates new String with all occurrences of `real` replaced with `target`
 *   {{{ "0123456789".replace(3 <> 7 ,"_") lp // Prints: 012_89 }}}
 *
 * @def replace(v -> Replace all
 *
 *   Creates new String with all occurrences of `real` replaced with `target`
 *   {{{ "123123123123".replace("2","_") lp // Prints: 1_31_31_31_3 }}}
 *
 * @def insertAt-> Insert at position
 *
 *   Creates new String with `real` inserted at the specified position
 *   {{{ "0123456789".insertAt(5,"abc") lp // Prints: 01234abc56789 }}}
 *
 * @def remove-> Remove all
 *
 *   Creates new String with all occurrences of `real` removed
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
 *    Trims start of String from Chars defined by filter function
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
 *    Trims end of String from Chars defined by filter function
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
 *    Trims both ends of String from Chars defined by filter function
 *
 *   {{{
 *       "yyzzxxABCzzyyxx".trimBoth('x' <> 'z') lp                // Prints: ABC
 *
 *       "yyzzxxABCzzyyxx".trimBoth(c => c == 'x' || c == 'y') lp // Prints: zzxxABCzz
 *   }}}
 */
