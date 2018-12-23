package scalqa; package Custom; package Char; package Z

private[Char] object stream {

  abstract class Base(override val _size: Int) extends Stream[Char] with Stream.A.Specialized.Indexed[Char] {

    @inline final def pump = _pumpIndexed

    @inline final def foreach(f: Stream.Consumer[Char]) = _consumeIndexed(f)

    @inline final override def ilkOpt = Ilk.Chars

  }

  class Up(from: Char) extends Base(scala.Char.MaxValue - from + 1) {

    @inline final override def _apply(i: Int) = (from + i).toChar

    @inline final override def sortedOpt = Ordering.Char
  }

  class Down(from: Char) extends Base(from - scala.Char.MinValue + 1) {

    @inline final override def _apply(i: Int) = (from - i).toChar

    @inline final override def sortedOpt = Ordering.Char.reverse
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
