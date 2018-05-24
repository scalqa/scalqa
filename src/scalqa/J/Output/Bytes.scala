package scalqa; package J; package Output

trait Bytes extends Z.Like {

  def writeByte(b: Int)

  def write(ba: Array[Byte])

  def write(ba: Array[Byte], off: Int, len: Int)

  def write(in: Input) {
    val bin = in.asBytes
    val ba = Array.get[Byte](1000)
    var i = bin.read(ba)
    while (i >= 0) {
      write(ba, 0, i)
      i = bin.read(ba)
    }
    bin.close
  }

  def writeAndClose(in: Input) { write(in); close }

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
