package scalqa; package Time

package object Period {
  private[scalqa] def This = this

  def get(start: Time, end: Time)(implicit o: Sorting[Time]) = new Period(start, end)

  def get(r: Range[Time]) = new Period(r.start, r.end)

  def getParse(s: String): Period = Z.format.parse(s)

  def getParse(start: String, end: String): Period = Z.format.parse(start, end)
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
