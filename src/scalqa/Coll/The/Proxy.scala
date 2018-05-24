package scalqa; package Coll; package The

class Proxy[A](protected val real: Coll[A]) extends Proxy.Like[A]

object Proxy {

  trait Like[A] extends Coll[A] {

    protected def real: Coll[A]

    override def size = real.size

    override def all = real.all
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
