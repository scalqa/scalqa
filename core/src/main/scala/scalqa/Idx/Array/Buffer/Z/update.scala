package scalqa; package Idx.Array; package Buffer; package Z

private[Buffer] object update {

  def removeAt[@specialized(DATA) A](r: Idx.Range, b: Buffer[A]): Unit = {
    assert(r.end <= b._size, failIndex(b._size - 1, b))
    if (r.end < b._size) System.arraycopy(b._array, r.end, b._array, r.start, b._size - r.end)
    b._size -= r.size
  }

  private def failIndex(i: Int, b: Buffer[_]) = "Idx : " + i + " out of range " + (if (b.size == 0) "for EMPTY Buffer" else "from 0 end " + b.size)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
