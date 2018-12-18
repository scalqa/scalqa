package scalqa; package Util; package Time; package Z

private[Time] object PeriodFormat {

  val Separator = " to "

  def apply(p: Period): String = apply(p, false)

  def apply(p: Period, fullSize: Boolean): String = {
    if (!fullSize) {
      if (p.isFullYear) return p.start.year.toString
      if (p.isFullMonth) return p.start.month.toString
      if (p.isFullDay) return p.start.day.toString
    }
    val b = new StringBuilder(30)
    b.append(p.start.day).append(' ').append(DayTimeFormat(p.start.dayTime, fullSize)).append(Separator)
    if (fullSize || !p.isSameDay) b.append(p.end.day).append(" ")
    b.append(DayTimeFormat(p.end.dayTime, fullSize))
    b.toString
  }

  def parse(s: String): Period = {
    val i = s.indexOf(Separator)
    if (i > 0) return parse(s.copyFirst(i), s.copyFrom(i + Separator.length))
    if (s.length <= 4) { val y = Year.make(s.toInt); return Time.Period.make(y.start, y.next.start) }
    else if (s.length <= 7) { val m = Month.make(s); return Time.Period.make(m.start, m.next.start) }
    else if (s.length <= 10) { val d = Calendar.Day.make(s); return Time.Period.make(d.start, d.next.start) }
    // -----------------------------------
    val t = Time.make(s)
    if (t.subMillis != 0) Time.Period.make(t, t + 1.Millis)
    else if (t.subSeconds != 0) Time.Period.make(t, t + 1.Second)
    else if (t.subMinutes != 0) Time.Period.make(t, t + 1.Minute)
    else Time.Period.make(t, t + 1.Hour)
  }

  def parse(start: String, end: String): Period = {
    val fromT = Time.make(start)
    val toT = if (end.indexOf(" ") > 0) Time.make(end) else Time.make(fromT.day, DayTime.make(end))
    Time.Period.make(fromT, toT)
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
