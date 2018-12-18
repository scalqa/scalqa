package scalqa; package Pro; package O; package A

trait Base[A] extends O[A] with Any.Ref.Extra.Event0 {

  override def onChange(f: () => Any) = _onEvent0(Base.ChangeId, f)

  protected def fireChange: Int = _fireEvent0(Base.ChangeId)

}

private object Base {
  private object ChangeId

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
