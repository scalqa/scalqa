package scalqa; package Util; package Time; package Like

trait Unit[A <: Unit[A]] extends Any with Core with Any.Datum.Long.Number[A] {
  protected def setup: Unit.Setup[A]

  def real: Long

  def duration = Duration.fromMillis(totalMillis.real)

  def preciseDuration = PreciseDuration.fromNanos(totalNanos.real)

  def toBrief = format(true)

  override def toString = format(false)

  // --------------------------------------------------------------------------
  private[Util] def _is = real != 0

  private[Util] def padded = real.toString.padStartTo(setup.size, "0")

  private[Util] def format(brief: Boolean): String = real.toString + {
    val n = setup.name
    if (brief) n.copyFirst(1)
    else " " + (if (real > 1 && !n.endsWith("s")) n + 's' else n)
  }
}

private[Time] object Unit {

  abstract class Setup[A <: Unit[A]](private[Time] val name: String, private[Time] val size: Int) extends Any.Datum.Long.Number.Setup[A] {

    implicit def zzLength(v: A) = Duration.fromMillis(v.totalMillis.real)

    implicit def zzPreciseDuration(v: A) = PreciseDuration.fromNanos(v.totalNanos.real)

  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @param brief  short version request.
 *
 *   {{{
 *     10.Hours.toString(true).lp   // Prints:  10h
 *     10.Hours.toString(false).lp  // Prints:  10 hours
 *   }}}
 *
 * @def duration -> Length conversion.
 *
 *     Converts `this` custom duration unit to general [[Duration]].
 *
 * @def preciseDuration -> Precise conversion.
 *
 *     Converts `this` custom duration unit to general [[PreciseDuration]].
 *
 */
