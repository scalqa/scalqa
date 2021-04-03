package scalqa; package fx; package control; package table; package z; package idxProxy; import language.implicitConversions

private[z] transparent trait _Listener[A]:
  self: IdxProxy[A] =>

  protected val listener: ><[Idx.O.Event[A]] => Any = cc => synchronized {
    def cnvrt(v:  Idx.O.Event[A]): ~[Idx.O.Event[A]] = {
      val r = v.range
      def reindex(dif: Int): Unit = entries.~.take(_.index >= r.start).foreach(_.index += dif)
      def row_?(items: ~[A]): ~[(Entry[A], Int)] = {var i=r.start-1; items.map(v => new Entry({i+=1; i}, v)).zipValue(e => if (ordered) entries.orderedSearch(e)(using _rowOrdering).start else e.index) }
      v match
        case c: Idx.Event.Reposition[A] =>
          entries.~.take(v => c.range.contains(v.index)).foreach(e => e.index = c.permutation.mutate(e.index))
          \/
        case c: Idx.Event.Add[A] =>
          reindex(c.range.size);
          row_?(c.items).map(t => {
            val (row, pos) = t
            entries.addAt(pos, row);
            Idx.Event.Add(pos, row.value)
          })
        case c: Idx.Event.Remove[A] =>
          if (r == 0 <>> entries.size) { val v =  Idx.Event.Remove(r, entries.~.map(_.value).><); entries.clear; ~~(v) }
          else if (!ordered) { entries.remove_<>(r); ~~(c) }
          else
            val s = row_?(c.items)
              .map(t => {
                val (e, i) = t
                if (entries.at_?(i).contains(e)) i else entries.~.findPosition_?(_ == e).or(J.illegalState("Could not find: " + e))
              })
              .sort
              .reverse
              .map(i => { val c =  Idx.Event.Remove(i, entries(i).value); entries.remove_<>(c.range); c })
              .><
            reindex(-r.size)
            s
        case _ => J.illegalState()
    }
    fireChange(cc.~.flatMap(cnvrt).><)
  }

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
