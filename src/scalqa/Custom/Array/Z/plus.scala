package scalqa; package Custom; package Array; package Z

import System.arraycopy

private[scalqa] object plus {

  def apply[@specialized(DATA) A](a: Array[A], v: A): Array[A] = {
    val na = a.copyResize(a.length + 1)
    na(a.length) = v
    na
  }

  def stream[@specialized(DATA) A](a: Array[A], v: ~[A]): Array[A] = {
    val b = v.preview
    val sz = b.previewSize
    val na = a.copyResize(a.length + sz)
    v.copyTo(scalqa.Idx.Array.Buffer.loaded[A](na, a.length).loader)
    na
  }

  def at[@specialized(DATA) A](a: Array[A], i: Int, v: A): Array[A] = {
    val na = emptyAs(a, a.length + 1)
    arraycopy(a, 0, na, 0, i)
    arraycopy(a, i, na, i + 1, a.length - i)
    na(i) = v;
    na
  }

  def pipeAt[@specialized(DATA) A](a: Array[A], i: Int, v: ~[A]): Array[A] = {
    val b = v.preview
    val sz = b.previewSize
    val na = emptyAs(a, a.length + sz)
    arraycopy(a, 0, na, 0, i);
    v.copyTo(scalqa.Idx.Array.Buffer.loaded[A](na, i).loader)
    arraycopy(a, i, na, i + sz, a.length - i)
    na
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
