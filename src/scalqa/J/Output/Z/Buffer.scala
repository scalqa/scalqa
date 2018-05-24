package scalqa; package J; package Output; package Z

private[J] class Buffer(initSize: Int = 512) extends Base[Buffer.Io](new Buffer.Io(initSize)) with Output.Buffer {

  def size: Int = real._count

  def bytes: Array[Byte] = real.toByteArray

  def clear = real.reset

  def toInput = Input.get(bytes)

  def asBytes = new Bytes(real)
  def asData = new Data(real)
  def asText = new Text(real)
}

private[J] object Buffer {

  class Io(is: Int) extends java.io.ByteArrayOutputStream(is) { def _count: Int = count }

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/