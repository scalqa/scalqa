package scalqa; package Lookup; package The

class Proxy[A, B](protected val real: Lookup[A, B]) extends Proxy.Like[A, B]

object Proxy {

  trait Like[A, B] extends Lookup[A, B] {

    protected def real: Lookup[A, B]

    override def size = real.size

    override def opt(key: A) = real.opt(key)

    override def allPairs = real.allPairs
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
