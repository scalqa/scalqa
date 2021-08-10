package scalqa; package fx; package scene; package chart; package axis; package x; import time.*; import language.implicitConversions

class Time protected (name: String, bm: ReversibleFunction[Gen.Time, Double]) extends X.Custom[Gen.Time](name, bm):
  def this(name: String = "Time") = this(name, ReversibleFunction(_.real.toDouble, d => Gen.Time.fromIndex(d.toLong)))

  override lazy  val setup: TimeSetup = new TimeSetup

  class TimeSetup extends Setup:
    private  var start            : Gen.Time = \/
    /**/     var timeGauge        : Gauge  = \/
    override def label(t: Gen.Time) : String = timeGauge.label(t, start == t)

    override def scope(timeRange: <>[Gen.Time], totalSize: Double, labelSize: Double): X.Custom.Range[Gen.Time] = {
      var p = Gen.Time.Period(timeRange)
      timeGauge = Gauge.standard_~.find_?(u => p.length.millisTotal / u.length.millisTotal < (totalSize / u.labelSize)) or new z.Gauge.Month(6, 6)
      p = timeGauge.roundPeriod(p)
      start = p.start
      minorTickCount = timeGauge.minorCount
      new X.Custom.Range[Gen.Time](p.start, p.end, timeGauge.length.millisTotal.toDouble, "?")
    }

object Time:
  type Gauge = time.Gauge; transparent inline def Gauge = time.Gauge

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
