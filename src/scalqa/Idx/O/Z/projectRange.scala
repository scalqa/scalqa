package scalqa; package Idx; package O; package Z

private[O] object projectRangeOpt {

  def apply[A](c: Idx[Change[A]], r: Idx.Range): Opt[Idx[Change[A]]] = c.all.letMap {
    case v: Add[A]        => r.overlapOpt(v.range).map(or => Add.make[A](or, v.items.asRangeView(or move -r.start)))
    case v: Remove[A]     => r.overlapOpt(v.range).map(or => Remove.make[A](or, v.items.asRangeView(or move r.start)))
    case v: Refresh[A]    => r.overlapOpt(v.range).map(or => Refresh.make[A](or))
    case v: Reposition[A] => r.overlapOpt(v.range).map(or => Reposition.make[A](or, v.indexes.copy(or)))
    case v                => v
  }.I.let(_.prime).map(_.to[Idx])

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
