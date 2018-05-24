package scalqa; package String; package _library

trait _transform extends Any with __ {

  def allChars: ~[Char] = new Z.allChars(This)

  def allSubstrings(size: Int): ~[String] = new Z.allSubstrings(This, size)

  def split(separator: Char): Array[String] = Ops.split(separator)

  def split(separator: String): Array[String] = Ops.split(separator)

  // ---------------------------------------------------------------------------------------
  def toDouble: Double = Ops.toDouble
  def toDoubleOpt: Opt.orError[Double] = Opt.orError.get(toDouble)

  def toInt: Int = Ops.toInt
  def toIntOpt: Opt.orError[Int] = Opt.orError.get(toInt)

  def toLong: Long = Ops.toLong
  def toLongOpt: Opt.orError[Long] = Opt.orError.get(toLong)

  def toBoolean: Boolean = Ops.toBoolean
  def toBooleanOpt: Opt.orError[Boolean] = Opt.orError.get(toBoolean)
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 *
 * @def split(separator: Char) -> Tokenize
 *
 *     Splits String into [[Array]] of [[String]] based on ''separator''
 *    {{{ "ab,cd,ef,g".split(',').all lp  // ~(ab, cd, ef, g) }}}
 *
 *  @def split(separator: String) -> Tokenize
 *
 *     Splits String into [[Array]] of [[String]] based on ''separator''
 *    {{{ "ab<>cd<>ef<>g".split("<>").all lp  // ~(ab, cd, ef, g) }}}
 *
 * @def allChars -> Pipe of Chars
 *
 *    Returns String as a [[Pipe]] of [Char]]
 *    {{{ "abcd".allChars lp // Prints: ~(a, b, c, d) }}}
 *
 * @def allSubstrings -> Pipe of substrings
 *
 *    Returns String as a [[Pipe]] of substrings of given size
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
 * @def toBoolean: -> Boolean conversion
 *
 *     Parses [[String]] to [[Boolean]], [[Fail]] if error.
 *
 * @def toBooleanOpt -> Boolean optional conversion
 *
 *     Optionally converts [[String]] to [[Boolean]]
 *
 *     {{{
 *       "true".toBooleanOpt lp
 *
 *       "abc".toBooleanOpt lp
 *
 *       // Output
 *       Opt(true)
 *       Opt.Error(java.lang.IllegalArgumentException: For input string: "abc")
 *     }}}
 *
 * @def toDouble: -> Double conversion
 *
 *     Parses [[String]] to [[Double]], [[Fail]] if error.
 *
 * @def toDoubleOpt -> Double optional conversion
 *
 *     Optionally converts [[String]] to [[Double]]
 *
 *     {{{
 *       "123.45".toDoubleOpt lp
 *
 *       "abc".toDoubleOpt lp
 *
 *       // Output
 *       Opt(123.45)
 *       Opt.Error(java.lang.NumberFormatException: For input string: "abc")
 *     }}}
 *
 * @def toLong: -> Long conversion
 *
 *     Parses [[String]] to [[Long]], [[Fail]] if error.
 *
 * @def toLongOpt -> Long optional conversion
 *
 *     Optionally converts [[String]] to [[Long]]
 *
 *     {{{
 *       "123".toLongOpt lp
 *
 *       "abc".toLongOpt lp
 *
 *       // Output
 *       Opt(123)
 *       Opt.Error(java.lang.NumberFormatException: For input string: "abc")
 *     }}}
 *
 * @def toInt: -> Int conversion
 *
 *     Parses [[String]] to [[Int]], [[Fail]] if error.
 *
 * @def toIntOpt -> Int optional conversion
 *
 *     Optionally converts [[String]] to [[Int]]
 *
 *     {{{
 *       "123".toIntOpt lp
 *
 *       "abc".toIntOpt lp
 *
 *       // Output
 *       Opt(123)
 *       Opt.Error(java.lang.NumberFormatException: For input string: "abc")
 *     }}}
 */
