package scalqa; package Index; package O; package Z; package The; package OrderedProxy

private[scalqa] class Listener[A](o: Opt.Weak[OrderedProxy[A]]) extends (Coll[Change[A]] => Any) {

  def apply(cc: Coll[Change[A]]) = synchronized {
    val list = o orElse { throw Any.Event.CancelException }

    def cnvrt(v: Change[A]): ~[Change[A]] = {
      val rng = v.indexRange
      def entries = list.entryIndex
      def reindex(dif: Int): Unit = entries.all.let(_.index >= rng.start).apply(_.index += dif)
      def allEntries(items: ~[A]): ~[(Entry[A], Int)] = items.mapIdx(new Entry(_, _), rng.start).zipMap(e => if (list.ordered) entries.searchOrdered(e)(list._entrySorting).start else e.index)
      v match {
        case c: O.Reposition[A] =>
          entries.all.letBy(_.index, c.range).apply(e => e.index = c.apply(e.index))
          \/
        case c: O.Add[A] =>
          reindex(c.range.size);
          allEntries(c.items).map(_.to((entry, pos) => { entries.addAt(pos, entry); O.Add.get(pos, entry.value) }))
        case c: O.Remove[A] =>
          if (rng == entries.size.Range) O.Remove.get(rng, entries.all.map(_.value).to[Index]).I.run(entries.clear).I.~
          else if (!list.ordered) { entries.removeAt(rng); c.I.~ }
          else allEntries(c.items)
            .map(_.to((e, i) => entries.opt(i).contains(e) ? (i, entries.all.findIdxOpt(_ == e).or(Fail("Could not find: " + e)))))
            .sort
            .reverse
            .map(i => O.Remove.get(i, entries(i).value).I(c => entries.removeAt(c.range)))
            .to[Index].all.I.run(reindex(-rng.size))
        case _ => Fail()
      }
    }
    list._fireChanges(cc.all.flatMap(cnvrt).to[Coll])
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
