package scalqa; package Time; package Length; package Z; package Custom

private[Time] trait _Trait extends Any with Long.Like with Able.Void {
  protected override type THIS <: _Trait

  override def isVoid = value == 0

  def length = new Length(_totalMillis)

  def preciseLength: Time.Precise.Length = Time.Precise.Length.get(_totalSeconds, _preciseNanos)

  def toString(brief: Boolean): String = {
    val v = value
    val n = companion._name
    v.toString + (n ? (_ => brief, _.copyFirst(1), " " + _ ? (_ => v > 1 && !n.endsWith("s"), _ + 's')))
  }

  override def toString: String = toString(false)

  protected def companion: Companion[THIS]

  private[Time] def toPaddedString = value.toString.padStartTo(companion._paddedLength, "0")
  private[Time] def _totalMillis: Long
  private[Time] def _totalSeconds = _totalMillis / 1000
  private[Time] def _preciseNanos = 0

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @def isVoid -> Void check.
 *
 *     Value 0 will test void
 *
 * @def toString( -> String description.
 *    @param brief  short version request.
 *
 *   {{{
 *     10.Hours.toString(true).lp   // Prints:  10h
 *     10.Hours.toString(false).lp  // Prints:  10 hours
 *   }}}
 *
 * @def toString: -> String description.
 *
 *     Same as toString(false).
 *
 * @def length -> Length conversion.
 *
 *     Converts ''this'' custom length unit to general [[Time.Length]].
 *
 * @def preciseLength -> Precise conversion.
 *
 *     Converts ''this'' custom length unit to general [[Time.Precise.Length]].
 *
 */
