package scalqa; package Stream; package Z; package extend; package add

private[Stream] object insertAt {

  def apply[@specialized(DATA) A](p1: Stream[A], idx: Int, v: A): Stream[A] = all(p1, idx, Z.A.One(v))

  def all[@specialized(DATA) A](p1: Stream[A], idx: Int, p2: Stream[A]): Stream[A] = if (idx <= 0) p2 +~ p1 else new Stream[A] with Stream.A.Specialized[A] {
    protected var i = 0

    private var state = 0

    def prime = {
      if (state < 2) state = if (i < idx && p1.prime) 1 else 2
      if (state == 2) state = if (p2.prime) 3 else 4
      if (state == 4) state = if (p1.prime) 5 else 7
      state < 7
    }

    def pump = state match {
      case 1 => { state = 0; i += 1; p1.pump }
      case 3 => { state = 2; p2.pump }
      case 5 => { state = 4; p1.pump }
      case _ => Stream.failEmpty
    }

    def foreach(c: Consumer[A]) = {
      if (state < 2) while (i < idx && p1.prime) { i += 1; c.accept(p1.pump) }
      if (state < 4) p2.foreach(c)
      p1.foreach(c)
    }

    override def ilkOpt = p1.ilkOpt orOpt p2.ilkOpt

    //erride def sizeOpt = p1.sizeOpt.letMix(p2.sizeOpt)(_ + _)
    override def sizeOpt = for (s1 <- p1.sizeOpt; s2 <- p2.sizeOpt) yield s1 + s2

    override def toInfoTree = new Pro.Info.Tree(toInfo, p1.toInfoTree, p2.toInfoTree)

    override def chainDepth = (p1.chainDepth max p2.chainDepth) + 1
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
