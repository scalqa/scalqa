package scalqa; package Custom; package String; package _library

trait _transform[TYPE] extends Any with Any.Datum[TYPE, String] {

  def allChars: ~[Char] = new Z.allChars(real)

  def allSubstrings(size: Int): ~[String] = new Z.allSubstrings(real, size)

  def toDoubleOut: Out[Double] = Out.withTry(real.toDouble)

  def toIntOut: Out[Int] = Out.withTry(real.toInt)

  def toLongOut: Out[Long] = Out.withTry(real.toLong)

  def toBooleanOut: Out[Boolean] = Out.withTry(real.toBoolean)

  def indent(tag: String): String = Z.indent(real, tag)

  def allLines: ~[String] = real.lines

  def allTokenized(separators: ~[String]): ~[(String, Idx.Range, String)] = Z.allTokenized(real, separators)
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 *
 * @def indent -> Indents text with the tahStream of lines
 *
 *   Indents text with the tag.
 *
 *   Prefixes first line with the tag, other lines with tag equal space
 *
 *   {{{
 *      "abc\nde\nxyz".indent("Lines: ").lp
 *      // Output
 *      Lines: abc
 *             de
 *             xyz
 *   }}}
 *
 * @def allLines -> Stream of lines
 *
 *   Creates a [[Stream]] of Strings representing lines (delimited by '\n') of this text
 *
 *   {{{  "abc\n def\n xyz".allLines.lp // Prints: ~(abc,  def,  xyz) }}}
 *
 *
 * @def allTokenized -> Stream of tokens
 *
 *    Multi token tokenizetion
 *
 *    Returns a Tuple including:
 *
 *      - Separator preceding the token, empty for the first token
 *      - [[Idx.Range]] of the token in the text
 *      - String token
 *
 *    {{{
 *       val str: String = (1 <> 40).all.format()
 *       "Text to Tokenize:".lp.lp
 *       str.lp.lp
 *       ("Token", "Range", "String").lp
 *       str.replaceAll("\n", "_").allTokenized("000" ~+ "111" + "222" + "333" + "444").tp
 *
 *       // Output
 *
 *       Text to Tokenize:
 *
 *       12345678910111213141516171819202122232425262728293031323334353637383940
 *
 *       (Token,Range,String)
 *       --- --------- -------------------
 *       ?   ?         ?
 *       --- --------- -------------------
 *           0 <>> 11  12345678910
 *       111 14 <>> 33 2131415161718192021
 *       222 36 <>> 55 3242526272829303132
 *       333 58 <>> 71 4353637383940
 *       --- --------- -------------------
 *    }}}
 *
 *    @param separators a [[Stream]] of text separators to consider
 *
 *
 * @def allChars -> Stream of Chars
 *
 *    Returns String as a [[Stream]] of [Char]]
 *    {{{ "abcd".allChars lp // Prints: ~(a, b, c, d) }}}
 *
 * @def allSubstrings -> Stream of substrings
 *
 *    Returns String as a [[Stream]] of substrings of given size
 *
 *    Note: Last substring may be shorter
 *    {{{
 *       ("abc" * 10) lp
 *
 *       ("abc" * 10).allSubstrings(4) lp
 *
 *       // Output
 *       abcabcabcabcabcabcabcabcabcabc
 *       ~(abca, bcab, cabc, abca, bcab, cabc, abca, bc)
 *    }}}
 *
 * @def toBooleanOut -> Boolean outcome conversion
 *
 *     Converts String to Boolean outcome
 *
 *     {{{
 *       "true".toBooleanOut lp
 *
 *       "abc".toBooleanOut lp
 *
 *       // Output
 *       Out(true)
 *       Out(failure=For input string: "abc")
 *     }}}
 *
 * @def toDoubleOut -> Double outcome conversion
 *
 *     Converts String to Double outcome
 *
 *     {{{
 *       "123.45".toDoubleOut lp
 *
 *       "abc".toDoubleOut lp
 *
 *       // Output
 *       Out(123.45)
 *       Out(failure=For input string: "abc")
 *     }}}
 *
 * @def toLongOut -> Long outcome conversion
 *
 *     Converts String to Long outcome
 *
 *     {{{
 *       "123".toLongOut lp
 *
 *       "abc".toLongOut lp
 *
 *       // Output
 *       Out(123)
 *       Out(failure=For input string: "abc")
 *    }}}
 *
 * @def toIntOut -> Int outcome conversion
 *
 *     Converts String to Int outcome
 *
 *     {{{
 *       "123".toIntOut lp
 *
 *       "abc".toIntOut lp
 *
 *       // Output
 *       Out(123)
 *       Out(failure=For input string: "abc")
 *     }}}
 */
