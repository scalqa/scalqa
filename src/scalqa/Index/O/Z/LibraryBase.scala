package scalqa; package Index; package O; package Z

private[scalqa] trait LibraryBase[A] extends Any with Index.Z.LibraryBase[A] with Coll.O.Z.LibraryBase[A] {

  override def asMap[B](f: A => B): O[B] = new Z.As.Mapped(This, f)

  def asStatefullMap[B](f: A => B): O[B] = new Z.The.StatefullMap(This, f)

  override def asSynchronized(lockOpt: Opt[AnyRef] = \/): O[A] = new Z.As.Synchronized(This, lockOpt)

  override def asReversed: O[A] = new Z.As.Reversed(This)

  override def asTail(from: Int): O[A] = if (from <= 0) This else new Z.As.Tail(This, from)

  protected def This: O[A]
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
