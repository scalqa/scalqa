package scalqa; package Custom; package Array; package Z

import System.arraycopy

private[scalqa] object copy {

  def range[A](a: Array[A], r: scalqa.Idx.Range): Array[A] = {
    val na = emptyAs(a, r.size);
    arraycopy(a, r.start, na, 0, r.size);
    na
  }

  def dropRange[A](a: Array[A], r: scalqa.Idx.Range): Array[A] = {
    val s = r.start; val e = r.end
    val na = emptyAs(a, a.length - e + s)
    if (s > 0) arraycopy(a, 0, na, 0, s)
    if (e < a.length) arraycopy(a, e, na, s, a.length - e)
    na
  }

  def resize[A](a: Array[A], newSize: Int): Array[A] = {
    val na = emptyAs(a, newSize)
    System.arraycopy(a, 0, na, 0, a.length min newSize)
    na
  }

  def to(array: Array[_], destArray: Array[_], destPos: Int = 0, srcRangeOpt: Opt[scalqa.Idx.Range] = \/): Int = {
    var srcFrom = 0
    var len = destArray.length - destPos min array.length
    if (srcRangeOpt.isValue) {
      val r = srcRangeOpt.value
      srcFrom = r.start
      val sz = r.size
      if (sz < len) len = sz
    }
    try {
      if (len == 0) 0
      else {
        arraycopy(array, srcFrom, destArray, destPos, len)
        len
      }
    } catch {
      case e: Throwable =>
        System.err.println("Array.copy \n\tfrom:" + array + " fromPos:" + srcFrom + "\n\tdest:" + destArray + " destPos:" + destPos + "\n\tlen:" + len)
        throw e
    }
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
