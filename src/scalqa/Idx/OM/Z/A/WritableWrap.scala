package scalqa; package Idx; package OM; package Z; package A

private[Idx] class WritableWrap[A](protected val real: Idx.M[A]) extends OM[A] with Custom.Proxy.Idx.Like[A] with O.A.Base[A] {

  override def addAt(i: Int, a: A) = _change(c => { c.addAt(i); real.addAt(i, a) })

  override def removeAt(r: Idx.Range) = if (r.size > 0) _change(c => { c.removeAt(r); real.removeAt(r) })

  override def update(i: Int, a: A) = _change(c => { c.update(i); real.update(i, a) })

  override def reposition(r: Idx.Range.Reposition) = if (r.range.size > 0) _change(c => { c.reposition(r); real.reposition(r) })

  override def refreshAt(r: Idx.Range) = if (r.size > 0) _change(c => c.refreshAt(r))

  def multiChange(ch: M[A] => Any): Unit = O.Change.Builder.make[A](this).I(c => { ch(new MultiChangeProxy(real, c)); if (!c.isEmpty) fireChange(c.seal) })

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
