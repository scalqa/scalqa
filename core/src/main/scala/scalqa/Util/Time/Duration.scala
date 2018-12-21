package scalqa; package Util; package Time

class Duration private[scalqa] (val real: Long) extends AnyVal with Like.Length[Duration] with Like.Core.A.Millis with Any.Datum.Long.Computable[Duration] {
  protected def setup = Duration

  def totalMillis = real Millis

  def round(l: Duration, r: Custom.Rounding = \/) = make(r.remainder(real, l.real))

  def toPreciseDuration = PreciseDuration.fromNanos(totalNanos.real)

  override def toString = Z.LengthFormat(this, false)

}

object Duration extends Any.Datum.Long.Computable.Setup[Duration] {

  protected def make(v: Long) = new Duration(v)

  def fromMillis(v: Long) = new Duration(v)

  def sum(l: Duration, more: Duration*): Duration = fromMillis(more.all.map(_.real).fold(l.real)(_ + _))

  implicit def zzValue_Duration_toPreciseDuration(v: Duration): PreciseDuration = v.toPreciseDuration

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @class Duration ->
 *
 *   [[Duration]] represents general time duration without specified start or end.
 *
 * @def toPrecise -> Precise Length
 *
 *   Converts `this` [[Duration]] to [[PreciseDuration]].
 */
