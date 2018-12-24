package scalqa; package Stream; package Z; package A; package Scala

private[scalqa] object Iterator {

  def make[A](src: Stream[A]): Iterator[A] = new collection.AbstractIterator[A] {

    def hasNext: Boolean = src.prime

    def next = if (src.prime) src.pump else Stream.failEmpty
  }
}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
