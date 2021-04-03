package scalqa; package `val`; package idx; package z

private[scalqa] object View:

  class ReadOnly[A](real: Idx[A]) extends Idx[A]:
    def apply(i: Int) = real(i)
    def size          = real.size

  class IndexedSeq[A](real: Idx[A]) extends scala.collection.AbstractSeq[A] with scala.collection.immutable.IndexedSeq[A]:
    def apply(i: Int) = real(i)
    def length        = real.size

  class Range[A](real: Idx[A], start: Int, val size:Int) extends Idx[A]:
    def apply(i: Int) = real(i + start)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
