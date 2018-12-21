package scalqa; package Fx; package Chart; package Axis; package A; package TimeBased; package Z

class TheYear(count: Int, minor: Int) extends Unit((count * 56).Weeks, minor) {

  def roundPeriod(p: Period) = p extendTo { val y = p.start.year.number; (y - (y % count)).Year.start } extendTo { val y = p.end.year.number; (y + count - (y % count)).Year.start }

  def label(t: Time, first: Boolean): String = t.year.toString

  override def toString = count + " Years / " + length
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
