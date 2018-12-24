package scalqa; package Custom; package String; package _library; package _evaluate

trait _check[TYPE] extends Any with Any.Datum[TYPE, String] {

  def isVoid = real == null || real.length == 0

  def contains(sub: String): Boolean = real.contains(sub)

  def startsWith(sub: String): Boolean = real.startsWith(sub)

  def endsWith(sub: String): Boolean = real.endsWith(sub)

  def equalsIgnoreCase(v: String): Boolean = real.equalsIgnoreCase(v)

  def isLike(mask: String, ignoreCase: Boolean = false): Boolean = Z.isLike(real, mask, ignoreCase)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @def contains -> Contains check
 *
 *     Returns true is `this` String contains `that` String
 *     {{{  "abc".contains("cd") lp // Prints: false }}}
 *
 * @def startsWith -> Check if begins with
 *
 *     Returns true `this` String starts with `that` String
 *     {{{  "abc".startsWith("ab") lp // Prints: true }}}
 *
 * @def endsWith -> Check if ends with
 *
 *     Returns true `this` String ends with `that` String
 *     {{{  "abc".endsWith("bc") lp // Prints: true }}}
 *
 * @def equalsIgnoreCase -> Check if equals ignore case
 *
 *     Returns true `this` and `that` String are equal, if upper and lower case Chars are considered equal
 *     {{{  "aBc".equalsIgnoreCase("ABC").lp // Prints: true }}}
 *
 *  @def isLike -> Check if pattern
 *
 *     Returns true if `this` matches `that` pattern with '%' wild card
 *
 *     {{{
 *       "ABCD".isLike("AB%") lp  // Prints: true
 *       "ABCD".isLike("AC%") lp  // Prints: false
 *    }}}
 *
 *     @param ignoreCase if true upper and lower case Chars are considered equal
 */
