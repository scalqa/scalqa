package scalqa; package Stream; package Z; package A

private[Stream] trait Extended[A] extends Stream.A.Specialized[A] with Any.Wrap[Stream[_]] { self: Stream[A] =>

  override def chainDepth = real.chainDepth + 1

  override def toInfoTree = new Pro.Info.Tree(toInfo, real.toInfoTree)
}

private[Stream] object Extended {

  trait Size[A] extends Extended[A] { self: Stream[A] =>
    override def sizeOpt = real.sizeOpt
  }

  trait Ilk[A] extends Extended[A] with Any.Wrap[Stream[A]] { self: Stream[A] =>
    override def ilkOpt = real.ilkOpt
  }

  trait All[A] extends Size[A] with Ilk[A] { self: Stream[A] =>

    override def sortedOpt: Opt[Ordering[A]] = real.sortedOpt

    override def sortedByOpt[B]: Opt[(Ordering[B], A => B)] = real.sortedByOpt
  }

  trait Filter[A] extends All[A] { self: Stream[A] =>

    override def sizeOpt: Opt.Int = \/
  }
}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
