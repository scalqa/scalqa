package scalqa; package Util; package Calendar; package Z

private[Calendar] class DaySetup(val year: Year, val month: Month, val number: Int, val start: Time) {
  def this(d: java.time.LocalDate) = this(
    Year.make(d.getYear),
    Month.make(d.getYear, d.getMonthValue),
    d.getDayOfMonth,
    Time.fromMillis(d.atStartOfDay(Time.Zone.Id).toInstant.toEpochMilli))
}

private[Calendar] object DaySetup extends IntLookup[DaySetup](i => new DaySetup(java.time.LocalDate.ofEpochDay(i)))

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
