package scalqa; package gen; package time; package z; import language.implicitConversions

import Time.Length

private[time] object formatLength:

  def apply(tl: Length, brief: Boolean): String =
    val b = String.Builder(20)

    def add(v: Long, s: String, ss: String) = if (v != 0)
      if (!b.isEmpty) b += ' '
      b += v
      if (brief) b += ss
      else if (v == 1) b += ' ' += s.dropLast(1)
      else b += ' ' += s

    if (tl.nanosTotal % x.Nanos.InOneWeek == 0)
      add(tl.weeksTotal, "weeks", "w")
    else
      add(tl.daysTotal, "days",  "d")
      add(tl.hours,     "hours", "h")
      add(tl.minutes,   "mins",  "m")

    val sec = tl.seconds
    val mil = tl.millis
    val mic = tl.micros
    val nan = tl.nanos

    def end = if (brief) "s" else if (sec > 1) " secs" else " sec"

    def start = { if (!b.isEmpty) b += ' '; b += sec; b }

    if (!brief || tl.hoursTotal == 0)
      if (nan != 0)
        start += '.' += Z.pad(mil,3) += Z.pad(mic,3) += Z.pad(nan,3) += end
      else if (mic != 0)
        start += '.' += Z.pad(mil,3) += Z.pad(mic,3) += end
      else if (mil != 0)
        start += '.' += Z.pad(mil,3)
        while (b.charAt(b.length - 1) == '0') b.removeAt(b.length - 1)
        b += end
      else if (sec != 0 || b.length == 0)
        start += end
    b.tag

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
