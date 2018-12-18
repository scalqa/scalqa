package scalqa; package Util; package Time

class Period private[Time] (val start: Time, val end: Time) extends Range[Time] {
  protected override type this_type = Period

  override def startExclusive = false
  override def endExclusive = true

  def ordering: Ordering[Time] = Time.Ordering

  def duration: Duration = start durationTo end

  def lastDay = if (end.isDayStart) end.day.prior else end.day

  def days: Idx[Day] = new Idx[Day] { val s = start.day.index; lazy val size = lastDay.index - s + 1; def apply(idx: Int) = Day.fromIndex(s + idx) }

  override def equals(that: Any) = that.I.letType[Period].let(_.start == start).let(_.end == end)

  def isSameDay = start.day == lastDay
  def isSameMonth = start.month == lastDay.month
  def isSameYear = start.year == lastDay.year

  def isFullDay = start.isDayStart && end.isDayStart && start.day == end.day.prior
  def isFullMonth = start.isMonthStart && end.isMonthStart && start.month == end.day.month.prior
  def isFullYear = start.isYearStart && end.isYearStart && start.year == end.year.prior

  def fullDay: Period = if (isFullDay) this else Period.make(start.day.start, lastDay.next.start)
  def fullMonth: Period = if (isFullMonth) this else Period.make(start.day.month.start, lastDay.next.month.start)
  def fullYear: Period = if (isFullYear) this else Period.make(start.day.year.start, lastDay.next.year.start)

  override def toString: String = format(true)

  def toBrief: String = format(false)

  def format(fullSize: Boolean): String = Z.PeriodFormat(this, fullSize)

  protected def make(start: Time, startExcl: Boolean, end: Time, endExcl: Boolean) = Period.make(start, end)
  protected override def thisClass: Class[_] = classOf[Period]
  protected def ilk = Ilk.Objects
}

object Period extends Util.Void.Setup[Period](new Period(\/, \/) with Void) {

  implicit def zzDuration(p: Period) = p.duration

  def make(start: Time, end: Time) = new Period(start, end)

  def make(r: Range[Time]) = new Period(r.start, r.end)

  def make(s: String): Period = Z.PeriodFormat.parse(s)

  def make(start: String, end: String): Period = Z.PeriodFormat.parse(start, end)

}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
