package scalqa; package gen; package calendar; package z; import language.implicitConversions

private[calendar] object day:
  private var lookup       : Day.Lookup.Stable[Setup] = \/
  private var currentDay   : Day                      = Time().day
  private var nextDayStart : Time                     = currentDay.next.start

  def current: Day =
    val t = Time()
    if (t >= nextDayStart) { currentDay = t.day; nextDayStart = currentDay.next.start }
    currentDay

  def setup(d: Day): Setup =
    if (d.^.isVoid) Void
    else lookup.get_?(d) or { Setup(java.time.LocalDate.ofEpochDay(d.index)).^(v => lookup = lookup + (d,v) )}

  // ***********************************************************************************
  class Setup(val year: Year, val month: Month, val number: Int, val start: Time):
    def this(d: java.time.LocalDate) = this(Year(d.getYear), Month(d.getYear, d.getMonthValue), d.getDayOfMonth, Time.fromMillis(d.atStartOfDay(Time.Zone.Id).toInstant.toEpochMilli))

  private object Void extends Setup(\/, \/, 0, \/) with Self.Void

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
