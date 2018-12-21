package scalqa; package Fx; package Chart; package Axis; package A; package Numeric; package Z

object GetRange {

  def apply[A](axis: Numeric[A], r: Range[Double], scale: Double, labelSize: Double): Span[Double] = {
    val xr = if (axis.Setup.forceZeroInRange && !r.contains(0)) r.extendTo(0) else r
    val range = xr.end - xr.start; if (range <= 0) return new Span(0, 100, 10, "0")

    val paddedRange = if (range < 2) 2 else range * 1.02
    val tickCount = (scale / labelSize).roundWholeDown.toInt.max(2)

    val pad: (Double, Double) = {
      val bit = (paddedRange - range) / 2
      ({ val v = xr.start; val p = v - bit; if ((p < 0 && v >= 0) || (p > 0 && v <= 0)) 0 else p },
        { val v = xr.end; val p = v + bit; if ((p < 0 && v >= 0) || (p > 0 && v <= 0)) 0 else p })
    }

    var tickUnit: Double = paddedRange / tickCount; var unit = 0D
    var min, max = 0D
    var count = 0
    var reqLength = Double.MaxValue
    var format = "0.00000000";
    while (reqLength > scale || count > 20) {
      var exp = Math.log10(tickUnit).roundWholeDown.toInt
      val ratio: Double = {
        val v = tickUnit / (Math.pow(10, exp))
        if (v > 5) { exp += 1; 1 }
        else if (v > 1) if (v > 2.5) 5 else 2.5
        else v
      }
      format =
        if (exp > 1) "#,##0"
        else if (exp == 1) "0"
        else {
          val b = new StringBuilder(20)
          b.append("0")
          val i = exp.abs
          (if (ratio.isWhole) i else { b += '.'; i + 1 }).all.foreach(_ => b append "0")
          b.toString
        }
      unit = ratio * (Math.pow(10, exp))
      min = (pad._1 / unit).roundWholeDown * unit
      max = (pad._2 / unit).roundWholeUp * unit;
      var maxReqTickGap = 0d
      var last = 0d
      count = 0;
      (min <> max).allStep(_ + unit).foreach(d => {
        val sz = {
          val v = axis.Setup.measureTickMarkLabelSize(axis.Setup.getTickLabelFun(axis.map.undo(d)), axis.real.getTickLabelRotation)
          if (axis.Setup.side.isVertical) v.getHeight / 2 else v.getWidth / 2
        }
        if (d == min) last = sz
        else maxReqTickGap = Math.max(maxReqTickGap, last + 6 + sz)
        count += 1
      })
      reqLength = (count - 1) * maxReqTickGap;
      tickUnit = unit;
      if (tickCount == 2 && reqLength > scale) reqLength = scale
      if (reqLength > scale || count > 20) tickUnit *= 2;
    }
    new Span(min, max, unit, format) //.I(r => ("Out "+ r.I.toString).lp)
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
