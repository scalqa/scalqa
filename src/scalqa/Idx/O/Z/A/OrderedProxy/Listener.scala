package scalqa; package Idx; package O; package Z; package A; package OrderedProxy

private[scalqa] class Listener[A](r: Any.Ref.Weak[OrderedProxy[A]]) extends (Idx[Change[A]] => Any) {

  def apply(cc: Idx[Change[A]]) = synchronized {
    val list = r.opt orElse { throw Util.EventControl.CancelException }

    def cnvrt(v: Change[A]): ~[Change[A]] = {
      val rng = v.range
      def entries = list.entryIndex
      def reindex(dif: Int): Unit = entries.all.let(_.index >= rng.start).foreach(_.index += dif)
      def allEntries(items: ~[A]): ~[(Entry[A], Int)] = items.mapIdx(new Entry(_, _), rng.start).zipMap(e => if (list.ordered) entries.searchOrdered(e)(list._entryOrdering).start else e.index)
      v match {
        case c: Change.Reposition[A] =>
          entries.all.letBy(_.index, c.range).foreach(e => e.index = c.apply(e.index))
          \/
        case c: Add[A] =>
          reindex(c.range.size);
          allEntries(c.items).map(_.to((entry, pos) => { entries.addAt(pos, entry); Add.make(pos, entry.value) }))
        case c: Remove[A] =>
          if (rng == entries.size.Range) { val v = Remove.make(rng, entries.all.map(_.value).to[Idx]); entries.clear; v.I.~ }
          else if (!list.ordered) { entries.removeAt(rng); c.I.~ }
          else allEntries(c.items)
            .map(_.to((e, i) => if (entries.getOpt(i).contains(e)) i else entries.all.findIdxOpt(_ == e).or(App.Fail("Could not find: " + e))))
            .sort
            .reverse
            .map(i => Remove.make(i, entries(i).value).I(c => entries.removeAt(c.range)))
            .to[Idx].all.I(_ => reindex(-rng.size))
        case _ => App.Fail()
      }
    }
    list._fireChanges(cc.all.flatMap(cnvrt).to[Idx])
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
