package scalqa; package Coll; package The

class Unique[A] protected extends Coll[A] {
  def this(p: ~[A]) = { this; p(real.add) }

  protected val real = new java.util.HashSet[A]

  def all = real.all

  def size = real.size

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
