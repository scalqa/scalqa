package scalqa; package Stream; package Z; package A; package Java

private[scalqa] object Iterable {

  def toStream[@specialized(DATA) A: Ilk](v: java.lang.Iterable[A]): Stream[A] with Any.Able.Stream[A] = v match {
    case c: java.util.Collection[A] if (c.isEmpty) => \/
    case l: java.util.List[A] => List.toStream(l)
    case c: java.util.Collection[A] => Collection.toStream(c)
    case v => Scala.Iterator.toStream(v.iterator)
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
