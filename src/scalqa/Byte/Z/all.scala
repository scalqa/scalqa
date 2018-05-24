package scalqa; package Byte; package Z

private[Byte] abstract class all(size: Int) extends Pipe.The.IndexBase[Byte](size) {

  override def tagOpt = Tag.Byte

  override def isMutable = false

}

private[Byte] object all {

  private[Byte] class Up(from: Byte) extends all(Byte.Max - from + 1) {

    protected def _apply(i: Int) = (from + i).toByte

    override def sortingOpt: Opt[Sorting[Byte]] = Sorting.The.Byte

  }

  class Down(from: Byte) extends all(from - Byte.Min + 1) {

    protected def _apply(i: Int) = (from - i).toByte

    override def sortingOpt: Opt[Sorting[Byte]] = Sorting.The.Byte.reversed

  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/