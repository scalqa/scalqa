package scalqa; package String; package _library

trait _substring extends Any with __ with Able.Copy.Range[String] {

  def copyBefore(value: String, default: Opt[String] = \/, from: Opt[Int] = \/): String = This.indexOfOpt(value, from) map (This.substring(0, _)) orOpt default or This

  def copyBeforeLast(value: String, default: Opt[String] = \/, from: Opt[Int] = \/): String = This.lastIndexOfOpt(value, from) map (This.substring(0, _)) orOpt default or This

  // -------------------
  def copyFrom(value: String, default: Opt[String] = \/, from: Opt[Int] = \/): String = This.indexOfOpt(value, from) map (This.substring(_)) orOpt default or This

  def copyFromLast(value: String, default: Opt[String] = \/, from: Opt[Int] = \/): String = This.lastIndexOfOpt(value, from) map (This.substring(_)) orOpt default or This

  // -------------------
  def copyAfter(value: String, default: Opt[String] = \/, from: Opt[Int] = \/): String = This.indexOfOpt(value, from) map (i => This.substring(i + value.length)) orOpt default or This

  def copyAfterLast(value: String, default: Opt[String] = \/, from: Opt[Int] = \/): String = This.lastIndexOfOpt(value, from) map (i => This.substring(i + value.length)) orOpt default or This

  // -------------------
  protected def _copy(r: Int.Range): String = This.substring(r.start, r.end)
  protected def _copyDrop(r: Int.Range): String = This.substring(0, r.start) + This.substring(r.end)
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
 *     @example
 *     {{{
 *
 *       // real method in J.File, returns file extension from canonical name
 *
 *        def extension: String = real.getCanonicalPath.copyAfterLast(".", "")
 *     }}}
 *
 *
 * @def copyFrom( -> Copy end
 *
 *     Copies String from the position where the specified ''value'' found
 *
 *     If no value found, ''default'' value is returned, or original if default is void
 *     @param string position to start looking from
 *     @example
 *     {{{
 *         "abcdefg".copyFrom("cd") lp // Prints: cdefg
 *     }}}
 *
 * @def copyFromLast -> Copy end
 *
 *     Copies String from the last position the specified ''value'' found
 *
 *     If no value found, ''default'' value is returned, or original if default is void.
 *     @param from string last position to start looking from end to start
 *     @example
 *     {{{
 *         "abcd_abcd_abcd".copyromLast("ab") lp // Prints: abcd
 *     }}}
 *
 * @def copyAfter( -> Copy end
 *
 *     Copies String from the position where the specified ''value'' found plus the length of the ''value''
 *
 *     If no value found, ''default'' value is returned, or original if default is void
 *     @param string position to start looking from
 *     @example
 *     {{{
 *         "abcdefg".copyAfter("cd") lp // Prints: efg
 *     }}}
 *
 * @def copyAfterLast -> Copy end
 *
 *     Copies String from the last position the specified ''value'' found plus the length of the ''value''
 *
 *     If no value found, ''default'' value is returned, or original if default is void.
 *     @param from string last position to start looking from end to start
 *     @example
 *     {{{
 *         "abcd_abcd_abcd".copyFromLast("ab") lp // Prints: cd
 *     }}}
 *
 * @def copyBefore( -> Copy start
 *
 *     Copies String from the beginning until specified ''value'' found
 *
 *     If no value found, ''default'' value is returned, or original if default is void
 *     @param string position to start looking from
 *     @example
 *     {{{
 *         "abcdefg".copyBefore("ef") lp // Prints: abcd
 *     }}}
 *
 * @def copyBeforeLast -> Copy start
 *
 *     Copies String from the beginning until the last occurrence of specified ''value'' found
 *
 *     If no value found, ''default'' value is returned, or original if default is void
 *
 *     @param from string last position to start looking from end to start
 *     @example
 *     {{{
 *         "abcd_abcd_abcd".copyBeforeLast("ab") lp // Prints: abcd_abcd_
 *     }}}
 */
