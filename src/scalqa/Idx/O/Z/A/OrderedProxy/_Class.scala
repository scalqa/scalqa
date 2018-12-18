package scalqa; package Idx; package O; package Z; package A; package OrderedProxy

private[scalqa] class _Class[A] private (private var order: Ordering[A], private var real: O[A]) extends Entry.IndexBase[A] with O.A.Base[A] {
  def this(real: O[A] = \/)(implicit o: Ordering[A] = \/) = { this(o, real); _prepareTarget(real) }
  private val listener = new Listener(Any.Ref.Weak(this))
  protected[OrderedProxy] val entryIndex: Idx.M[Entry[A]] = NEW

  def ordered: Boolean = !ordering.isVoid

  def ordering: Ordering[A] = order

  def ordering_=(o: Ordering[A]): Unit = if (order != o) {
    order = o
    val r = Idx.Range.Reposition.fromOrdering(entryIndex)(_entryOrdering)
    entryIndex.reposition(r);
    fireChange(Reposition.make(r).I.to[Idx])
  }

  def target: O[A] = real

  def target_=(t: O[A]): Unit = if (real != t) {
    ???
    //    var cngs = ~[Change[A]]
    //    if (!real.isEmpty) cngs ~= Remove.make(real.size.Range, real)
    //    real = t
    //    entryIndex.clear
    //    _prepareTarget(t)
    //    if (size > 0) cngs ~= Add.make(entryIndex.size.Range, this)
    //    fireChange(cngs.to[Idx])
  }

  // -------------------------------------------------------------------------------------------
  private def _prepareTarget(t: O[A]) = if (!t.isVoid) {
    entryIndex +~= t.all.mapIdx(new Entry(_, _))
    if (!ordering.isVoid) entryIndex.sort(_entryOrdering)
    t.onChange(listener).cancelIf(() => real != t)
  }

  private[OrderedProxy] def _entryOrdering: Ordering[Entry[A]] = ordering.on[Entry[A]](_.value) + Entry.indexSorting

  private[OrderedProxy] def _fireChanges(c: Idx[Change[A]]): Unit = fireChange(c)
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
