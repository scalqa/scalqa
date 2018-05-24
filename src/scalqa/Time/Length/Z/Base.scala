package scalqa; package Time; package Length; package Z

private[Time] trait Base extends Any with Like.Core {
  protected type TARGET <: Base

  def *(number: Int): TARGET

  def /(number: Int): TARGET

  def totalDays: Time.Length.Days = (totalMillis / Length.MillisOfDay).toInt

  def toBrief(trimUnit: Length = 1.Second): String = format(roundDown(trimUnit), true)

  override def toString = format(this, false)

}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 *
 * @def toBrief -> Short description.
 *
 *   Converts Length to short String description.
 *
 *   @param trimUnit [[Time.Length]] to round down ''this'' with.
 *
 *   @example
 *   {{{
 *       Time.Length.get(10.Hours, 15.Seconds, 45.Minutes).toBrief(1.Minute).lp
 *       // Output
 *       10h, 45m
 *   }}}
 *
 * @def toString -> Description.
 *
 *   Converts Length to String description.
 *
 *   {{{
 *       Time.Length.get(10.Hours, 15.Seconds, 45.Minutes).lp
 *       // Output
 *       10 hours, 45 mins, 15 sec
 *   }}}
 *
 * @def totalDays -> Day count.
 *
 *     Total days (24.Hours) which fit in ''this'' time unit.
 *
 *
 * @def * -> Multiply
 *
 *     Creates new length by multiplying ''this'' length.
 *
 *     {{{
 *         (1.Hour.length * 5).lp // Prints: 5 hours
 *     }}}
 *
 *
 * @def / -> Divide
 *
 *     Creates new length by dividing ''this'' length.
 *
 *     {{{
 *         (10.Hours.length / 5).lp // Prints: 2 hours
 *     }}}
 *
 *
 */
