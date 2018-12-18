package scalqa; package Stream; package Z; package consume; package convert

private[scalqa] object format {

  def apply[A](src: Flow[A], sepOpt: Opt[String], startOpt: Opt[String], endOpt: Opt[String], converterOpt: Opt[A => String]): String = {
    val b = new StringBuilder

    val start: () => Any = startOpt.map(s => () => b.append(s)) orElse \/
    val end: () => Any = endOpt.map(s => () => b.append(s)) orElse \/
    val sep: () => Any = sepOpt.map(s => () => b.append(s)) orElse \/

    val isList = start.isVoid && end.isVoid && sepOpt.let(_ == ",")

    var first = true

    def write(v: A) {
      if (first) first = false else sep()

      val s = converterOpt.map(_(v)) or v.I.toString

      if (isList && s.indexOf(',') >= 0 && s.indexOf('[') == 0 && !(s.startsWith("(") && s.endsWith(")"))) {
        b.append('[').append(s).append(']')
      } else {
        start()
        b.append(s)
        end()
      }
    }
    src.foreachSynchronized(write)
    b.toString
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
