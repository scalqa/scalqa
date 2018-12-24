package scalqa; package Idx; package Z

private[scalqa] object stream {

  def apply[@specialized(DATA) A](v: Idx[A]): Stream[A] = new Stream[A] with Stream.A.Specialized.Indexed[A] {

    def _size = v.size

    def _apply(i: Int) = v(i)

    def pump = _pumpIndexed

    def foreach(f: Stream.Consumer[A]) = _consumeIndexed(f)
  }
}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
