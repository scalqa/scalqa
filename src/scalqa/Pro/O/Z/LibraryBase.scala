package scalqa; package Pro; package O; package Z

private[scalqa] trait LibraryBase[A] extends Any with Pro.Z.LibraryBase[A] {

  def onChangeRun(f: => Any): Concurrent.Control = This.onChange(() => f)

  def onValueChange(f: A => Any): Concurrent.Control = This.onChange(Any.Event.moveId0(f, () => f(This())))

  def onValueChangeWithOld(f: (A, A) => Any): Concurrent.Control = { var old = This.apply; This.onChange(Any.Event.moveId0(f, () => This().I(v => { f(v, old); old = v }))) }

  override def asMap[B](f: A => B): O[B] = new Z.As.Mapped(This, f)

  def asMap[B](f: A => B, p: ~[Any.O]): O[B] = new Z.The.Multi.Mapped[A, B](This, f, p)

  protected def This: O[A]

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
