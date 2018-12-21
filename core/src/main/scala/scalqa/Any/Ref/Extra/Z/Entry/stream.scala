package scalqa; package Any; package Ref; package Extra; package Z; package Entry

private[Extra] object stream {

  object AnyScope

  def apply(ze: Z.Entry, scope: AnyRef) = new Stream.A.Base[Entry] {
    var en: Z.Entry = ze

    def prime: Boolean = {
      while (!en.isVoid) {
        if (!en.isCancelled && (scope == AnyScope || scope == en.scope)) return true
        en = en.child
      }
      false
    }

    def pump = { val v = en; en = en.child; v }

    override def foreach(c: Stream.Consumer[Entry]): Unit = while (!en.isVoid) {
      if (!en.isCancelled && (scope == AnyScope || scope == en.scope)) c.accept(en)
      en = en.child
    }
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
