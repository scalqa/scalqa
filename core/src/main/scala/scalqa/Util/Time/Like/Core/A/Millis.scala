package scalqa; package Util; package Time; package Like; package Core; package A

trait Millis extends Any with Core {

  def totalMillis: Time.Millis

  def totalDays = totalMillis.real / Z.MillisInOneDay Days

  def totalHours = totalMillis.real / Z.MillisInOneHour Hours

  def totalMinutes = totalMillis.real / Z.MillisInOneMinute Minutes

  def totalSeconds = totalMillis.real / Z.MillisInOneSecond Seconds

  private[Time] def totalMicros = totalMillis.real * 1000 Micros

  private[Time] def totalNanos = totalMillis.real * 1000000 Nanos

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
