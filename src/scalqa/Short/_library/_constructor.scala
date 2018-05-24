package scalqa; package Short; package _library

trait _constructor extends Any with __ {

  def The: Short.The = Short.The.get(This)

  def Rich = new scala.runtime.RichShort(This)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @def The -> "The Short" constructor
 *
 *     Built-in constructor to create [[Short.The]] instances
 *
 *     {{{ (0:Short).The.Class.lp  // Prints: scalqa.Short.The}}}
 *
 * @def Rich -> Scala library
 *
 *   Provides access to Scala RichShort library.
 *
 *   This library is available by default in Scala, but is disabled in Scalqa
 *
 *   {{{
 *      1000.Rich.isValidChar.lp  // Prints: true
 *   }}}
 */
