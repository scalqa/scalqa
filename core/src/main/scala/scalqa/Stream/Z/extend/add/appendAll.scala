package scalqa; package Stream; package Z; package extend; package add

private[Stream] object appendAll {

  def apply[@specialized(DATA) A](p1: Stream[A], p2: Stream[A]): Stream[A] = new Stream[A] with Stream.A.Specialized[A] {
    private var state = 0

    def prime = {
      if (state == 0) state = if (p1.prime) 1 else 2
      if (state == 2) state = if (p2.prime) 3 else 4
      state < 4
    }

    def pump = state match {
      case 1 => { state = 0; p1.pump }
      case 3 => { state = 2; p2.pump }
      case _ => Stream.failEmpty
    }

    def foreach(f: Consumer[A]) = { if (state < 2) p1.foreach(f); p2.foreach(f) }

    override def ilkOpt = p1.ilkOpt orOpt p2.ilkOpt

    override def sizeOpt = p1.sizeOpt.letMix(p2.sizeOpt)(_ + _)

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
