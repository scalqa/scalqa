package scalqa; package Stream; package Z; package A; package Java

private[scalqa] object Iterator {

  def toStream[@specialized(DATA) A](it: java.util.Iterator[A])(implicit i: Ilk[A]): Stream[A] with Any.Able.Stream[A] = new Stream.A.Base[A] with Any.Able.Stream[A] {

    def prime = it.hasNext

    def pump = it.next

    override def ilkOpt = i.ilkOpt

    def all = this
  }

  def make[A](src: Stream[A]): java.util.Iterator[A] = new java.util.Iterator[A] {

    def hasNext(): Boolean = src.prime

    def next = if (src.prime) src.pump else Stream.failEmpty
  }
}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
