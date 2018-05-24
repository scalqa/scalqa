package scalqa; package Lookup; package Z

private[scalqa] trait LibraryBase[A, B] extends Any with Coll.Z.LibraryBase[B] {

  def allKeys: ~[A] = This.allPairs.map(_._1)

  override def asMap[C](f: B => C): Lookup[A, C] = new Z.As.Mapped(This, f)

  def asScalaMap: collection.Map[A, B] = new Z.As.ScalaMap(This)

  def asPartialFunction: PartialFunction[A, B] = new PartialFunction[A, B] { def isDefinedAt(a: A) = This.opt(a); def apply(a: A): B = This(a) }

  protected def This: Lookup[A, B]
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
