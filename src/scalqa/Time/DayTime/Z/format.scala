package scalqa; package Time; package DayTime; package Z

private[DayTime] object format {

  def apply(t: DayTime, fullSize: Boolean, separator: Char = ':'): String = {
    String.Builder.get(25).I(sb => {
      sb =+ t.subHours.value =+ separator =+ t.subMinutes.toPaddedString
      val s = t.subSeconds; val ms = t.subMillis
      if (fullSize && (s > 0 || ms > 0)) {
        sb =+ separator =+ s.toPaddedString
        if (ms > 0) sb =+ '.' =+ ms.toPaddedString
      }
    })
  }

  def parse(s: String): DayTime = s.length.I.to(l => {
    val i = s.indexOf(":") ? (_ < 0, _ => l, i => i)
    def p(r: Int.Range) = if (r.end <= l) s.copy(r).toInt else 0
    Time.DayTime.get(p(0 <>> i),
      p(i + 1 <>> i + 2),
      p(i + 4 <>> i + 5),
      {
        val j = i + 7
        if (j >= l) 0
        else if (j + 2 < l) p(j <>> j + 2)
        else if (j + 1 < l) p(j <>> j + 1) * 10
        else p(j <>!) * 100
      })
  })
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
