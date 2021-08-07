package scalqa; package fx; package scene; package chart; package axis; package x; package custom; package z; import language.implicitConversions

object calcScope:

  def apply[A](axis: X.Custom[A], r: <>[Double], scale: Double, labelSize: Double): Range[Double] =
    val xr = if (axis.setup.forceZeroInRange && !r.contains(0)) r join 0 else r
    val range = xr.end - xr.start; if (range <= 0) return new Range(0, 100, 10, "0")

    val paddedRange = if (range < 2) 2 else range * 1.02
    val tickCount = Math.floor(scale / labelSize).toInt.max(2)

    val pad: (Double, Double) =
      val bit = (paddedRange - range) / 2
      ({ val v = xr.start; val p = v - bit; if ((p < 0 && v >= 0) || (p > 0 && v <= 0)) 0 else p },
        { val v = xr.end; val p = v + bit; if ((p < 0 && v >= 0) || (p > 0 && v <= 0)) 0 else p })

    var tickUnit: Double = paddedRange / tickCount; var unit = 0D
    var min, max = 0D
    var count = 0
    var reqLength: Double = MAX
    var format = "0.00000000";
    while (reqLength > scale || count > 20) {
      var exp = Math.floor(Math.log10(tickUnit)).toInt
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
          val b = String.Builder(20)
          b += "0"
          val i = exp.abs
          (0 <>> (ratio.isWhole ? i or { b += '.'; i + 1 })).foreach(_ => b += "0")
          b.toString
        }
      unit = ratio * (Math.pow(10, exp))
      min = Math.floor(pad._1 / unit) * unit
      max = Math.ceil(pad._2 / unit) * unit;
      var maxReqTickGap = 0d
      var last = 0d
      count = 0;
      (min <> max).step_~(_ + unit).foreach(d => {
        val sz = {
          val v = axis.setup.labelSize(axis.setup.label(axis.map.undo(d)), axis.real.getTickLabelRotation)
          if (axis.setup.side.isVertical) v.getHeight / 2 else v.getWidth / 2
        }
        if (d == min) last = sz
        else maxReqTickGap = maxReqTickGap.max(last + 6 + sz)
        count += 1
      })
      reqLength = (count - 1) * maxReqTickGap;
      tickUnit = unit;
      if (tickCount == 2 && reqLength > scale) reqLength = scale
      if (reqLength > scale || count > 20) tickUnit *= 2;
    }
    new Range(min, max, unit, format) //(r => ("Result "+ r).TP)
/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
