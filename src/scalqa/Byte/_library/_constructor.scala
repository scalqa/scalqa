package scalqa; package Byte; package _library

trait _constructor extends Any with __ {

  def Rich = new scala.runtime.RichByte(This)

  def The: Byte.The = Byte.The.get(This)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @def The -> "The Byte" constructor
 *
 *     Built-in constructor to create [[Byte.The]] instances
 *
 *     {{{ (55:Byte).The.Class.lp  // Prints: scalqa.Byte.The}}}
 *
 * @def Rich -> Scala library
 *
 *   Provides access to Scala RichByte library.
 *
 *   This library is available by default in Scala, but is disabled in Scalqa
 *
 *   {{{
 *      55.toByte.Rich.isValidShort.lp  // Prints: true
 *   }}}
 *
 */
