package scalqa; package Index; package O; package Change; package Z

private[O] object projectRange {

  def opt[A](c: Coll[Change[A]], r: Int.Range): Opt[Coll[Change[A]]] = c.all.letMap {
    case v: O.Add[A]        => r.overlapOpt(v.range).map(or => O.Add.get[A](or, v.items.asRanged(or << r.start)))
    case v: O.Remove[A]     => r.overlapOpt(v.range).map(or => O.Remove.get[A](or, v.items.asRanged(or << -r.start)))
    case v: O.Refresh[A]    => r.overlapOpt(v.range).map(or => O.Refresh.get[A](or))
    case v: O.Reposition[A] => r.overlapOpt(v.range).map(or => O.Reposition.get[A](or, v.indexes.copy(or).Ints))
    case v                  => v
  }.nonEmptyOpt.map(_.as[Coll])

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
