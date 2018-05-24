package scalqa; package Boolean; package _library

trait _use extends Any with __ {

  @inline def not: Boolean = !This

  def opt[A](value: A): Opt[A] = if (This) value else \/

  def ?[A](trueValue: => A, falseValue: => A): A = if (This) trueValue else falseValue

  def filter[A]: A => Boolean = if (This) EVERY else NONE

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @def opt -> Value if ''true''
 *
 *   Returns optional value if ''This'' is ''true'' and Opt.Void if ''false''
 *
 *   {{{
 *       def isMutable  : Boolean = true
 *       def isWritable : Boolean = true
 *       def isWeired   : Boolean = false
 *
 *       def allAsStrings = ~[String] ~~ isMutable.opt("mutable") ~~ isWritable.opt("writable") ~~ isWeired.opt("weired")
 *
 *       allAsStrings lp // Prints: ~(mutable, writable)
 *   }}}
 *
 * @def ? -> Conditional
 *
 *     If ''This'' is ''true'', returns trueValue
 *
 *     If ''This'' is ''false'', returns falseValue
 *
 * @def filter -> Value filter
 *
 *     Returns a filter function for given type
 *
 *     If ''This'' is ''true'', the filter will always returns ''true''
 *
 *     If ''This'' is ''false'', the filter will always returns ''false''
 */
