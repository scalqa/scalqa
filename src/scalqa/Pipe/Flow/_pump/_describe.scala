package scalqa; package Pipe; package Flow; package _pump

trait _describe[A] extends __[A] with Able.Info {

  override protected def infoLine = toString

  override def infoText: String.Text = Z.describe.info.text(synchronize, false)

  protected def info = \/.info

  def format(separator: Opt[String] = \/, padBefore: Opt[String] = \/, padAfter: Opt[String] = \/, converter: Opt[A => String] = \/): String =
    Z.describe.format(synchronize, separator, padBefore, padAfter, converter)

  def toString(name: String): String = name + '(' + format(", ") + ')'

  override def toString: String = toString("~")
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @trait _describe -> '''Describe Interface'''
 *
 *   Allows pipeline to String conversions
 *
 * @def format -> Elements as String
 *
 *       All elements are converted toString
 *
 *       The results are concatenated with possible use of padding and separator
 *
 *       @param separator optional string between elements
 *       @param padBefore optional string before each element
 *       @param padAfter optional string after each element
 *       @param converter custom element to String function
 *
 *   @example
 *   {{{
 *       ('a' <> 'z').all.format().lp
 *       ('a' <> 'z').all.format("|").lp
 *       ('a' <> 'z').all.format(",", "[", "]").lp
 *
 *       // Output
 *       abcdefghijklmnopqrstuvwxyz
 *
 *       a|b|c|d|e|f|g|h|i|j|k|l|m|n|o|p|q|r|s|t|u|v|w|x|y|z
 *
 *       [a],[b],[c],[d],[e],[f],[g],[h],[i],[j],[k],[l],[m],[n],[o],[p],[q],[r],[s],[t],[u],[v],[w],[x],[y],[z]
 *   }}}
 *
 * @def toString( -> Elements description
 *
 *      Returns String starting with given ''name'' and containing all elements separated by ", "
 *      {{{
 *          (1 <> 5).all.toString("My Ints").lp
 *
 *          // Output
 *          My Ints(1, 2, 3, 4, 5)
 *      }}}
 *
 *
 * @def toString: -> Elements description
 *
 *      Returns String starting with "Pipe(" and containing all elements separated by ", "
 *      {{{
 *          (1 <> 5).all.toString.lp
 *
 *          // Output
 *          Pipe(1, 2, 3, 4, 5)
 *      }}}
 *
 * @def info = -> Not used
 *
 * @def infoLine ->  Same as toString
 *
 *      {{{
 *          (1 <> 5).all.toString.lp   // 'lp' prints 'infoLine'
 *
 *          // Output
 *          Pipe(1, 2, 3, 4, 5)
 *      }}}
 *
 * @def infoText -> Elements as formatted table
 *
 *    Returns all elements as String formatted table
 *
 *    If elements implement [[Able.Info]], each 'info' tag value is placed in a different column
 *
 *    If elements implement ''scala.Product'' (like all Tuples), each Product element is placed in a different column
 *
 *    Note. ''infoText'' is printed with universal [[Any._library._printDebug.tp:Unit*  <Any>.tp]] method
 *
 *    {{{
 *       ('a' <> 'e').all.map(c => (c + "1", c + "2", c + "3", c + "4", c + "5")) tp
 *
 *       // Output
 *       -- -- -- -- --
 *       ?  ?  ?  ?  ?
 *       -- -- -- -- --
 *       a1 a2 a3 a4 a5
 *       b1 b2 b3 b4 b5
 *       c1 c2 c3 c4 c5
 *       d1 d2 d3 d4 d5
 *       e1 e2 e3 e4 e5
 *       -- -- -- -- --
 *    }}}
 */
