package scalqa; package Double; package _library

trait _use extends Any with __ {

  def roundWholeUp: Double = Math.ceil(This)

  def roundWholeDown: Double = Math.floor(This) // it is different from toInt on negatives

  def isWhole = StrictMath.rint(This) == This

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @def isWhole -> Checks if value is whole
 *
 *     Checks if fraction portion equals 0
 *     {{{
 *        11.566.isWhole lp  // Prints: false
 *
 *       -12.0.isWhole lp    // Prints: true
 *     }}}
 *
 * @def roundWholeUp -> Round up to integer
 *
 *     Rounds this [[Double]] up to the closest whole value
 *
 *     See [[https://docs.oracle.com/javase/7/docs/api/java/lang/Math.html#ceil(double) java.Math.ceil]] for details
 *     {{{
 *       11.566.roundWholeUp lp   // Prints: 12.0
 *     }}}
 *
 *
 * @def roundWholeDown -> Round down to integer
 *
 *     Rounds this [[Double]] down to the closest whole value
 *
 *     See [[https://docs.oracle.com/javase/7/docs/api/java/lang/Math.html#floor(double) java.Math.floor]] for details
 *     {{{
 *        11.566.roundWholeDown lp   // Prints: 12.0
 *
 *       -11.566.roundWholeDown lp   // Prints: -12.0
 *     }}}
 */
