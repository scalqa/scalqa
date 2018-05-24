package scalqa; package Index; package O; package The

trait Base[A] extends O[A] with Any.Extra.Event1 with Any.Extra.Observable with Any.Extra {

  def onChange(on: Coll[Change[A]] => Any) = _onEvent1(Base.Id, on)

  protected def fireChange(c: Coll[Change[A]]): Unit = if (c.isEmpty.not) _fireEvent1(Base.Id, c)

  protected def hasIndexeners: Boolean = _allEntries(Base.Id).firstOpt

  protected def onStartListening(on: => Any) = _onAddFirstEntryRun(Base.Id, on)

  protected def _change(f: Change.Builder[A] => Any) = Change.Builder.get[A](this).I(b => { f(b); if (b.isEmpty.not) fireChange(b.seal) })

}

private object Base { object Id }
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
