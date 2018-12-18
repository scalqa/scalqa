package scalqa; package Util; package Time; package Z

private[Util] object DayTimeFormat {

  def apply(t: DayTime, fullSize: Boolean, separator: Char = ':'): String = {
    val sb = new StringBuilder(25)
    sb append t.subHours.padded append separator append t.subMinutes.padded
    val s = t.subSeconds; val ms = t.subMillis
    if (fullSize && (s > 0 || ms > 0)) {
      sb append separator append s.padded
      if (ms > 0) sb append '.' append ms.padded
    }
    sb.toString
  }

  def parse(s: String): DayTime = {
    val l = s.length
    val i = { val i = s.indexOf(":"); if (i < 0) l else i }
    def p(r: Idx.Range): Int = if (r.end <= l) s.copy(r).toInt else 0
    DayTime.make(p(0 <>> i).Hours,
      p(i + 1 <>> i + 2).Minutes,
      p(i + 4 <>> i + 5).Seconds,
      {
        val j = i + 7
        if (j >= l) 0
        else if (j + 2 < l) p(j <>> j + 2)
        else if (j + 1 < l) p(j <>> j + 1) * 10
        else p(j <>!) * 100
      }.Millis)
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
