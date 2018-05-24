package scalqa; package Range

trait _basic[A] extends Any with __[A] {

  def start: A

  def startExclusive: Boolean

  def end: A

  def endExclusive: Boolean

  def sorting: Sorting[A]

  override def toString = start.I.toString + startExclusive ? (" <<", " <") + endExclusive ? (">> ", "> ") + end.I.toString

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @def start: -> From value
 *
 *    Start value of the range
 *
 * @def startExclusive -> Exclusive check
 *
 *    If true, the ''start'' value is exclusive
 *    {{{
 *      10 <<> 15 contains 10 lp  // Prints: false
 *
 *      // Exclusive 10 does not contain 10
 *    }}}
 *
 * @def end: -> To value
 *
 *    End value of the range
 *
 * @def endExclusive -> Exclusive check
 *
 *    If true, the ''end'' value is exclusive
 *    {{{
 *      10 <>> 15 contains 15 lp  // Prints: false
 *
 *      // Exclusive 15 does not contain 15
 *    }}}
 *
 * @def toString -> String description
 *
 *     String is in the form: ''start <> end''
 *
 *     << and >> define exclusive values
 *
 *     {{{
 *       1 <> 5    //  1 to 5
 *       1 <>> 5   //  1 to 5 exclusive
 *       1 <<> 5   //  exclusive 1 to 5
 *       1 <<>> 5  //  1 to 5 all exclusive
 *     }}}
 */
