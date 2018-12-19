package scalqa; package Idx; package O; package Z; package A

private[scalqa] class Tail[A](protected override val real: O[A], start: Int) extends Idx.Z.A.Tail[A](real, start) with O[A] {

  def onChange(f: Idx[Change[A]] => Any): EventControl = real.onChange(EventControl.moveId1(f, _.all.flatMap[Change[A]](c => {
    c match {
      case c: Add[A] =>
        val r = c.range
        if (size == 0) c.I.~
        else {
          val nr = (r.start - start max 0) <>>+ (r.size min size)
          Add.make(nr, all.letAt(nr).to[Idx]).I.~
        }
      case c: Remove[A] =>
        val r = c.range
        val rmSize = real.size - start + r.size min r.size
        if (rmSize <= 0) \/
        else if (r.start >= start) Remove.make(r move -start, c.items).I.~
        else if (r.end > start) Remove.make(r.size.Range, c.items.all.dropNext(start - r.start).appendAll(real.all.letAt(r.start <>>+ start - r.start)).to[Idx]).I.~
        else Remove.make(rmSize.Range, real.all.letAt(start - r.size <>>+ rmSize).to[Idx]).I.~
      case c: Change.Reposition[A] =>
        val r = c.range
        if (r.start >= start) Change.Reposition.make(r move -start, c.indexes.all.map(_ - start).toPrimitive[Ints]).I.~
        else if (r.end > start) {
          val nr = (r.end - start).Range
          ??? //~[Change[A]] + Remove.make(nr, c.indexes.all.dropNext(r.size - nr.size).map(real(_)).to[Idx]) + Add.make(nr, real.all.letAt(nr move start).to[Idx])
        } else \/
      case c: Refresh[A] =>
        val r = c.range
        r.overlapOpt(start <>> real.size).map(_ move -start).map(r => Refresh.make[A](r))
      case _ => App.Fail.state
    }
  }).I.let(_.prime).apply(a => f(a.to[Idx]))))
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
