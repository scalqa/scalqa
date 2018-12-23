package scalqa; package Stream; package Z; package extend; package flow

private[Stream] object transpose {

  def apply[A, B](s: Stream[A], f: Mapping[A, ~[B]]): Stream[~[B]] = new Stream.A.Base[~[B]] {

    lazy val idx: Idx[~[B]] = s.map(f).to[Idx]

    var o: Opt[Stream[B]] = \/

    @inline final def prime: Boolean = o || {
      def load = if (idx.all.isAny((v: ~[B]) => v.prime)) o = idx.all.map(_.nextOpt or App.Fail("Converted streams are of different size"))
      o || { load; o }
    }

    @inline final def pump: Stream[B] = { val v = o.value; o = \/; v }
  }
}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
