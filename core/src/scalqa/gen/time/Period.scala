package scalqa; package gen; package time; import language.implicitConversions

final class Period private[time] (val start: Time, val end: Time) extends Val.<>.X.Base[Time,Period]:
  def endIsIn  : Boolean              = false
  def ordering : Time.Ordering        = Time.ordering
  def length   : Time.Length          = start lengthTo end
  def lastDay  : Day                  = if (end.isDayStart) end.day.prior else end.day
  def day_~    : ~[Day]               = { val s = start.day.index; (s <> lastDay.index).~.map(i => Day.byIndex(s + i)) }

  // -------------------------------------------------------------------------------------------------------------------------------
  protected def make(s:Time, e:Time, in:Boolean)(using Ordering[Time]) = {if(in) J.illegalState(); Period(s,e)}

object Period:
  def apply(start: Time, end: Time) : Period = new Period(start, end)
  def apply(r: <>[Time])            : Period = new Period(r.start, r.end)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@def endIsIn -> false

      Always false

*/
