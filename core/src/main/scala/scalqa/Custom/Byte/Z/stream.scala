package scalqa; package Custom; package Byte; package Z

private[Byte] object stream {

  abstract class Base(val _size: Int) extends Stream[Byte] with Stream.A.Specialized.Indexed[Byte] {

    def pump = _pumpIndexed

    def foreach(f: Stream.Consumer[Byte]) = _consumeIndexed(f)

    override def ilkOpt = Ilk.Bytes

  }

  class Up(from: Byte) extends Base(scala.Byte.MaxValue - from + 1) {

    override def _apply(i: Int) = (from + i).toByte

    override def sortedOpt = Ordering.Byte

  }

  class Down(from: Byte) extends Base(from - scala.Byte.MinValue + 1) {

    override def _apply(i: Int) = (from - i).toByte

    override def sortedOpt = Ordering.Byte.reverse

  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
