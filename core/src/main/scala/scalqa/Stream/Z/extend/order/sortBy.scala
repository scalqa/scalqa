package scalqa; package Stream; package Z; package extend; package order

private[Stream] object sortBy {

  @inline final def apply[@specialized(DATA) A, B](s: Stream[A], o: Ordering[B], f: Mapping[A, B]): Stream[A] = new Stream[A] with A.Extended.Ilk[A] with Stream.A.Specialized.Indexed[A] {

    private var fresh = true

    lazy val buf = {
      fresh = false
      val w = real.to[Idx.M]
      w.sort(o.asMappedView(f(_)))
      w
    }

    @inline final override def _apply(i: Int) = buf(i)

    override def _size = if (fresh) real.sizeOpt or buf.size else buf.size

    @inline final def pump = _pumpIndexed

    @inline final def foreach(f: Consumer[A]) = _consumeIndexed(f)

    override def sortedByOpt[C] = (o, f).Opt.asInstanceOf[Opt[(Ordering[C], A => C)]]

    def real = s
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
