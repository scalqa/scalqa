package scalqa; package Fx; package Chart; package Axis; package A; package Numeric; package Z

object GetAllTicks {

  def apply(r: Span[Double]): ~[Double] = {
    val size = r.end - r.start
    val unitCount = size / r.unit
    if (r.isSingularity) r.start.I.~
    else if (r.unit <= 0) r.start ~+ r.end
    else Idx.M.make[Double].I(l => {
      l += r.start
      if (unitCount > 2000)
        System.err.println("Warning we tried to create " + unitCount + " major tick marks for Scale = " + r)
      else
        (if (r.unit.isWhole) r.start.roundWholeUp else r.start + r.unit).<>>(r.end).allStep(_ + r.unit).drop(l.all.contains).foreach(l.add)
      l += r.end
    })
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
