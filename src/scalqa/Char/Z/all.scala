package scalqa; package Char; package Z

private[Char] abstract class all(size: Int) extends Pipe.The.IndexBase[Char](size) {

  override def tagOpt = Tag.Char

  override def isMutable = false

}

private[Char] object all {

  private[Char] class Up(from: Char) extends all(Char.Max - from + 1) {

    protected def _apply(i: Int) = (from + i).toChar

    override def sortingOpt: Opt[Sorting[Char]] = Sorting.The.Char

  }

  class Down(from: Char) extends all(from - Char.Min + 1) {

    protected def _apply(i: Int) = (from - i).toChar

    override def sortingOpt: Opt[Sorting[Char]] = Sorting.The.Char.reversed

  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/