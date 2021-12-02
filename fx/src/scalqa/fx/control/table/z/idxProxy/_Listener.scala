package scalqa; package fx; package control; package table; package z; package idxProxy; import language.implicitConversions

private[z] transparent trait _Listener[A]:
  self: IdxProxy[A] =>

  protected val listener: Pack[Idx.O.Event[A]] => Any = cc => synchronized {
    def cnvrt(v:  Idx.O.Event[A]): Stream[Idx.O.Event[A]] = {
      val r = v.range
      def reindex(dif: Int): Unit = entries.stream.take(_.index >= r.start).foreach(_.index += dif)
      def rowOpt(items: Stream[A]): Stream[(Entry[A], Int)] = {var i=r.start-1; items.map(v => new Entry({i+=1; i}, v)).zipValue(e => if (ordered) entries.orderedSearch(e)(using _rowOrdering).start else e.index) }
      v match
        case c: Idx.Event.Reposition[A] =>
          entries.stream.take(v => c.range.contains(v.index)).foreach(e => e.index = c.permutation.position(e.index))
          VOID
        case c: Idx.Event.Add[A] =>
          reindex(c.range.size);
          rowOpt(c.items).map(t => {
            val (row, pos) = t
            entries.addAt(pos, row);
            Idx.Event.Add(pos, row.value)
          })
        case c: Idx.Event.Remove[A] =>
          if (r == 0 <>> entries.size) { val v =  Idx.Event.Remove(r, entries.stream.map(_.value).pack); entries.clear; v.self.stream }
          else if (!ordered) { entries.removeRange(r); c.self.stream }
          else
            val s = rowOpt(c.items)
              .map(t => {
                val (e, i) = t
                if (entries.applyOpt(i).contains(e)) i else entries.stream.findPositionOpt(_ == e).or(J.illegalState("Could not find: " + e))
              })
              .sort
              .reverse
              .map(i => { val c =  Idx.Event.Remove(i, entries(i).value); entries.removeRange(c.range); c })
              .pack
            reindex(-r.size)
            s
        case _ => J.illegalState()
    }
    fireChange(cc.stream.flatMap(cnvrt).pack)
  }

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
