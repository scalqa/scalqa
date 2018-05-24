package scalqa; package Coll; package Val; package Z

import scala.language.higherKinds

private class all[A](var start: Base[A]) extends Pipe.The.IndexBase[A](start.size) with Able.Copy.ToArray[A] {
  private var array: Array.Raw[_ >: A] = null
  private var off = -1

  override def isMutable = false

  protected def _apply(i: Int): A = { if (off == -1) load; array(i - off).cast[A] }

  override def pumpOpt(f: A => Boolean): Opt[A] = { if (off == -1) load; super.pumpOpt(f) }

  protected override def _copyToArray(dest: Array[A], p: Int, range: Int.Range) = { if (off == -1) load; Array.getByRaw[A](array).copyToArray(dest, p, range << off) }

  protected override def toTarget[TRGT[A]](isTo: Boolean)(implicit c: Pipe.To[TRGT], t: Tag[A] = \/): TRGT[A] =
    if (c == Pipe.To.CollVal && !_isProjected) start.cast
    else if (isTo) super.to(c, t)
    else super.as(c, t)

  // ------------------------------------------------------------------------
  private def load {
    off = _range.start
    val to = _range.end
    if (off < to) {
      while (start.size > to) start = start.tail
      var i = start.size - off
      array = start.tag.newArray[A](i).raw
      while (i > 0) { i -= 1; array(i) = start.head; start = start.tail }
    }
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/