package scalqa; package Fx; package Chart; package Axis; package A; package TimeBased

class _Class protected (name: String, bm: BiMap[Time, Double]) extends Fx.Chart.Axis.A.Numeric[Time](name, bm) {
  def this(name: String = "Time") = this(name, BiMap(_.totalMillis.toDouble, d => Time.fromMillis(d.toLong)))

  private var period: Period = \/

  private var unit: Z.Unit = \/

  Setup.getRangeFun = (timeRange, scaleSize, labelSize) => {
    val p = Period.make(timeRange)
    unit = Z.Unit.all.findOpt(u => p.duration.totalMillis / u.length.totalMillis < (scaleSize / u.labelSize)) or new Z.TheMonth(6, 6)
    period = unit.roundPeriod(p)
    minorTickCount = unit.minorCount
    new Numeric.Span[Time](period.start, period.end, unit.length.totalMillis.toDouble, "?")
  }

  Setup.getTickLabelFun = t => unit.label(t, period.start == t)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
