package scalqa; package `val`; package idx; package z; import language.implicitConversions

private[idx] object observable:

  def onAdd[A,U](idx: Observable[A], l: A => U) =
    idx.onChange(Event.Id.map1(l,_.stream.foreach {
      case v: Idx.Event.Add[_]                    => v.cast[Idx.Event.Add[A]].items.stream.foreach(l(_))
      case v: Idx.Event.Update[_] if !v.isRefresh => v.cast[Idx.Event.Update[A]].items.stream.foreach(l(_))
      case _                                      => ()
    }))

  def onRemove[A,U](idx: Observable[A], l: A => U) =
    idx.onChange(Event.Id.map1(l, _.stream.foreach {
      case v: Idx.Event.Remove[_]                 => v.cast[Idx.Event.Remove[A]].items.stream.foreach(l(_))
      case v: Idx.Event.Update[_] if !v.isRefresh => v.cast[Idx.Event.Update[A]].oldItems.stream.foreach(l(_))
      case _                                      => ()
    }))

  def removeAll[A](idx: ObservableMutable[A], s: Stream[A]) : Int =
    val set = s.toSet
    val pos = idx.stream.zipIndex.take(_._2 in set).reverse.map(_._1).pack
    idx.modify(m => pos.foreach(v => m.removeAt(v)))
    pos.size

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
