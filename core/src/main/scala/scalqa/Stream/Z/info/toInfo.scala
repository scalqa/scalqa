package scalqa; package Stream; package Z; package info

private[Stream] object toInfo {

  def apply[A](v: Flow[A]): Pro.Info = {
    val tg = new Pro.Info(v)

    val id = v.I.Class.toString
    if (id.startsWith("scalqa.")) tg.id = id.copyFrom(7)

    v.ilkOpt(v => tg.add(("ilk", v)))
    v.sizeOpt(v => tg.add(("size", v)))

    if (v.isInstanceOf[Stream.A.Specialized.Indexed[_]]) tg add (("", "indexed"))

    v match {
      case v: Stream[A] =>
        v.sortedOpt(v => tg.add(("sorted", v.I.toString)))
        v.sortedByOpt((t: (Ordering[_], Any)) => tg += (("sortedBy", t._1)) += (("sortedByFunction", t._2)))
        tg += (("chainDepth", v.chainDepth))
    }
    tg
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
