package scalqa; package String; package _library; package _evaluate

trait _search extends Any with __ {

  @inline protected def size = _target.length

  @inline def charAt(i: Int): Char = _target.charAt(i)

  def charAtOpt(i: Int): Opt[Char] = if (i < 0 || i >= _target.length) \/ else charAt(i)

  def indexOfOpt(value: String, from: Opt[Int] = \/): Opt[Int] = _target.indexOf(value, from or 0).I.let(_ >= 0)

  def lastIndexOfOpt(value: String, from: Opt[Int] = \/): Opt[Int] = _target.lastIndexOf(value, from.or(_target.length)).I.let(_ >= 0)

  def charIndexOpt(f: Char => Boolean, from: Opt[Int] = \/): Opt[Int] = { var i = from or 0; while (i < _target.length) { if (f(charAt(i))) return i; i += 1 }; \/ }

  def lastCharIndexOpt(f: Char => Boolean, fromOpt: Opt[Int] = \/): Opt[Int] = { var i = fromOpt or _target.length - 1; while (i >= 0) { if (f(charAt(i))) return i; i -= 1 }; \/ }

  def allIndexesOf(value: String, from: Opt[Int] = \/): ~[Int] = indexOfOpt(value, from).map(i => i ~~ allIndexesOf(value, i + value.length)) or \/

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @def charAt( -> Char at position
 *
 *     Returns [[Char]] at the specified position
 *
 * @def charAtOpt -> Char at position
 *
 *     Optionally Returns [[Char]] at the specified position
 *
 *     Opt.Void is returned if specified position is out of String range
 *     {{{
 *     if(<name>.charAtOpt(2).let(_.isUpper)) Fail.toDo
 *     // is equivalent
 *     if(<name>.length >=2 && <name>.charAt(2).isUpper) Fail.toDo
 *     }}}
 *
 *
 * @def indexOfOpt -> Value position
 *
 *   Optionally returns position of the specified ''value''
 *   @param from position to start looking from
 *   @example
 *   {{{ "abcd_abcd_".indexOfOpt("d_a") lp // Prints: Opt(3) }}}
 *
 * @def lastIndexOfOpt -> Value position
 *
 *   Optionally returns last position of the specified ''value''
 *   @param from last position to start looking from end to start
 *   @example
 *   {{{ "abcd_abcd_abcd_".lastIndexOfOpt("d_a") lp // Prints: Opt(8) }}}
 *
 * @def charIndexOpt -> Char index
 *
 *   Optionally returns index of the first Char passing the filter function
 *   @param from position to start looking from
 *   @example
 *   {{{
 *       "abcd_abcd_".charIndexOpt(_ >= 'd', 4) lp // Prints: Opt(8)
 *       "abcd_abcd_".charIndexOpt('x' <> 'z') lp  // Prints: Opt.Void
 *   }}}
 *
 * @def lastCharIndexOpt -> Char index
 *
 *   Optionally returns index of the last Char passing the filter function
 *   @param from last position to start looking from end to start
 *   @example
 *   {{{
 *       "abcd_abcd_".lastCharIndexOpt(_ >= 'd', 4) lp // Prints: Opt(3)
 *       "abcd_abcd_".lastCharIndexOpt('x' <> 'z') lp  // Prints: Opt.Void
 *   }}}
 *
 * @def allIndexesOf -> Pipe of indexes
 *
 *   Pipe of indexes for each occurrence of ''value''
 *   @param from position to start looking from
 *   @example
 *   {{{"abcd_abcd_abcd_abcd_abcd".allIndexesOf("bc") lp // Prints: ~(1, 6, 11, 16, 21) }}}
 */
