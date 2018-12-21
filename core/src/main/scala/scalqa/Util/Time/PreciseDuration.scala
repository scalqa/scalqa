package scalqa; package Util; package Time

class PreciseDuration private[scalqa] (protected val real: Long) extends AnyVal with Like.Core.A.Nanos with Like.Length[PreciseDuration] with Any.Datum.Long.Computable[PreciseDuration] {
  protected def setup = PreciseDuration

  def totalNanos = real Nanos

  def round(l: Duration, r: Custom.Rounding = \/) = make(r.remainder(real, l.totalNanos.real))

  def toDuration = Duration.fromMillis(totalMillis.real)

  override def toString = Z.LengthFormat(this, false)

}

object PreciseDuration extends Any.Datum.Long.Computable.Setup[PreciseDuration] {

  protected def make(v: Long) = new PreciseDuration(v)

  def fromNanos(v: Long) = new PreciseDuration(v)

  def sum(l: PreciseDuration, more: PreciseDuration*): PreciseDuration = fromNanos(more.all.map(_.totalNanos.real).fold(l.totalNanos.real)(_ + _))

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @object PreciseDuration -> [[PreciseDuration]] can be created with the following custom duration units:
 *     [[Weeks]], [[Days]], [[Hours]], [[Minutes]],
 *     [[Seconds]], [[Millis]], [[Micros]], [[Nanos]]
 *
 *     {{{
 *       1.Day.preciseDuration.lp       // Prints: 1 day
 *       33.Millis.preciseDuration.lp   // Prints: 0.033 sec
 *       10.Hours.preciseDuration.lp    // Prints: 10 hours
 *       99999.Nanos.preciseDuration.lp // Prints: 0.000099999 sec
 *     }}}
 *
 *
 * @def fromNanos -> By nanoseconds.
 *
 *   Creates [[PreciseDuration]] by total nanoseconds.
 *
 *   {{{
 *       PreciseDuration.byNanos(Long.OneTrillion + 999).lp
 *       // Output
 *       16 mins, 40.000000999 secs
 *   }}}
 *
 * @def sum -> By generic units.
 *
 *   Creates [[PreciseDuration]] specified by one or more length units in any order.
 *
 *   {{{
 *        PreciseDuration.make(12.Hours, 45.Minutes, 999.Nanos, 5.Millis).lp
 *        // Output
 *        12 hours, 45 mins, 0.005000999 sec
 *   }}}
 *
 * @def toDuration -> To regular Duration
 *
 *     Converts `this` [[PreciseDuration]] to regular [[Duration]].
 */
