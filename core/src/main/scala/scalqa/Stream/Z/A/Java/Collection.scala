package scalqa; package Stream; package Z; package A; package Java

private[scalqa] object Collection {

  def toStream[A](c: java.util.Collection[A])(implicit i: Ilk[A]): Stream[A] with Any.Able.Stream[A] = new Stream.A.Base[A] with Any.Able.Stream[A] {
    protected val it = c.iterator
    protected var sz = c.size

    def prime = it.hasNext

    def pump = { sz -= 1; it.next }

    override def foreach(c: Consumer[A]) = { sz = 0; while (it.hasNext) c.accept(it.next) }

    override def sizeOpt = sz

    override def ilkOpt = i.ilkOpt

    def all = this
  }
}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
