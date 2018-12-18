package scalqa; package Idx; package OM; package A

class Basic[A](initSize: Int = \/) extends O.A.Base[A] with OM[A] with Custom.Proxy.Idx.Like[A] {
  protected val real = new Array.Buffer.Refs[A](initSize)

  override def add(a: A) = _change(c => { c.addAt(size); real.add(a) })

  override def addAll(s: ~[A]) = addAllAt(size, s)

  override def addAt(i: Int, a: A) = _change(c => { c.addAt(i); real.addAt(i, a) })

  override def addAllAt(i: Int, s: ~[A]) = if (s.prime) _change(c => { val sz = size; real.addAllAt(i, s); c.addAt(i <>>+ size - sz) })

  override def removeAt(r: Idx.Range) = if (r.size > 0) _change(c => { c.removeAt(r); real.removeAt(r) })

  override def update(i: Int, a: A) = _change(c => { c.update(i); real.update(i, a) })

  override def refreshAt(r: Idx.Range) = if (r.size > 0) _change(c => { c.refreshAt(r); real.refreshAt(r) })

  override def reposition(r: Idx.Range.Reposition) = if (r.range.size > 0) _change(c => { c.reposition(r); super.reposition(r) })

  override def order(o: Ordering[A]) = {
    val r = Idx.Range.Reposition.fromOrdering(this)(o)
    if (r.range.size > 0) _change(c => { c.reposition(r); real.reposition(r) })
  }

  def multiChange(ch: M[A] => Any): Unit = O.Change.Builder.make[A](this).I(c => {
    ch(new Custom.Proxy.Idx[A](this) with M[A] {
      def addAt(i: Int, a: A) = { c.addAt(i); Basic.this.real.addAt(i, a) }
      def removeAt(r: Idx.Range) = if (r.size > 0) { c.removeAt(r); Basic.this.real.removeAt(r) }
      def update(i: Int, a: A) = { c.update(i); Basic.this.real.update(i, a) }
      override def reposition(r: Idx.Range.Reposition) = if (r.range.size > 0) { c.reposition(r); Basic.this.real.reposition(r) }
    })
    if (!c.isEmpty) fireChange(c.seal)
  })
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
