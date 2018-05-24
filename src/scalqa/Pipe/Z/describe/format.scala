package scalqa; package Pipe; package Z; package describe

private[scalqa] object format {

  def apply[A](stream: Flow[A], sepOpt: Opt[String], startOpt: Opt[String], endOpt: Opt[String], converterOpt: Opt[A => String]): String = String.Builder.get().I(b => {
    val start: () => Any = startOpt.map(s => () => b =+ s) orElse \/
    val end: () => Any = endOpt.map(s => () => b =+ s) orElse \/
    val sep: () => Any = sepOpt.map(s => () => b =+ s) orElse \/

    val isList = start.isVoid && end.isVoid && sepOpt.letOnly(",")

    var first = true

    stream.synchronize.apply(v => {
      if (first) first = false else sep()
      val s = converterOpt.map(_(v)) or v.I.toString
      if (isList && s.indexOf(',') >= 0 && !(s.startsWith("(") && s.endsWith(")"))) {
        b =+ '[' =+ s =+ ']'
      } else {
        start();
        b =+ s
        end()
      }
    })
  })
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
