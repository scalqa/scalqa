package scalqa; package Idx; package O; package Z; package A

private[scalqa] class StatefullMap[A, B](protected val _this: O[A], private[Z] val mp: A => B) extends Custom.Proxy.Idx.O.Like[B] {

  protected val real: OM[B] = new OM.A.Basic[B] {
    {
      val t = StatefullMap.this._this
      this +~= t.all.map(mp(_))
      t.onChange(Listener)
    }
    override def onChange(on: Idx[Change[B]] => Any) = { val v = super.onChange(on).onCancelRun(ref); ref; v }

    private def ref: Unit = Listener.hardRef = if (this._isNoEntries) null else StatefullMap.this

  }

  private object Listener extends StatefullMap.AListener[A, B](this)
}

private object StatefullMap {

  // ********************************************************************************************************
  class AListener[A, B](private[A] var hardRef: StatefullMap[A, B]) extends (Idx[Change[A]] => Any) {
    val weak = Any.Ref.Weak(hardRef)
    hardRef = null

    def apply(coll: Idx[Change[A]]) = {
      val real = weak.opt orElse { throw Util.EventControl.CancelException }

      real.real.multiChange(l => coll.all.foreach({
        case c: Add[A]               => c.range.all.zip(c.items.all.map(real.mp(_))).foreach(_(l.addAt))
        case c: Remove[A]            => l.removeAt(c.range)
        case r: Change.Reposition[A] => l.reposition(r)
        case c: Refresh[A]           => real.real.refreshAt(c.range)
        case _                       => App.Fail()
      }))
    }
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
