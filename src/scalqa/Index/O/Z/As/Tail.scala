package scalqa; package Index; package O; package Z; package As

private[scalqa] class Tail[A](protected override val real: O[A], start: Int) extends Index.Z.As.Tail[A](real, start) with O[A] {

  def onChange(f: Coll[Change[A]] => Any): Concurrent.Control = real.onChange(Any.Event.moveId1(f, _.all.flatMap[Change[A]](c => {
    c match {
      case c: O.Add[A] =>
        val r = c.range
        if (size == 0) c.I.~ else ((r.start - start max 0) <>>+ (r.size min size)).I.to(nr => O.Add.get(nr, all.letAt(nr).as[Index])).I.~
      case c: O.Remove[A] =>
        val r = c.range
        (real.size - start + r.size min r.size).I.to(rmSize =>
          if (rmSize <= 0) \/
          else if (r.start >= start) O.Remove.get(r << start, c.items).I.~
          else if (r.end > start) O.Remove.get(r.size.Range, c.items.all.dropFirst(start - r.start).~~(real.all.letAt(r.start <>>+ start - r.start)).as[Index]).I.~
          else O.Remove.get(rmSize.Range, real.all.letAt(start - r.size <>>+ rmSize).as[Index]).I.~)
      case c: O.Reposition[A] =>
        val r = c.range
        if (r.start >= start) O.Reposition.get(r << start, c.indexes.all.map(_ - start).as[Array]).I.~
        else if (r.end > start) (r.end - start).Range.I.to(nr =>
          ~[Change[A]] ~ O.Remove.get(nr, c.indexes.all.dropFirst(r.size - nr.size).map(real(_)).as[Index]) ~ O.Add.get(nr, real.all.letAt(nr >> start).as[Index]))
        else \/
      case c: O.Refresh[A] =>
        val r = c.range
        r.overlapOpt(start <>> real.size).map(_ << start).map(r => O.Refresh.get[A](r))
      case _ => Fail.state()
    }
  }).nonEmptyOpt(a => f(a.as[Coll]))))
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
