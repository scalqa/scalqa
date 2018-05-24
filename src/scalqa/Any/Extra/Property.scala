package scalqa; package Any; package Extra

trait Property extends Like {

  protected def _setPropertyOpt[T](name: AnyRef, value: T): Opt[T] = _removePropertyOpt(name).I.run(_addEntry(name, value))

  protected def _getPropertyOpt[T](name: AnyRef, dflt: => Opt[T]): Opt[T] = _topEntry.all(name).firstOpt.map(_.value.cast[T]) orOpt dflt.apply(_addEntry(name, _))

  protected def _removePropertyOpt[T](name: AnyRef): Opt[T] = _topEntry.all(name).firstOpt.apply(_.cancel).map(_.value.cast[T])

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
