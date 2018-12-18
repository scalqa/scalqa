package scalqa; package Custom; package String; package _library

trait _substring[TYPE] extends Any with Any.Datum[TYPE, String] with Any.Able.CopyRange[TYPE] {

  def size = real.length

  def copyBefore(sub: String, default: Opt[String] = \/, from: Opt.Int = \/): TYPE = make(real.indexOfOpt(sub, from) map (real.substring(0, _)) orOpt default or real)

  def copyBeforeLast(sub: String, default: Opt[String] = \/, from: Opt.Int = \/): TYPE = make(real.lastIndexOfOpt(sub, from) map (real.substring(0, _)) orOpt default or real)

  // -------------------
  def copyFrom(sub: String, default: Opt[String] = \/, from: Opt.Int = \/): TYPE = make(real.indexOfOpt(sub, from) map (real.substring(_)) orOpt default or real)

  def copyFromLast(sub: String, default: Opt[String] = \/, from: Opt.Int = \/): TYPE = make(real.lastIndexOfOpt(sub, from) map (real.substring(_)) orOpt default or real)

  // -------------------
  def copyAfter(sub: String, default: Opt[String] = \/, from: Opt.Int = \/): TYPE = make(real.indexOfOpt(sub, from) map (i => real.substring(i + sub.length, real.length)) orOpt default or real)

  def copyAfterLast(sub: String, default: Opt[String] = \/, from: Opt.Int = \/): TYPE = make(real.lastIndexOfOpt(sub, from) map (i => real.substring(i + sub.length, real.length)) orOpt default or real)

  // -------------------
  def copy(r: Idx.Range): TYPE = make(real.substring(r.start, r.end))
  def copyDrop(r: Idx.Range): TYPE = make(real.substring(0, r.start) + real.substring(r.end))
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @trait _substring ->
 *
 *     This trait provides some copy overloads, which at first glance seem to be unnesasary, but they proved to bring semantic clarity in the code.
 *
 * @def copyFrom( -> Copy end
 *
 *     Copies String from the position where the specified `real` found
 *
 *     If no real found, `default` real is returned, or original if default is void
 *     {{{
 *         "abcdefg".copyFrom("cd") lp // Prints: cdefg
 *     }}}
 *     @param string position to start looking from
 *
 * @def copyFromLast -> Copy end
 *
 *     Copies String from the last position the specified `real` found
 *
 *     If no real found, `default` real is returned, or original if default is void.
 *     {{{
 *         "abcd_abcd_abcd".copyromLast("ab") lp // Prints: abcd
 *     }}}
 *     @param from string last position to start looking from end to start
 *
 * @def copyAfter( -> Copy end
 *
 *     Copies String from the position where the specified `real` found plus the length of the `real`
 *
 *     If no real found, `default` real is returned, or original if default is void
 *     {{{
 *         "abcdefg".copyAfter("cd") lp // Prints: efg
 *     }}}
 *     @param string position to start looking from
 *
 * @def copyAfterLast -> Copy end
 *
 *     Copies String from the last position the specified `real` found plus the length of the `real`
 *
 *     If no real found, `default` real is returned, or original if default is void.
 *     {{{
 *         "abcd_abcd_abcd".copyFromLast("ab") lp // Prints: cd
 *     }}}
 *     @param from string last position to start looking from end to start
 *
 * @def copyBefore( -> Copy start
 *
 *     Copies String from the beginning until specified `real` found
 *
 *     If no real found, `default` real is returned, or original if default is void
 *     {{{
 *         "abcdefg".copyBefore("ef") lp // Prints: abcd
 *     }}}
 *     @param string position to start looking from
 *
 * @def copyBeforeLast -> Copy start
 *
 *     Copies String from the beginning until the last occurrence of specified `real` found
 *
 *     If no real found, `default` real is returned, or original if default is void
 *
 *     {{{
 *         "abcd_abcd_abcd".copyBeforeLast("ab") lp // Prints: abcd_abcd_
 *     }}}
 *     @param from string last position to start looking from end to start
 */
