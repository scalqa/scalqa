package scalqa; package Coll; package W; package The

class Unique[A] extends Coll.The.Unique[A] with W[A] {
  def this(p: ~[A]) = { this; this =+~ p }

  def add(a: A) = real.add(a)

  def remove(a: A) = real.remove(a)

  def clear: Unit = real.clear

  def addConfirm(a: A): Boolean = real.add(a)

  def removeConfirm(a: A): Boolean = real.remove(a)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
