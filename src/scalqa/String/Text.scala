package scalqa; package String

class Text private (protected val real: String) extends AnyVal with Like {
  protected override type THIS = Text

  protected def companion = Text

  def indent(tag: String): Text = Z.Text.indent(this, tag)

  def allLines: ~[String] = value.Ops.lines

  def allTokenized(separators: ~[String]): ~[(String, Int.Range, String)] = Z.Text.allTokenized(real, separators)

}

object Text extends Like.Companion[Text] {

  def get(v: String) = new Text(v)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/

/**
 * @class Text-> Text has all the functionality of a String, thanks to library attached
 *
 *   Plus, [[Text]] has few more methods related to the notion of 'lines' delimited by 'end of line' character
 *
 * @def indent -> Indents text with the tahPipe of lines
 *
 *   Indents text with the tag.
 *
 *   Prefixes first line with the tag, other lines with tag equal space
 *
 *   {{{
 *      "abc\nde\nxyz".Text.indent("Lines: ").lp
 *      // Output
 *      Lines: abc
 *             de
 *             xyz
 *   }}}
 *
 * @def allLines -> Pipe of lines
 *
 *   Creates a [[Pipe]] of [[String]]s representing lines (delimited by '\n') of this [[Text]]
 *
 *   {{{  "abc\n def\n xyz".Text.allLines.lp // Prints: ~(abc,  def,  xyz) }}}
 *
 *
 * @def allTokenized -> Pipe of tokens
 *
 *    Multi token tokenizetion
 *
 *    Returns a Tuple including:
 *
 *      - Separator preceding the token, empty for the first token
 *      - [[Int.Range]] of the token in the text
 *      - [[String]] token
 *
 *    @param separators a [[Pipe]] of [[Text]] separators to consider
 *    @example
 *    {{{
 *       val str: String = (1 <> 40).all.format()
 *       "Text to Tokenize:".lp.lp
 *       str.lp.lp
 *       ("Token", "Range", "String").lp
 *       str.replaceAll("\n", "_").Text.allTokenized("000" ~ "111" ~ "222" ~ "333" ~ "444").tp
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
 */
