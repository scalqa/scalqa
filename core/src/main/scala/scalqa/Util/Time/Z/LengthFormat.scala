package scalqa; package Util; package Time; package Z

private[Time] object LengthFormat {

  def apply(tl: Like.Core, brief: Boolean): String = {
    val b = new StringBuilder(20)

    def add(v: Like.Unit[_]) = if (v._is) {
      if (!b.isEmpty) b += ' '
      b append v.format(brief)
    }

    add(tl.totalDays)
    add(tl.subHours)
    add(tl.subMinutes)

    if (!b.isEmpty) b += ' '

    val sec = tl.subSeconds.toLong
    val mil = tl.subMillis
    val mic = tl.subMicros
    val nan = tl.subNanos

    def end = if (brief) "s" else if (sec > 1) " secs" else " sec"

    if (nan._is) {
      b.append(sec).append(".").append(mil.padded).append(mic.padded).append(nan.padded).append(end)
    } else if (mic._is) {
      b.append(sec).append(".").append(mil.padded).append(mic.padded).append(end)
    } else if (mil._is) {
      b.append(sec).append(".").append(mil.padded)
      while (b(b.size - 1) == '0') b.deleteCharAt(b.size - 1)
      b append end
    } else {
      b.append(sec).append(end)
    }
    b.toString
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
