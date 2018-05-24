package scalqa; package J; package Input; package Z; package Bytes

private[J] class allSeparated(real: Input.Bytes, separator: Byte) extends ~[Array[Byte] => Int] {
  val a = Array.get[Byte](256)
  var from = 0
  var end = 0

  def supplyOpt: Opt[Array[Byte] => Int] =
    if (end == -1 || (from >= end && !load)) \/
    else ((array: Array[Byte]) => read(array, 0))

  private def read(array: Array[Byte], pos: Int): Int = {
    var i = from; while (i < end && a(i) != separator) i += 1
    val len = array.size min i - from + pos
    a.copyToArray(array, pos, from <>>+ len - pos)
    from = i + 1
    if (from > end && load) read(array, len) else len
  }

  private def load: Boolean = { from = 0; end = real.read(a.bytes); end > 0 }

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/