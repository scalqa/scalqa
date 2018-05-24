package scalqa; package Int; package Range; package Z

import scala.language.higherKinds

private[Range] class all(start: Int, size: Int) extends all.Like(size) {
  def this(r: Range) = this(r.start, r.size)

  @inline protected def _apply(i: Int) = start + i

  protected override def toTarget[TRGT[Int]](b: Boolean)(implicit c: Pipe.To[TRGT], t: Tag[Int] = \/): TRGT[Int] =
    if (c == Pipe.To.Array && size > 0) array(apply(_range.start) <>>+ size).cast else super.toTarget(b)
}

private[Range] object all {

  class Stepped private (start: Int, size: Int, step: Int) extends Like(size) {
    def this(r: Range, step: Int) = this(if (step < 0) r.end - 1 else r.start, (r.size / step.abs) ? (_ => r.size % step != 0, _ + 1), step)

    @inline protected def _apply(i: Int) = start + i * step

  }

  // ***********************************************************************************
  abstract class Like(size: Int) extends Pipe.The.IndexBase[Int](size) {

    override def sortingOpt = Sorting.The.Int

    override def tagOpt = Tag.Int

    override def isMutable = false
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/