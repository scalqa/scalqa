package scalqa; package Custom; package Array; package Z

private[scalqa] object stream {

  def apply[@specialized(DATA) A](arr: Array[A], len: Int = -1): Stream[A] with Any.Able.Stream[A] = new Stream[A] with Stream.A.Specialized.Indexed[A] with Any.Able.Stream[A] {

    val _size = if (len >= 0) len else arr.length

    def _apply(i: Int): A = arr(i)

    def pump = _pumpIndexed

    override def foreach(c: Stream.Consumer[A]) = { var i = _position; while (i < _size) { c.accept(arr(i)); i += 1 }; _position = i }

    override def ilkOpt = Ilk.fromArray(arr)

    override def copyTo(b: Idx.Array.Buffer.Loader[A]): Unit = b.addFromArray(arr, _position, _size - _position)

    def all = this
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
