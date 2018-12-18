package scalqa; package Idx; package OM; package Z; package A

private[Idx] class MultiChangeProxy[A](protected val real: M[A], c: O.Change.Builder[A]) extends Custom.Proxy.Idx.Like[A] with M[A] {

  def addAt(i: Int, a: A) = { c.addAt(i); real.addAt(i, a) }

  def removeAt(r: Idx.Range) = if (r.size > 0) { c.removeAt(r); real.removeAt(r) }

  def update(i: Int, a: A) = { c.update(i); real.update(i, a) }

  override def reposition(r: Idx.Range.Reposition) = if (r.range.size > 0) { c.reposition(r); real.reposition(r) }

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
