package scalqa; package Time; package Period

class _Class private[Time] (val start: Time, val end: Time) extends Range[Time] {
  protected override type THIS = Period

  override def startExclusive = false
  override def endExclusive = true

  def sorting = Sorting.The.Itself

  def length: Length = start lengthTo end

  def lastDay = if (end.isDayStart) end.day.prior else end.day

  def days: Index[Day] = new Index[Day] { val s = start.day.index; lazy val size = lastDay.index - s + 1; def apply(idx: Int) = Day.getByIndex(s + idx) }

  override def equals(that: Any) = that.I.letAs(classOf[Period]).let(_.start == start).let(_.end == end)

  def isSameDay = start.day == lastDay
  def isSameMonth = start.month == lastDay.month
  def isSameYear = start.year == lastDay.year

  def isFullDay = start.isDayStart && end.isDayStart && start.day == end.day.prior
  def isFullMonth = start.isMonthStart && end.isMonthStart && start.month == end.day.month.prior
  def isFullYear = start.isYearStart && end.isYearStart && start.year == end.year.prior

  def fullDay: Period = if (isFullDay) this else Period.get(start.day.start, lastDay.next.start)
  def fullMonth: Period = if (isFullMonth) this else Period.get(start.day.month.start, lastDay.next.month.start)
  def fullYear: Period = if (isFullYear) this else Period.get(start.day.year.start, lastDay.next.year.start)

  override def toString: String = format(true)

  def toBrief: String = format(false)

  def format(fullSize: Boolean): String = Z.format(this, fullSize)

  protected def _get(start: Time, startExcl: Boolean, end: Time, endExcl: Boolean) = Period.get(start, end)
  protected override def THIS_CLASS: Class[_] = classOf[Period]
}

object _Class extends Able.Void.Companion[Period](new Period(\/, \/) with Void) {

  import scala.language.implicitConversions

  implicit def zzLength(p: Period) = p.length

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
