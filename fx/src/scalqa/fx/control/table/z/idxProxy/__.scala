package scalqa; package fx; package control; package table; package z; import idxProxy.*; import language.implicitConversions

private[fx] class IdxProxy[A] private (private var order: Ordering[A], private var real:  Idx.OM[A]) extends Entry.IndexBase[A] with Idx.O.X.Base[A] with Idx.OM[A] with _Listener[A]:
  def this(real: Idx.OM[A] = Idx.OM.void)(using o: Ordering[A] = \/) = { this(o, real); _prepareTarget(real) }
  val entries = Idx.M[Entry[A]]()

  def ordered                           : Boolean     = ordering.nonVoid
  def ordering                          : Ordering[A] = order
  def ordering_=(o: Ordering[A])        : Unit        = if (order != o) {
    /**/                                                   order = o
    /**/                                                   val r = Idx.Permutation.sorting(entries)(using _rowOrdering)
    /**/                                                   entries.reposition(r);
    /**/                                                   fireChange(Idx.Event.Reposition(r).self.pack)
    /**/                                                }
  def target                            : Idx.OM[A]   = real
  def target_=(t:  Idx.OM[A])           : Unit        = if (real != t) {
    /**/                                                    var cngs: Pack[Idx.O.Event[A]] = \/
    /**/                                                    if (!real.isEmpty) cngs +=  Idx.Event.Remove(0 <>> real.size, real)
    /**/                                                    real = t
    /**/                                                    entries.clear
    /**/                                                    _prepareTarget(t)
    /**/                                                    if (size > 0) cngs +=  Idx.Event.Add(0 <>> entries.size, this)
    /**/                                                    fireChange(cngs)
    /**/                                                }
  def refreshRange(r: Int.Range)        : Unit = target.modify(t => entries.stream.takeRange(r).map(_.index).foreach(i => t(i) = t(i)))
  def modify(ch:  Idx.M[A] => Unit)     : Unit = target.modify(tl => ch(new Entry.IndexBase[A] {
    /**/                                                    def entries = IdxProxy.this.entries
    /**/                                                    def target  = tl
    /**/                                                    def modify(ch:  Idx.M[A] => Unit): Unit = ch(this)
    /**/                                                }))
  override def sort(using o: Ordering[A]): Unit       = ordering = o

  // -------------------------------------------------------------------------------------------
  private def _prepareTarget(t:  Idx.O[A]) = if (t.nonVoid)
    entries ++= t.stream.zipIndex.map(Entry(_, _))
    if (ordering.nonVoid) entries.sort(using _rowOrdering)
    t.onChange(listener).cancelIf(() => real != t)

  private[z] def _rowOrdering: Ordering[Entry[A]] = ordering.on[Entry[A]](_.value) + Entry.indexSorting

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
