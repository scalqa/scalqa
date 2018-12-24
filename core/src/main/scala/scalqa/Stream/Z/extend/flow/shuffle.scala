package scalqa; package Stream; package Z; package extend; package flow

private[Stream] object shuffle {

  def apply[@specialized(DATA) A](s: Stream[A]): Stream[A] = new Stream[A] with A.Extended.Ilk[A] with Stream.A.Specialized.Indexed[A] {

    protected lazy val bin = real.to[Idx.Array.Buffer]

    protected val shffle: Array[Int] = {
      val a = _size.Range.toArray
      a.length.all.map(_ => Util.Random.intBelow(a.length)).foreachIdx((i, j) => { val v = a(i); a(i) = a(j); a(j) = v })
      a
    }

    def real = s

    def _size = bin.size

    def _apply(i: Int) = bin(shffle(i))

    def pump = _pumpIndexed

    def foreach(f: Consumer[A]) = _consumeIndexed(f)
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
