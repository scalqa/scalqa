package scalqa; package Time; package Period; package Z

private[Time] object format {

  val Separator = " to "

  def apply(p: Period): String = apply(p, false)

  def apply(p: Period, fullSize: Boolean): String = {
    if (!fullSize) {
      if (p.isFullYear) return p.start.year.toString
      if (p.isFullMonth) return p.start.month.toString
      if (p.isFullDay) return p.start.day.toString
    }
    String.Builder.get(30).I(b => {
      b =+ p.start.day =+ ' ' =+ p.start.dayTime.format(fullSize) =+ Separator
      if (fullSize || !p.isSameDay) b =+ p.end.day + " "
      b =+ p.end.dayTime.format(fullSize)
    }).toString
  }

  def parse(s: String): Period = {
    val i = s.indexOf(Separator)
    if (i > 0) return parse(s.copyFirst(i), s.copyFrom(i + Separator.length))
    if (s.length <= 4) { val y = Year.get(s.toInt); return Time.Period.get(y.start, y.next.start) }
    else if (s.length <= 7) { val m = Month.getParse(s); return Time.Period.get(m.start, m.next.start) }
    else if (s.length <= 10) { val d = Day.getParse(s); return Time.Period.get(d.start, d.next.start) }
    // -----------------------------------
    val t = Time.getParse(s)
    if (t.subMillis =!= 0L) Time.Period.get(t, t + 1.Millis)
    else if (t.subSeconds =!= 0) Time.Period.get(t, t + 1.Second)
    else if (t.subMinutes =!= 0) Time.Period.get(t, t + 1.Minute)
    else Time.Period.get(t, t + 1.Hour)
  }

  def parse(start: String, end: String): Period = {
    val fromT = Time.getParse(start)
    val toT = if (end.indexOf(" ") > 0) Time.getParse(end) else Time.get(fromT.day, DayTime.getParse(end))
    Time.Period.get(fromT, toT)
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
