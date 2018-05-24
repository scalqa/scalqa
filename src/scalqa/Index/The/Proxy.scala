package scalqa; package Index; package The

class Proxy[A](protected val real: Index[A]) extends Proxy.Like[A]

object Proxy {

  trait Like[A] extends Coll.The.Proxy.Like[A] with Index[A] {

    protected def real: Index[A]

    override def apply(i: Int) = real.apply(i)

    override def size = real.size

  }

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
