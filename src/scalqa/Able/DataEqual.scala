package scalqa; package Able

trait DataEqual[A] extends Any {

  protected def _dataEqual(v: A): Boolean

  def ===(v: A): Boolean = _dataEqual(v)

  def =!=(v: A): Boolean = !_dataEqual(v)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @def === -> Data equal
 *
 *   Checks if the base value is equal
 *
 *   {{{
 *     // Generic examples
 *
 *     10.Seconds === 10.Millis lp  // Prints: true
 *
 *     10.Seconds ==  10.Millis lp  // Prints: false
 *
 *     10.Seconds === 10.Percent lp // Prints: true
 *
 *     10.Seconds ==  10.Percent lp // Prints: false
 *
 *     "abc".Id === "abc".Text lp   // Prints: true
 *
 *     "abc".Id ==  "abc".Text lp   // Prints: false
 *   }}}
 *
 *
 * @def =!= -> Data not equal
 *
 *   Checks if the base value is not equal
 *
 *   {{{
 *     // Generic examples
 *
 *     10.Seconds =!= 10.Millis lp  // Prints: false
 *
 *     10.Seconds  != 10.Millis lp  // Prints: true
 *
 *     10.Seconds =!= 10.Percent lp // Prints: false
 *
 *     10.Seconds  != 10.Percent lp // Prints: true
 *
 *     "abc".Id =!= "abc".Text lp   // Prints: false
 *
 *     "abc".Id  != "abc".Text lp   // Prints: true
 *   }}}
 */
