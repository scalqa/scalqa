package scalqa; package Util; package Time; package Z

import Lookup._

private[Time] class IntLookup[A: ClassTag](provider: Int => A) {
  private var store = (0, new Array[A](0))

  def apply(i: Int): A = {
    val s = store
    val off = s._1
    val arr = s._2
    if (i < off) {
      store = (i, {
        val a = new Array[A](arr.length + off - i)
        System.arraycopy(arr, 0, a, off - i, arr.length)
        a
      })
      return apply(i)
    }
    var j = i - off
    if (j >= arr.length) {
      store =
        if (arr.length == 0) (i - 50, new Array[A](100))
        else (off, arr.copyResize(j + 10))
      return apply(i)
    }
    var v = arr(j)
    if (v == null) {
      v = provider(i)
      arr(j) = v
    }
    v
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
