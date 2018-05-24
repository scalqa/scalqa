package scalqa; package Index; package WO; package Z; package The

private[Index] class MultiChangeProxy[A](protected val real: W[A], c: O.Change.Builder[A]) extends Index.The.Proxy.Like[A] with W[A] {

  def addAt(i: Int, a: A) = { c.addAt(i); real.addAt(i, a) }

  def removeAt(r: Int.Range) = if (r.size > 0) { c.removeAt(r); real.removeAt(r) }

  def replaceAt(i: Int, a: A) = { c.replaceAt(i); real.replaceAt(i, a) }

  override def reposition(r: Int.Range.Reposition) = if (r.range.size > 0) { c.reposition(r); real.reposition(r) }

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/