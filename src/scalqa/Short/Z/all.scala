package scalqa; package Short; package Z

private[Short] abstract class all(size: Int) extends Pipe.The.IndexBase[Short](size) {

  override def tagOpt = Tag.Short

  override def isMutable = false

}

private[Short] object all {

  private[Short] class Up(from: Short) extends all(Short.Max - from + 1) {

    protected def _apply(i: Int) = (from + i).toShort

    override def sortingOpt: Opt[Sorting[Short]] = Sorting.The.Short

  }

  class Down(from: Short) extends all(from - Short.Min + 1) {

    protected def _apply(i: Int) = (from - i).toShort

    override def sortingOpt: Opt[Sorting[Short]] = Sorting.The.Short.reversed

  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/