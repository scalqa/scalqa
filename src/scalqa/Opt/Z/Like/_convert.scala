package scalqa; package Opt; package Z; package Like

private[Opt] trait _convert[+A] extends Any with __[A] {

  def map[B](f: A => B): __[B]

  def mapCast[B]: __[B]

  def swap[B](newValue: => B): __[B]

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @trait _convert ->
 *
 *
 * @def map[ ->  Convert value
 *
 *    Creates new option with value converted by the given function
 *
 *    If there is no value, ''this'' is returned as is
 *
 *    {{{
 *       2.Opt.map(_ * 10) lp   // Prints: Opt(20)
 *    }}}
 *
 * @def mapCast -> Cast value
 *
 *    Casts ''this'' option to new value type
 *
 *    This same object is returned as is
 *
 *    Note. If type is incorrect, the failure will happen later on use
 *
 *    {{{
 *       val ao : Opt[Any]    = "Abc"
 *
 *       val so : Opt[String] = ao.mapCast[String]
 *    }}}
 *
 * @def swap ->  Replace value
 *
 *    Creates new option with value replaced with newValue
 *
 *    If there is no value, ''this'' is returned as is
 *
 *    {{{
 *       12.Opt.swap("Abc")   lp   // Prints: Opt(Abc)
 *
 *       Opt.Void.swap("Abc") lp   // Prints: Opt.Void
 *    }}}
 */
