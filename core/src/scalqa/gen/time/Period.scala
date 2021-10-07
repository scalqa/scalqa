package scalqa; package gen; package time; import language.implicitConversions

import Gen.Time

final class Period private[time] (val start: Time, val end: Time, val endIsIn: Boolean = false) extends Val.<>.X.Abstract[Time,Period]:
  def ordering : Ordering[Time]       = Time.ordering
  def length   : Time.Length          = start lengthTo end
  def lastDay  : Day                  = if(end.isDayStart && !endIsIn) end.day.prior else end.day
  def day_~    : ~[Day]               = start.day.index.self_^.map(s => (s <> lastDay.index).~.map(i => Day.fromIndex(s + i)))

  // -------------------------------------------------------------------------------------------------------------------------------
  protected def makeNew(s:Time, e:Time, in:Boolean) = new Period(s,e,in)

object Period:
  def apply(start: Time, end: Time) : Period = new Period(start, end)
  def apply(r: <>[Time])            : Period = new Period(r.start, r.end, r.endIsIn)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@class Period  ->

    Period is a custom Time range implementation

    It does have few time specific methods, like '.length', '.day_~', '.lastDay', which are not available in general range.

*/