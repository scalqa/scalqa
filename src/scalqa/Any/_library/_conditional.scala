package scalqa; package Any; package _library

trait _conditional[A] extends Any with __[A] {

  @inline def ?[B](condition: A => Boolean, firstValue: A => B, secondValue: A => B): B = if (condition(This)) firstValue(This) else secondValue(This)

  @inline def ?(filter: A => Boolean, newValue: A => A): A = if (filter(This)) newValue(This) else This

  @inline def ?(default: => A): A = if (Any.isVoid(This)) default else This

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @trait _conditional -> '''In-line Conditionals'''
 *
 *     These are conditional operations attached to ''every'' single object in Scalqa
 *
 *     To differentiate these operators in real code, one should look for the number of parameters, which are one, two, and three.
 *
 *     Also, keep in mind there is another [[Boolean._library._Class.? '?']] attached to Boolean value
 *
 * @def ?[ -> Two clause 'if'
 *
 *      Immediate 'if' or in-line 'if'
 *
 *      if ''condition'' evaluates to ''true'', ''firstValue'' function result is returned
 *
 *      Otherwise ''secondValue'' function result is returned
 *
 *    {{{
 *      "Today is " + Day.get ? (d => d.weekDay.isSun || d.weekDay.isSat, _ + ", weekend", _ + ", workday") lp
 *
 *      // Old Output
 *       Today is 2018-04-11, workday
 *    }}}
 *
 * @def ?(filter -> One clause 'if'
 *
 *   Changes value only if it passes ''filter' function
 *
 *   @param filter to check value
 *   @param newValue function to create the change
 *
 *   @example
 *   {{{
 *       // Capitalize
 *       "abc" ? (_.charAt(0).isLower, s => s.charAt(0).upper + s.copyFrom(1)) lp
 *
 *       // Output
 *       Abc
 *   }}}
 *
 * @def ?(default -> Default
 *
 *     If ''this'' isVoid, ''default'' is returned
 *
 *     Otherwise ''this'' is returned
 *
 *    {{{
 *         val p : Percent = \/
 *         val s : String  = null
 *
 *         p ? 12    lp  // Prints: 12.0%
 *
 *         s ? "abc" lp  // Prints: abc
 *    }}}
 */
