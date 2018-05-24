package scalqa; package Long; package Z

private[Long] abstract class all extends Pipe.The.Base[Long] {
  protected var open = true

  def pumpOpt(lf: Long => Boolean): Opt[Long] = { while (open) { val v = next; if (lf(v)) return v }; \/ }

  protected def next: Long

  override def tagOpt = Tag.Long

  override def isMutable = false

}

private[Long] object all {

  class Up(var cur: Long) extends all {

    protected def next = { val v = cur; if (cur < Long.Max) cur += 1 else open = false; v }

    override def sortingOpt = Sorting.The.Long

  }

  class Down(var cur: Long) extends all {

    protected def next = { val v = cur; if (cur > Long.Min) cur -= 1 else open = false; v }

    override def sortingOpt = Sorting.The.Long.reversed

  }
}

//    def pumpOpt(lf: Int => Boolean): Opt[Int] = { while (from <= Int.Max) { val v = from.toInt; from += 1; if (lf(v)) return v }; \/ }
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/