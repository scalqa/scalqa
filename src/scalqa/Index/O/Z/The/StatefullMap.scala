package scalqa; package Index; package O; package Z; package The

private[scalqa] class StatefullMap[A, B](protected val _target: O[A], private[Z] val mp: A => B) extends O.The.Proxy.Like[B] {

  protected val real: WO[B] = new WO.The[B] {
    (this: W[B]) =+~ _target.all.map(mp)
    _target.onChange(Listener)

    override def onChange(on: Coll[Index.O.Change[B]] => Any) = super.onChange(on).onCancelRun(ref).I.run(ref)

    private def ref: Unit = Listener.hardRef = if (this._isNoEntries) null else StatefullMap.this

  }

  private object Listener extends StatefullMap_Listener(this)
  private[Z] def zReal = real
}

// ********************************************************************************************************
private class StatefullMap_Listener[A, B](var hardRef: StatefullMap[A, B]) extends (Coll[Change[A]] => Any) {
  val weakOpt = Opt.Weak.get(hardRef)
  hardRef = null

  def apply(coll: Coll[Change[A]]) {
    val This = weakOpt orElse { throw Any.Event.CancelException }

    This.zReal.multiChange(l => coll.all({
      case c: O.Add[A]        => c.range.all.zipOnly(c.items.all.map(This.mp)).apply(_(l.addAt))
      case c: O.Remove[A]     => l.removeAt(c.range)
      case r: O.Reposition[A] => l.reposition(r)
      case c: O.Refresh[A]    => This.zReal.refreshAt(c.range)
      case _                  => Fail()
    }))
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
