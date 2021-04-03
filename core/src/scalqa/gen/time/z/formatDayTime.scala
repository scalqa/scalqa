package scalqa; package gen; package time; package z; import language.implicitConversions

private[time] object formatDayTime:

  def apply(t: DayTime, fullSize: Boolean, separator: Char = ':'): String = String.Builder(25).^(b =>{
    b += Z.pad(t.hours,2) += separator += Z.pad(t.minutes,2) += separator += Z.pad(t.seconds,2)
    val ms = t.millis
    if (fullSize && ms > 0) b += '.' += Z.pad(ms,3)
  }).tag

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
