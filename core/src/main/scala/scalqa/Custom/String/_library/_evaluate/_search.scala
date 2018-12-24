package scalqa; package Custom; package String; package _library; package _evaluate

trait _search[TYPE] extends Any with Any.Datum[TYPE, String] {

  protected def size: Int

  def charAt(i: Int): Char = real.charAt(i)

  def charAtOpt(i: Int): Opt[Char] = if (i < 0 || i >= real.length) \/ else charAt(i)

  def indexOfOpt(sub: String, from: Opt.Int = \/): Opt.Int = real.indexOf(sub, from or 0).I.let(_ >= 0)

  def lastIndexOfOpt(sub: String, from: Opt.Int = \/): Opt.Int = real.lastIndexOf(sub, from.or(real.length)).I.let(_ >= 0)

  def charIndexOpt(f: Char => Boolean, from: Opt.Int = \/): Opt.Int = { var i = from or 0; while (i < real.length) { if (f(charAt(i))) return i; i += 1 }; \/ }

  def lastCharIndexOpt(f: Char => Boolean, fromOpt: Opt.Int = \/): Opt.Int = { var i = fromOpt or real.length - 1; while (i >= 0) { if (f(charAt(i))) return i; i -= 1 }; \/ }

  def allIndexesOf(sub: String, from: Opt.Int = \/): ~[Int] = indexOfOpt(sub, from).map(i => i.I.~ +~ allIndexesOf(sub, i + sub.length)) or \/

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
 *     Returns Char at the specified position
 *
 * @def charAtOpt -> Char at position
 *
 *     Optionally Returns Char at the specified position
 *
 *     Opt.Void is returned if specified position is out of String range
 *     {{{
 *     if(<name>.charAtOpt(2).let(_.isUpper)) App.Fail.toDo
 *     // is equivalent
 *     if(<name>.length >=2 && <name>.charAt(2).isUpper) App.Fail.toDo
 *     }}}
 *
 *
 * @def indexOfOpt -> Value position
 *
 *   Optionally returns position of the specified `real`
 *   {{{ "abcd_abcd_".indexOfOpt("d_a") lp // Prints: Opt(3) }}}
 *   @param from position to start looking from
 *
 * @def lastIndexOfOpt -> Value position
 *
 *   Optionally returns last position of the specified `real`
 *   {{{ "abcd_abcd_abcd_".lastIndexOfOpt("d_a") lp // Prints: Opt(8) }}}
 *   @param from last position to start looking from end to start
 *
 * @def charIndexOpt -> Char index
 *
 *   Optionally returns index of the first Char passing the filter function
 *   {{{
 *       "abcd_abcd_".charIndexOpt(_ >= 'd', 4) lp // Prints: Opt(8)
 *       "abcd_abcd_".charIndexOpt('x' <> 'z') lp  // Prints: Opt.Void
 *   }}}
 *   @param from position to start looking from
 *
 * @def lastCharIndexOpt -> Char index
 *
 *   Optionally returns index of the last Char passing the filter function
 *   {{{
 *       "abcd_abcd_".lastCharIndexOpt(_ >= 'd', 4) lp // Prints: Opt(3)
 *       "abcd_abcd_".lastCharIndexOpt('x' <> 'z') lp  // Prints: Opt.Void
 *   }}}
 *   @param from last position to start looking from end to start
 *
 * @def allIndexesOf -> Stream of indexes
 *
 *   Stream of indexes for each occurrence of `real`
 *   {{{"abcd_abcd_abcd_abcd_abcd".allIndexesOf("bc") lp // Prints: ~(1, 6, 11, 16, 21) }}}
 *   @param from position to start looking from
 */
