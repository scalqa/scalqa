package scalqa; package Idx.Range; package Z

private[Range] object array {

  private val ints = 256.all.toRaw[Ints]

  def apply(r: Idx.Range): Array[Int] = {
    val a = new Array[Int](r.size)
    if (ints.size.Range.contains(r)) ints.copyTo(a, 0, r)
    else r.all.foreachIdx(a(_)= _)
    a
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
