package scalqa; package Stream; package Z; package extend; package flow

private[Stream] object unfold {

  def apply[@specialized(DATA) A](s: Stream[A], f: Mapping[~[A], A]): Stream[A] = new Stream[A] with Stream.A.Specialized[A] {

    var i = 0

    lazy val buf = s.to[Idx.Array.Buffer]

    @inline def prime = true

    override def pump: A = {
      if (i == buf.size) buf += f(buf)
      i += 1
      buf(i - 1)
    }

    override def foreach(f: Consumer[A]) = App.Fail.state("Cannot pump all of infinite Stream")

    override def ilkOpt = buf.getOpt(0).map(_.I.ilk)
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
