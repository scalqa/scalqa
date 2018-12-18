package scalqa; package Any; package Ref; package Extra

trait Observable extends Like {

  protected def _onAddEntry(scope: AnyRef, on: Entry => Any): App.Event = _addEntry(Z.Entry.O.Scope, new Z.Entry.O.Listener(scope, Z.Entry.O.Action.Add, on))

  protected def _onRemoveEntry(scope: AnyRef, on: Entry => Any): App.Event = _addEntry(Z.Entry.O.Scope, new Z.Entry.O.Listener(scope, Z.Entry.O.Action.Remove, on))

  protected def _onAddFirstEntryRun(scope: AnyRef, on: => Any): App.Event = _onAddEntry(scope, e => if (_topEntry.all(scope).count == 1) on)

  protected def _onRemoveLastEntryRun(scope: AnyRef, on: => Any): App.Event = _onRemoveEntry(scope, e => if (_topEntry.all(scope).count == 0) on)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
