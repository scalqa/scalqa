package scalqa; package Fx; package Chart; package Axis; package A; package TimeBased; package Z

class The(tu: Duration, val mc: Int) extends Unit(tu, mc) {

  private val formatJob: (Time, DayTime, Boolean, StringBuilder) => scala.Unit = {
    val j: Idx.M[(Time, DayTime, Boolean, StringBuilder) => scala.Unit] = NEW

    def isSecondStart(dt: DayTime) = dt.totalMillis.real % 1.Second.totalMillis.real == 0
    def isMinuteStart(dt: DayTime) = dt.totalMillis.real % 1.Minute.totalMillis.real == 0
    def isHourStart(dt: DayTime) = dt.totalMillis.real % 1.Hour.totalMillis.real == 0

    if (length < 1.Second) j += ((t, dt, f, b) => b.append(dt.subMillis).append('\n'))
    if (length < 1.Minute) j += ((t, dt, f, b) => { val be = b.isEmpty; if (f || be || isSecondStart(dt)) { b.append(dt.subSeconds); if (!be || f) b += 's'; b += '\n' } })
    if (length < 1.Hour) j += ((t, dt, f, b) => { val be = b.isEmpty; if (f || be || isMinuteStart(dt)) { b.append(dt.subMinutes); if (!be || f) b += 'm'; b += '\n' } })
    if (length < 1.Day) j += ((t, dt, f, b) => { val be = b.isEmpty; if (f || be || isHourStart(dt)) { b.append(dt.hours); if (!be || f) b += 'h'; b += '\n' } })
    j += ((t, dt, f, b) => {
      if (!b.isEmpty && (f || t.isYearStart)) b.append(t.day)
      else {
        if (f || t.day > (t - length).day) { val be = b.isEmpty; b.append(t.day.number); if (!be || f) b += 'd'; b += '\n' }
        if (f || t.month > (t - length).month) { val be = b.isEmpty; b.append(t.month.number); if (!be || f) b += 'm'; b += '\n' }
        if (f || t.isYearStart) b.append(t.year)
      }
    })
    (t, dt, f, b) => j.all.foreach(_(t, dt, f, b))
  }

  def roundPeriod(p: Period) = p extendTo p.start.round(tu, DOWN) extendTo p.end.round(tu, UP)

  def label(t: Time, first: Boolean): String = { val b = new StringBuilder(25); formatJob(t, t.dayTime, first, b); b.toString }

  override def toString = length.toString

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
