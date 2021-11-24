package scalqa; package fx; package scene; package chart; package axis; package x; package time; import language.implicitConversions

import Gen.Time

abstract class Gauge(val length: Time.Length, val minorCount: Int) extends Able.Tag:
  def roundPeriod(p: Time.Period)    : Time.Period
  def label(t: Time, first: Boolean) : String
  def labelSize                      : Int           = 30

object Gauge extends Gen.Void.Setup[Gauge](new z.Gauge(1.Day, 4) with Gen.Void):
  def apply(tl: Time.Length, minorCount: Int) : Gauge         = new z.Gauge(tl, minorCount)
  def months(months: Int, minorCount: Int)    : Gauge         = new z.Gauge.Month(months, minorCount)
  def years(years: Int, minorCount: Int)      : Gauge         = new z.Gauge.Year(years, minorCount)
  def standardStream                          : Stream[Gauge] = standards.stream

  private lazy  val standards: Pack[Gauge] = Pack(
    Gauge(1.Millis, 10), Gauge(5.Millis, 5),  Gauge(25.Millis, 5), Gauge(100.Millis, 10), Gauge(250.Millis, 5), Gauge(500.Millis, 5),
    Gauge(1.Second, 10), Gauge(2.Seconds, 2), Gauge(5.Seconds, 5), Gauge(10.Seconds, 10), Gauge(15.Seconds, 3), Gauge(30.Seconds, 6),
    Gauge(1.Minute, 6),  Gauge(2.Minutes, 2), Gauge(5.Minutes, 5), Gauge(10.Minutes, 10), Gauge(15.Minutes, 3), Gauge(30.Minutes, 6),
    Gauge(1.Hour, 6),    Gauge(2.Hours, 1),   Gauge(4.Hours, 4),   Gauge(6.Hours, 6),     Gauge(12.Hours, 4),
    Gauge(1.Day, 4),     Gauge(2.Days, 2),    Gauge(3.Days, 3),    Gauge(5.Days, 5),      Gauge(10.Day, 10),    Gauge(15.Days, 3),
    months(1, 3), months(2, 2), months(3, 3), months(4, 4),  months(6, 6),
    years(1, 12), years(2, 2),  years(5, 5),  years(10, 10), years(25, 5), years(100, 10), years(250, 5), years(1000, 10))

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
