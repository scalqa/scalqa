package scalqa; package Numeric

trait _use extends Any with __ {

  def min(v: THIS): THIS = if (math.sorting(value, map.undo(v)).isAsIs) This else v

  def max(v: THIS): THIS = if (math.sorting(value, map.undo(v)).isInverse) This else v

  def minDefault(v: THIS): THIS = max(v)

  def maxDefault(v: THIS): THIS = min(v)

  def abs: THIS = if (math.sorting(value, math.Zero).isAsIs) map(math.multiply(value, math.MinusOne)) else This

  def signum: Int = math.sorting(value, math.Zero).signum

  def round(positions: Int, trimOnly: Boolean = false): THIS = map(math.round(value, positions, trimOnly))

  def format(decimalFormatPattern: String): String = math.format(value, decimalFormatPattern)

  def sorting: Sorting[Numeric] = math.sorting.asMap(math.apply)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @def min( -> Minimum value
 *
 *     Returns minimum of ''this'' and provided value
 *
 * @def maxDefault -> Minimum value
 *
 *     This is equivalent to 'min', but is semantically more readable when setting max value constant
 *
 *     {{{
 *         App.availableProcessors maxDefault 4  // Returns number of availableProcessors, but no more then 4
 *     }}}
 *
 * @def max( -> Maximum value
 *
 *     Returns maximum of ''this'' and provided value
 *
 * @def minDefault -> Maximum value
 *
 *     This is equivalent to 'max', but is semantically more readable when setting min value constant
 *
 *     {{{
 *         App.availableProcessors minDefault 2  // Returns number of availableProcessors, but no less then 2
 *     }}}
 *
 * @def abs -> Absolute value
 *
 *     Returns non negative value of this [[Numeric]]
 *
 * @def sorting -> Sorting
 *
 *     Sorting for this
 *
 * @def format -> Format
 *
 *     Formats this numeric with given format pattern
 *
 *     See [[https://docs.oracle.com/javase/7/docs/api/java/text/DecimalFormat.html java.text.DecimalFormat]] for pattern details
 *
 *     Basic Number Pattern Characters:
 *
 *       - ' '''0''' '  Digit
 *       - ' '''#''' '  Digit, zero shows as absent
 *       - ' '''.''' '  Decimal separator or monetary decimal separator
 *       - ' '''-''' '  Minus sign
 *       - ' ''',''' '  Grouping separator
 *
 *     {{{
 *       Long.OneMillion.format("#,###") lp             // Prints: 1,000,000
 *
 *       Long.OneMillion.format("#,###.00#") lp         // Prints: 1,000,000.00
 *
 *       (Long.OneMillion / 3.0).format("#,###.00#") lp // Prints: 333,333.333
 *     }}}
 *
 * @def round -> Round
 *
 *     Rounds ''this'' Numeric to the specified ''positions''
 *
 *     When rounding by default (trimOnly == false), (0 <>> 0.5) becomes 0 and (0.5 <>> 1) becomes 1
 *
 *     @param positions 0 - rounds nothing, positive indicate decimal digits after period, negative round to 10 in power '- positions'
 *     @param trimOnly if ''true'', the value is trimmed, 1.9 becomes 1, not 2 otherwise
 *
 *     {{{
 *       // Generic example
 *
 *       12.3456.Percent.round(2) lp       // Prints: 12.35%
 *
 *       12.3456.Percent.round(2, true) lp // Prints: 12.34%
 *
 *       123456.Millis.round(-2) lp        // Prints: 123500 millis
 *
 *       123456.Millis.round(-2, true) lp  // Prints: 123400 millis
 *    }}}
 *
 * @def signum -> Sign function
 *
 *     Returns -1 if ''this'' <  0
 *
 *     Returns  0 if ''this'' == 0
 *
 *     Returns  1 if ''this'' >  0
 */
