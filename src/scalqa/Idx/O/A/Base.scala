package scalqa; package Idx; package O; package A

trait Base[A] extends O[A] with Any.Ref.Extra.Event1 with Any.Ref.Extra.Observable with Any.Ref.Extra {

  def onChange(on: Idx[Change[A]] => Any) = _onEvent1(Base.Id, on)

  protected def fireChange(c: Idx[Change[A]]): Unit = if (!c.isEmpty) _fireEvent1(Base.Id, c)

  protected def _hasListeners: Boolean = _allEntries(Base.Id).nextOpt

  protected def _onStartListening(on: => Any) = _onAddFirstEntryRun(Base.Id, on)

  protected def _change(f: Change.Builder[A] => Any) = Change.Builder.make[A](this).I(b => { f(b); if (!b.isEmpty) fireChange(b.seal) })

}

private object Base { object Id }
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
