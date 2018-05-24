package scalqa; package Index; package WO; package Z; package The

private[Index] class WritableWrap[A](protected val real: Index.W[A]) extends WO[A] with Index.The.Proxy.Like[A] with O.The.Base[A] {

  override def addAt(i: Int, a: A) = _change(c => { c.addAt(i); real.addAt(i, a) })

  override def removeAt(r: Int.Range) = if (r.size > 0) _change(c => { c.removeAt(r); real.removeAt(r) })

  override def replaceAt(i: Int, a: A) = _change(c => { c.replaceAt(i); real.replaceAt(i, a) })

  override def reposition(r: Int.Range.Reposition) = if (r.range.size > 0) _change(c => { c.reposition(r); real.reposition(r) })

  override def refreshAt(r: Int.Range) = if (r.size > 0) _change(c => c.refreshAt(r))

  def multiChange(ch: W[A] => Any): Unit = O.Change.Builder.get[A](this).I(c => { ch(new MultiChangeProxy(real, c)); if (c.isEmpty.not) fireChange(c.seal) })

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/