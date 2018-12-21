package scalqa; package Stream; package Z; package extend; package zip

private[Stream] object zipAll {

  def apply[A, B](one: Stream[A], two: Stream[B], ao: Opt[A], bo: Opt[B]) = new Stream.A.Base[(A, B)] {
    private var state = 0

    @inline def prime = {
      if (state == 0) state =
        if (one.prime) if (two.prime) 3 else 1
        else if (two.prime) 2
        else -1
      state > 0
    }

    def pump: (A, B) = state match {
      case 1 => { state = 0; (one.pump, bo or fail("second")) }
      case 2 => { state = 0; (ao or fail("first"), two.pump) }
      case 3 => { state = 0; (one.pump, two.pump) }
      case _ => Stream.failEmpty
    }

    override def sizeOpt = one.sizeOpt.letMix(two.sizeOpt)(_ max _)

    override def ilkOpt = Ilk.Refs

    override def toInfoTree = new Pro.Info.Tree(toInfo, one.toInfoTree, two.toInfoTree)

    override def chainDepth = (one.chainDepth max two.chainDepth) + 1

    private def fail(s: String) = App.Fail("Stream.zip '" + s + "' default Opt is not provided, but is required to match other Stream's length")
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
