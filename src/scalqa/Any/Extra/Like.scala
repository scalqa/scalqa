package scalqa; package Any; package Extra

trait Like {
  private var top: Z.Entry = \/

  @inline private[Extra] def _topEntry = { if (top.isCancelled) synchronized { top = top.child }; top }

  private[Extra] def _addEntry(scope: AnyRef, _target: Any): Concurrent.Control = synchronized {
    val te = _topEntry
    if (scope != Z.Entry.O.Scope && !te.isInstanceOf[Z.Entry.O])
      top = new Z.Entry(te, scope, _target)
    else
      new Z.Entry.O(te, scope, _target).I(v => { top = v; v.init })
    top
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
