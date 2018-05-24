package scalqa; package Time; package Length

class _Class private[Time] (protected val real: Long) extends AnyVal with Any.Value.Long with Z.Base with Like.Core.The.Millis {
  protected type THIS = _Class
  protected type TARGET = _Class

  protected def companion = _Class

  protected def _totalMillis = value

  protected def _get(millis: Long) = new Length(millis)

  def *(number: Int) = _get(_totalMillis * number)

  def /(number: Int) = _get(_totalMillis / number)

  def toPrecise = Precise.Length.getByMillis(value)

}

object _Class extends Any.Value.Long.Companion[_Class] {

  protected def get(v: Long) = new Length(v)

}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 *
 * @def toPrecise -> Precise Length
 *
 *   Converts ''this'' [[Length]] to [[Precise.Length]].
 *
 * @class _Class ->
 *
 *   [[Time.Length]] represents general time duration without specified start or end.
 *
 */
