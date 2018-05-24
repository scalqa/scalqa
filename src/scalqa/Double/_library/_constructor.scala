package scalqa; package Double; package _library

trait _constructor extends Any with __ {

  def Percent = scalqa.Percent.get(This)

  def The: Double.The = Double.The.get(This)

  def Rich = new scala.runtime.RichDouble(This)

}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @def Percent -> Percent constructor
 *
 *     Built-in constructor to create [[Numeric.Percent]] instances
 *
 *     {{{
 *         5.Percent lp      // Prints: 5.0%
 *
 *         100.0.Percent lp  // Prints: 100.0%
 *     }}}
 *
 *
 * @def The -> "The Double" constructor
 *
 *     Built-in constructor to create [[Double.The]] instances
 *
 *     {{{
 *       0D.The.Class.lp  // Prints: scalqa.Double.The
 *     }}}
 *
 * @def Rich -> Scala library
 *
 *   Provides access to Scala RichDouble library.
 *
 *   This library is available by default in Scala, but is disabled in Scalqa
 *
 *   {{{
 *      100.0.Rich.isPosInfinity.lp  // Prints: false
 *   }}}
 *
 */
