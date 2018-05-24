package scalqa; package Any; package Extra; package Event

trait Like extends Extra.Like {

  private[Extra] def _addOrRemoveEvent(scope: AnyRef, f: AnyRef): Concurrent.Control = f match {
    case r: Any.Event if r.isCancel => {
      if (_topEntry.all(scope).let(_.value.I.letAs(classOf[Any.Event]).let(_.id == r.id)).peek(_.cancel).count() > 0) _topEntry.all(scope).drain
      \/
    }
    case _ => _addEntry(scope, f)
  }

  private[Extra] def _fireEvent[T](scope: AnyRef, f: T => Any): Int = _topEntry.all(scope).peek(_.fire(f)).count()

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
