package scalqa; package Idx; package OM; package Z; package A

private[scalqa] trait Void extends OM[Any] with scalqa.Void {

  def size = 0
  def apply(i: Int) = App.Fail()

  def refreshAt(r: Idx.Range) = App.Fail.unsupported()
  def removeAt(i: Idx.Range) = App.Fail.unsupported()
  def addAt(i: Int, e: Any) = App.Fail.unsupported()
  def update(i: Int, e: Any) = App.Fail.unsupported()
  def onChange(f: Idx[O.Change[Any]] => Any): EventControl = \/

  def multiChange(ch: M[Any] => Any) = App.Fail.unsupported()

  override def order(o: Ordering[Any]) = ()

}

private[scalqa] object Void extends Void
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
