package scalqa; package Util; package Time; package Like; package Core; package A

trait Nanos extends Any with Core {

  @inline def totalNanos: Time.Nanos

  @inline def totalDays = totalNanos.real / Nanos.InOneDay Days

  @inline def totalHours = totalNanos.real / Nanos.InOneHour Hours

  @inline def totalMinutes = totalNanos.real / Nanos.InOneMinute Minutes

  @inline def totalSeconds = totalNanos.real / Nanos.InOneSecond Seconds

  @inline def totalMillis = totalNanos.real / Util.OneMillion Millis

  @inline def totalMicros = totalNanos.real / Util.OneThousand Micros

  @inline override def subMicros = totalMicros % 1000

  @inline override def subNanos = totalNanos % 1000

}

private object Nanos {
  val InOneSecond = 1000L * 1000 * 1000
  val InOneMinute = InOneSecond * 60
  val InOneHour = InOneMinute * 60
  val InOneDay = InOneHour * 24
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
