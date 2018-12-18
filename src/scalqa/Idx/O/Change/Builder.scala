package scalqa; package Idx; package O; package Change

trait Builder[A] extends Idx[Change[A]] with Any.Able.Seal {

  def update(i: Int): Unit = update(i <>!)

  def update(r: Idx.Range)

  def addAt(i: Int): Unit = addAt(i <>!)

  def addAt(r: Idx.Range)

  def removeAt(i: Int): Unit = removeAt(i <>!)

  def removeAt(r: Idx.Range)

  def removeAt(pos: Int, elements: Idx[A])

  def removeAt(pos: Int, element: A): Unit = removeAt(pos, element.I.to[Idx])

  def reposition(r: Idx.Range.Reposition)

  def add(c: Change[A]): Unit

  def refreshAt(i: Int): Unit = refreshAt(i <>!)

  def refreshAt(r: Idx.Range)

}

object Builder {

  def make[A](l: Idx[A]): Builder[A] = new Z.ChangeBuilder(l)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
