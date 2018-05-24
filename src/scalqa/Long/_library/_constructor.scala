package scalqa; package Long; package _library

import Time.{ Length => L }

trait _constructor extends Any with __ {

  def Second: L.Seconds = Seconds
  def Seconds: L.Seconds = L.Seconds.get(This)

  def Millis = L.Millis.get(This)

  def Micros = L.Micros.get(This)

  def Nanos = L.Nanos.get(This)

  def Rich = new scala.runtime.RichLong(This)

  def The: Long.The = Long.The.get(This)
}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @def The -> "The Long" constructor
 *
 *     Built-in constructor to create [[Long.The]] instances
 *
 *     {{{ 0L.The.Class.lp  // Prints: scalqa.Long.The}}}
 *
 * @def Rich -> Scala library
 *
 *   Provides access to Scala RichLong library.
 *
 *   This library is available by default in Scala, but is disabled in Scalqa
 *
 *   {{{
 *      1000.Rich.toOctalString.lp  // Prints: 1750
 *   }}}
 *
 * @def Seconds -> Seconds constructor
 *
 *     Built-in constructor to create [[Time.Length.Seconds]] instances
 *
 *     {{{ 11.Seconds.lp // Prints: 11 secs}}}
 *
 * @def Second: -> Seconds constructor
 *
 *     Same as 'Seconds', but recommended for use with base 1
 *
 *     {{{ 1.Second.lp // Prints: 1 sec}}}
 *
 * @def Millis -> Millis constructor
 *
 *     Built-in constructor to create [[Time.Length.Millis]] instances
 *
 *     {{{ 99.Millis.lp // Prints: 99 millis}}}
 *
 * @def Micros -> Micros constructor
 *
 *     Built-in constructor to create [[Time.Length.Micros]] instances
 *
 *     {{{ 99.Micros.lp // Prints: 99 micros}}}
 *
 * @def Nanos -> Nanos constructor
 *
 *     Built-in constructor to create [[Time.Length.Nanos]] instances
 *
 *     {{{ 99.Nanos.lp // Prints: 99 nanos}}}
 *
 */
