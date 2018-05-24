package scalqa; package Index; package W; package The

class Proxy[A](protected val real: W[A]) extends Proxy.Like[A]

object Proxy {

  trait Like[A] extends Index.The.Proxy.Like[A] with W[A] {

    protected def real: W[A]

    override def addAt(n: Int, e: A) = real.addAt(n, e)

    override def removeAt(i: Int.Range) = real.removeAt(i)

    override def replaceAt(n: Int, a: A) = real.replaceAt(n, a)

    override def order(o: Sorting[A]) = real.order(o)
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
