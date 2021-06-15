package scalqa; package fx; package scene; package chart; package axis; package x; package time; package z; import language.implicitConversions

import Gen.{ Time, DayTime, Year }

class Gauge(tu: Time.Length, mc: Int) extends X.Time.Gauge(tu, mc):
  def roundPeriod(p: Time.Period)   : Time.Period = p join p.start.roundTo(tu)(using DOWN) join p.end.roundTo(tu)(using UP)
  def label(t: Time, first: Boolean): String      = { val b = String.Builder(25); formatJob(t, t.dayTime, first, b); b.toString }
  def tag                           : String      = length.tag

  private val formatJob: (Time, DayTime, Boolean, String.Builder) => Unit = {
    val j =  Idx.M[(Time, DayTime, Boolean, String.Builder) => Unit]()

    def isSecondStart(dt: DayTime) = dt.millisTotal % 1.Second.millisTotal == 0
    def isMinuteStart(dt: DayTime) = dt.millisTotal % 1.Minute.millisTotal == 0
    def isHourStart(  dt: DayTime) = dt.millisTotal % 1.Hour.millisTotal   == 0

    if (length < 1.Second) j.add((t, dt, f, b) => b += dt.millis += '\n')
    if (length < 1.Minute) j.add((t, dt, f, b) => { val be = b.isEmpty; if (f || be || isSecondStart(dt)) { b += dt.seconds; if (!be || f) b += 's'; b += '\n' } })
    if (length < 1.Hour)   j.add((t, dt, f, b) => { val be = b.isEmpty; if (f || be || isMinuteStart(dt)) { b += dt.minutes; if (!be || f) b += 'm'; b += '\n' } })
    if (length < 1.Day)    j.add((t, dt, f, b) => { val be = b.isEmpty; if (f || be || isHourStart(dt)) {   b += dt.hours;   if (!be || f) b += 'h'; b += '\n' } })
    j.add((t, dt, f, b) => {
      if (!b.isEmpty && (f || t.isYearStart)) b += t.day.tag
      else {
        if (f || t.day > (t - length).day) {     val be = b.isEmpty; b += t.day.number;   if (!be || f) b += 'd'; b += '\n' }
        if (f || t.month > (t - length).month) { val be = b.isEmpty; b += t.month.number; if (!be || f) b += 'm'; b += '\n' }
        if (f || t.isYearStart) b += t.year
      }
    })
    (t, dt, f, b) => j.~.foreach(_(t, dt, f, b))
  }


object Gauge:
  // **********************************************************************************
  class Month(count: Int, minor: Int) extends X.Time.Gauge((30 * count).Days, minor):
    def roundPeriod(p: Time.Period)    : Time.Period = p join { val m = p.start.month; (m - (m.index % count)).start } join { val m = p.end.month; (m + (count - m.index % count)).start }
    def tag                            : String      = count +- " Months / " +- length
    def label(t: Time, first: Boolean) : String      =
      val b = String.Builder(25)
      b += t.month.number += "\n"
      if (first || t.year > (t - length).year) b += t.year
      b.toString

  // **********************************************************************************
  class Year(count: Int, minor: Int) extends X.Time.Gauge((count * 56).Weeks, minor):
    def roundPeriod(p: Time.Period)    : Time.Period = p join { val y = p.start.year.number; Gen.Year(y - (y % count)).start } join { val y = p.end.year.number; Gen.Year(y + count - (y % count)).start }
    def label(t: Time, first: Boolean) : String      = t.year.tag
    def tag                            : String      = s"$count Years / $length"

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
