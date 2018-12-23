package scalqa; package Idx.Array; package Buffer; package Z

private[Buffer] object add {

  def at[@specialized(DATA) A](i: Int, v: A, b: Buffer[A]) = {
    val sz = b._size
    if (b._arrayLen <= sz) b.growArray(sz + 1)
    if (i >= sz)
      b.update(sz, v)
    else {
      System.arraycopy(b._array, i, b._array, i + 1, sz - i)
      b.update(i, v)
    }
    b._size += 1
  }

  def allAt[@specialized(DATA) A](i: Int, s: ~[A], b: Buffer[A]): Unit =
    if (i >= b.size) s.copyTo(b)
    else {
      val all = s.sizeOpt.swap(s) or s.to[Buffer].all
      val sz = all.sizeOpt.value
      if (sz > 0) {
        val newTotal = b._size + sz
        if (b._arrayLen < newTotal) b.growArray(newTotal)
        System.arraycopy(b._array, i, b._array, i + sz, b._size - i)
        val l = RangeLoader(b, i <>> i + sz)
        all.copyTo(l)
        if (l._size < i + sz) App.Fail("Stream delivered only " + (l._size - i) + " elements out of " + sz + " declared in sizeOpt")
        b._size = newTotal
      }
    }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
