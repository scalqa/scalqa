package scalqa; package Stream; package Z; package extend; package zip

private[Stream] final class zip[A, B](one: Stream[A], two: Stream[B]) extends Stream.A.Base[(A, B)] {

  def prime = one.prime && two.prime

  def pump = (one.pump, two.pump)

  override def ilkOpt = Ilk.Refs

  override def sizeOpt = one.sizeOpt.letMix(two.sizeOpt)(_ min _)

  override def toInfoTree = new Pro.Info.Tree(toInfo, one.toInfoTree, two.toInfoTree)

  override def chainDepth = (one.chainDepth max two.chainDepth) + 1
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
