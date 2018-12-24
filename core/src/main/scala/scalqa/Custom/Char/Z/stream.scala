package scalqa; package Custom; package Char; package Z

private[Char] object stream {

  abstract class Base(override val _size: Int) extends Stream[Char] with Stream.A.Specialized.Indexed[Char] {

    def pump = _pumpIndexed

    def foreach(f: Stream.Consumer[Char]) = _consumeIndexed(f)

    override def ilkOpt = Ilk.Chars

  }

  class Up(from: Char) extends Base(scala.Char.MaxValue - from + 1) {

    override def _apply(i: Int) = (from + i).toChar

    override def sortedOpt = Ordering.Char
  }

  class Down(from: Char) extends Base(from - scala.Char.MinValue + 1) {

    override def _apply(i: Int) = (from - i).toChar

    override def sortedOpt = Ordering.Char.reverse
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
