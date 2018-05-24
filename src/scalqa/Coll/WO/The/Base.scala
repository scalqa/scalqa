package scalqa; package Coll; package WO; package The

trait Base[A] extends WO[A] with Any.Extra.Event1 {
  protected type COLL_W = W[A]

  def onChange(on: Coll[O.Change[A]] => Any) = _onEvent1(Base.Id.Change, on)

  protected def fireChange(c: Coll[O.Change[A]]): Unit = if (c.isEmpty.not) _fireEvent1(Base.Id.Change, c)

}

private object Base { object Id { object Change } }
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
