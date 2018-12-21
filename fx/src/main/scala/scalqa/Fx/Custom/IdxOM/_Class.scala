package scalqa; package Fx; package Custom; package IdxOM

class _Class[A](l: javafx.collections.ObservableList[A]) extends IdxO[A](l) with Idx.OM[A] {

  def addAt(i: Int, e: A): Unit = real.add(i, e)

  def removeAt(i: Idx.Range): Unit = real.remove(i.start, i.end)

  def update(i: Int, e: A): Unit = real.set(i, e)

  def refreshAt(r: Idx.Range): Unit = real.all.letAt(r).letType[Any.Able.Refresh].foreach(_.refresh)

  def multiChange(ch: Idx.M[A] => Any): Unit = ch(this) //Think later

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
