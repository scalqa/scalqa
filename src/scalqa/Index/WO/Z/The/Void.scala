package scalqa; package Index; package WO; package Z; package The

private[scalqa] trait Void extends WO[Nothing] with scalqa.Void {

  def size = 0
  def apply(i: Int) = Fail()

  def refreshAt(r: Int.Range) = Fail.unsupported()
  def removeAt(i: Int.Range) = Fail.unsupported()
  def addAt(i: Int, e: Nothing) = Fail.unsupported()
  def replaceAt(i: Int, e: Nothing) = Fail.unsupported()
  def onChange(f: Coll[O.Change[Nothing]] => Any): Concurrent.Control = \/

  def multiChange(ch: W[Nothing] => Any) = Fail.unsupported()

  override def order(o: Sorting[Nothing]) = ()

}

private[scalqa] object Void extends Void
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
