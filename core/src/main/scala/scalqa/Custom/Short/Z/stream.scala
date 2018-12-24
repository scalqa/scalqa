package scalqa; package Custom; package Short; package Z

private[Short] object stream {

  abstract class Base(val _size: Int) extends Stream[Short] with Stream.A.Specialized.Indexed[Short] {

    def pump = _pumpIndexed

    def foreach(f: Stream.Consumer[Short]) = _consumeIndexed(f)

    override def ilkOpt = Ilk.Shorts

  }

  class Up(from: Short) extends Base(scala.Short.MaxValue - from + 1) {

    override def _apply(i: Int) = (from + i).toShort

    override def sortedOpt = Ordering.Short
  }

  class Down(from: Short) extends Base(from - scala.Short.MinValue + 1) {

    override def _apply(i: Int) = (from - i).toShort

    override def sortedOpt = Ordering.Short.reverse
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
