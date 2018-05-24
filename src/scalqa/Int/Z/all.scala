package scalqa; package Int; package Z

private[Int] object all {

  @inline def up(from: Int): ~[Int] = (Int.Max - from.toLong).I.to(sz => if (sz <= Int.Max) new UpIndexed(from, sz.toInt) else new Up(from))

  @inline def down(from: Int): ~[Int] = (from.toLong - Int.Min).I.to(sz => if (sz <= Int.Max) new DownIndexed(from, sz.toInt) else new Down(from))

  // ------------------------------------------------------------------------------------------------------------------------------------
  private class Up(var from: Long) extends UpBase {
    def pumpOpt(lf: Int => Boolean): Opt[Int] = { while (from <= Int.Max) { val v = from.toInt; from += 1; if (lf(v)) return v }; \/ }
  }

  private class Down(var from: Long) extends DownBase {
    def pumpOpt(lf: Int => Boolean): Opt[Int] = { while (from >= Int.Min) { val v = from.toInt; from -= 1; if (lf(v)) return v }; \/ }
  }

  // ------------------------------------------------------------------------------------------------------------------------------------
  private class UpIndexed(from: Int, size: Int) extends Pipe.The.IndexBase[Int](size) with UpBase { protected def _apply(i: Int) = from + i }

  private class DownIndexed(from: Int, size: Int) extends Pipe.The.IndexBase[Int](size) with DownBase { protected def _apply(i: Int) = from - i }

  // ------------------------------------------------------------------------------------------------------------------------------------
  private trait UpBase extends Pipe.The.Base[Int] {
    override def sortingOpt: Opt[Sorting[Int]] = Sorting.The.Int
    override def tagOpt = Tag.Int
    override def isMutable = false
  }

  private trait DownBase extends UpBase {
    override def sortingOpt: Opt[Sorting[Int]] = Sorting.The.Int.reversed
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/