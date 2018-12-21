package scalqa; package Fx; package Chart; package Axis; package A; package TimeBased; package Z

class TheMonth(count: Int, minor: Int) extends Unit((30 * count).Days, minor) {

  def roundPeriod(p: Period) = p extendTo { val m = p.start.month; (m - (m.index % count)).start } extendTo { val m = p.end.month; (m + (count - m.index % count)).start }

  def label(t: Time, first: Boolean) = {
    val b = new StringBuilder(25)
    b.append(t.month.number).append("\n")
    if (first || t.year > (t - length).year) b.append(t.year)
    b.toString
  }

  override def toString = count + " Months / " + length
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
