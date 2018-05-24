package scalqa; package Index; package O; package Z; package The; package OrderedProxy

private[scalqa] class _Class[A] private (private var _sorting: Sorting[A], private var _target: O[A]) extends Entry.IndexBase[A] with O.The.Base[A] {
  def this(_target: O[A] = \/)(implicit o: Sorting[A] = \/) = { this(o, _target); _prepareTarget(_target) }
  private val listener = new Listener(Opt.Weak.get(this))
  protected[OrderedProxy] val entryIndex = Index.W.get[Entry[A]]

  def ordered: Boolean = sorting.isVoid.not

  def sorting: Sorting[A] = _sorting

  def sorting_=(o: Sorting[A]): Unit = if (_sorting != o) {
    _sorting = o
    val r = Int.Range.Reposition.getBySorting(entryIndex)(_entrySorting)
    //    r.tp
    //    entryIndex.all.tp
    entryIndex.reposition(r);
    //    entryIndex.all.tp
    fireChange(O.Reposition.get(r).I.~.to[Coll])
  }

  def target: O[A] = _target

  def target_=(t: O[A]): Unit = if (_target != t) {
    var cngs = ~[Change[A]]
    if (_target.isEmpty.not) cngs ~= O.Remove.get(_target.size.Range, _target)
    _target = t
    entryIndex.clear
    _prepareTarget(t)
    if (size > 0) cngs ~= O.Add.get(entryIndex.size.Range, this)
    fireChange(cngs.to[Index])
  }

  // -------------------------------------------------------------------------------------------
  private def _prepareTarget(t: O[A]) = if (t.isVoid.not) {
    entryIndex =+~ t.all.mapIdx(new Entry(_, _))
    if (sorting.isVoid.not) entryIndex.sort(_entrySorting)
    t.onChange(listener).cancelIf(() => _target != t)
  }

  private[OrderedProxy] def _entrySorting: Sorting[Entry[A]] = sorting.asMap[Entry[A]](_.value) join Entry.indexSorting

  private[OrderedProxy] def _fireChanges(c: Coll[Change[A]]): Unit = fireChange(c)
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/