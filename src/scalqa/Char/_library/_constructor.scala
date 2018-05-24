package scalqa; package Char; package _library

trait _constructor extends Any with __ {

  def Rich = new scala.runtime.RichChar(This)

  def The: Char.The = Char.The.get(This)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @def The -> "The Char" constructor
 *
 *     Built-in constructor to create [[Char.The]] instances
 *
 *     {{{ 'A'.The.Class.lp  // Prints: scalqa.Char.The}}}
 *
 * @def Rich -> Scala library
 *
 *   Provides access to Scala RichChar library.
 *
 *   This library is available by default in Scala, but is disabled in Scalqa
 *
 *   {{{
 *      'A'.Rich.isHighSurrogate.lp  // Prints: false
 *   }}}
 */
