package scalqa; package Fx; package Chart; package Axis; package A; package Numeric; package Z

object GetAllMinorTicks {

  def apply(r: Span[Double], minorTickCount: Int): ~[Double] = {
    import r._
    if (unit <= 0) return \/

    val size = end - start

    val minorUnit = unit / (minorTickCount max 1)

    if (size / minorUnit > 10000) App.Fail("Warning we tried to create more than 10000 minor tick marks: " + r)

    ~[Double] +~
      (if (!unit.isWhole) \/ else ((start.roundWholeDown + minorUnit).<>>(start.roundWholeUp).allStep(_ + minorUnit).let(_ > start))) +~
      (if(unit.isWhole) start.roundWholeUp else start).<>>(end).allStep(_ + unit).flatMap(u => (u + minorUnit <>> end.min(u + unit)).allStep(_ + minorUnit))
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
