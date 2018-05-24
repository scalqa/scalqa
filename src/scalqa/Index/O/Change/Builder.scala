package scalqa; package Index; package O; package Change

trait Builder[A] extends Coll[Change[A]] with Able.Seal {

  def replaceAt(i: Int): Unit = replaceAt(i <>!)

  def replaceAt(r: Int.Range)

  def addAt(i: Int): Unit = addAt(i <>!)

  def addAt(r: Int.Range)

  def removeAt(i: Int): Unit = removeAt(i <>!)

  def removeAt(r: Int.Range)

  def removeAt(pos: Int, elements: Index[A])

  def removeAt(pos: Int, element: A): Unit = removeAt(pos, element.I.Index)

  def reposition(r: Int.Range.Reposition)

  def add(c: Change[A]): Unit

  def refreshAt(i: Int): Unit = refreshAt(i <>!)

  def refreshAt(r: Int.Range)

}

object Builder {

  def get[A](l: Index[A]): Builder[A] = new Z.Builder(l)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
