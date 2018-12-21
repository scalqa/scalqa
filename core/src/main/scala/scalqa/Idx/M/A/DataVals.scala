package scalqa; package Idx; package M; package A

class DataVals[A](initSize: Int = \/)(implicit val setup: Any.Datum.Setup[A]) extends Idx.M[A] with Any.Datum.Vals.Like[A] {

  protected val real: Array.Buffer[setup.VALUE] = setup.ilk.mkBuffer(initSize)

  def apply(i: Int): A = setup.Map(real(i))

  def size: Int = real.size

  def allReal: ~[setup.VALUE] = real.all

  def addAt(i: Int, v: A) = real.addAt(i, setup.Map.undo(v))

  def removeAt(r: Idx.Range) = real.removeAt(r)

  def update(i: Int, v: A) = real.update(i, setup.Map.undo(v))

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
