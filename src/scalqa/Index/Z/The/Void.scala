package scalqa; package Index; package Z; package The

private[scalqa] trait Void[A] extends O[A] with scalqa.Void {

  def size = 0

  def apply(i: Int) = Fail("No elements")

  override def all = \/

  def onChange(f: Coll[O.Change[A]] => Any): Concurrent.Control = \/

}

private[scalqa] object Void extends Void[Nothing]
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/