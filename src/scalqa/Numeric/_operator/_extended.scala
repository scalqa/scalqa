package scalqa; package Numeric; package _operator

trait _extended extends Any with __ {

  def +%(p: Percent): THIS = math.toDouble(value).I.to(d => map(math(d + p(d))))

  def -%(p: Percent): THIS = math.toDouble(value).I.to(d => map(math(d - p(d))))

  def *%(p: Percent): THIS = map(math(math.toDouble(value) / 100 * p))

  def *^(p: Int): THIS = map(math.power(value, p))

  def ===(v: Numeric): Boolean = math.sorting(value, math(v)).isEither

  def =!=(v: Numeric): Boolean = math.sorting(value, math(v)).isNotEither

}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @def *^ -> Power
 *
 *     Computes power of ''this''
 *     {{{
 *       10 *^ 2 lp         // Prints: 100
 *
 *       10 *^ 3 lp         // Prints: 1000
 *
 *       5.Percent *^ 2 lp  // Prints: 25.0%
 *     }}}
 *
 * @def +% -> Plus percent
 *
 *     Adds percent value to ''this''
 *     {{{
 *       50 +% 20.Percent lp   // Prints: 60
 *
 *       30.Minutes +% 20 lp   // Prints: 36 mins
 *     }}}
 *
 * @def -% -> Minus percent
 *
 *     Removes percent value from ''this''
 *     {{{
 *       50 -% 20.Percent lp   // Prints: 40
 *
 *       30.Minutes -% 20 lp   // Prints: 24 mins
 *     }}}
 *
 * @def *% -> Multiply by percent
 *
 *     Returns percentage value
 *
 *     Note: Multiplying something by 100.Percent is like multiplying by 1
 *
 *     {{{
 *        1000 *% 30.Percent lp  // Prints: 300
 *
 *        30.Millis *% 200 lp    // Prints: 60 millis
 *     }}}
 *
 * @def === -> Value equal
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
 * @def =!= -> Value not equal
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
