package scalqa; package Util; package Time; package Like; package Core; package A

trait Millis extends Any with Core {

  def totalMillis: Time.Millis

  @inline final def totalDays = totalMillis.real / Z.MillisInOneDay Days

  @inline final def totalHours = totalMillis.real / Z.MillisInOneHour Hours

  @inline final def totalMinutes = totalMillis.real / Z.MillisInOneMinute Minutes

  @inline final def totalSeconds = totalMillis.real / Z.MillisInOneSecond Seconds

  @inline private[Time] def totalMicros = totalMillis.real * 1000 Micros

  @inline private[Time] def totalNanos = totalMillis.real * 1000000 Nanos

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
