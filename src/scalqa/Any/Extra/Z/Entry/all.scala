package scalqa; package Any; package Extra; package Z; package Entry

private[Extra] class all(var en: Z.Entry, scope: AnyRef) extends Pipe.The.Base[Entry] {

  def pumpOpt(lf: Entry => Boolean): Opt[Entry] = {
    if (en.isCancelled) en = en.child
    while (en.isVoid.not) {
      val v = en;
      en = en.child;
      if ((scope == all.AnyScope || scope == v.scope) && lf(v)) return v
    }
    \/
  }
}

private[Extra] object all {

  object AnyScope

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/