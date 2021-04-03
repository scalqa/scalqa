package scalqa; package fx; package control; package table; package z; import language.implicitConversions

private[fx] class SortEventHandler[ROW](t: Table[ROW]):
  private var listening = true
  private var oldSortOrder: ><[t.Column[_]] = \/

  private def doSort : Unit = t.rows.sort(using t.sortingBase + t.ordering)

  t.real.setSortPolicy(_ => true)
  t.sortingBase_*.onChangeRun{doSort}
  t.ordering_* .onChangeRun{
    doSort
    if (listening)
      // programmatic change, clear UI sort order
      listening = false; t.real.getSortOrder.clear; listening = true
  }

  t.real.comparatorProperty.addListener(new javafx.beans.InvalidationListener{
    def invalidated(v: javafx.beans.Observable) : Unit =
      if (listening)
        val so = t.sortOrder
        if (so.isEmpty && !t.sortMode_*().isProxyWithUnsorted && !oldSortOrder.isEmpty)
          val c = oldSortOrder.head
          import javafx.scene.control.TableColumn.SortType.*
          c.real.setSortType((c.real.getSortType == DESCENDING) ? ASCENDING or DESCENDING)
          t.sortOrder = oldSortOrder
        else
          oldSortOrder = so
          listening = false
          t.ordering_*() = so.~.map(_.rowOrdering).foldAs(\/ :Ordering[ROW])(_ + _)
          listening = true
  })

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
