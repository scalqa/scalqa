package scalqa; package Fx; package Chart; package Axis; package A; package TimeBased; package Z

abstract class Unit(val length: Duration, val minorCount: Int) {

  def labelSize = 30

  def roundPeriod(p: Period): Period

  def label(t: Time, first: Boolean): String

  override def toString = length.toString
}

object Unit extends Util.Void.Setup[Unit](new The(1.Day, 4) with Void) {

  private lazy val list: Idx[Unit] = Refs.*(
    new The(1.Millis, 10), new The(5.Millis, 5), new The(25.Millis, 5), new The(100.Millis, 10), new The(250.Millis, 5), new The(500.Millis, 5),
    new The(1.Second, 10), new The(2.Seconds, 2), new The(5.Seconds, 5), new The(10.Seconds, 10), new The(15.Seconds, 3), new The(30.Seconds, 6),
    new The(1.Minute, 6), new The(2.Minutes, 2), new The(5.Minutes, 5), new The(10.Minutes, 10), new The(15.Minutes, 3), new The(30.Minutes, 6),
    new The(1.Hour, 6), new The(2.Hours, 1), new The(4.Hours, 4), new The(6.Hours, 6), new The(12.Hours, 4),
    new The(1.Day, 4), new The(2.Days, 2), new The(3.Days, 3), new The(5.Days, 5), new The(10.Day, 10), new The(15.Days, 3),
    new TheMonth(1, 3), new TheMonth(2, 2), new TheMonth(3, 3), new TheMonth(4, 4), new TheMonth(6, 6),
    new TheYear(1, 12), new TheYear(2, 2), new TheYear(5, 5), new TheYear(10, 10), new TheYear(25, 5), new TheYear(100, 10), new TheYear(250, 5), new TheYear(1000, 10))

  def all: ~[Unit] = list.all
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
