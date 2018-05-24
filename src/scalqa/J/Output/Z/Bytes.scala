package scalqa; package J; package Output; package Z

private[scalqa] class Bytes(os: java.io.OutputStream) extends Base[java.io.OutputStream](os) with Output with Output.Bytes {

  def asText = new Text(real)
  def asBytes = this
  def asData = new Data(real)
  override def asPrinter = asText.asPrinter

  // ------------------------------------------------------------------------------------------

  def writeByte(b: Int) = real.write(b)

  def write(ba: Array[Byte]) = real.write(ba.bytes)

  def write(ba: Array[Byte], off: Int, len: Int) = real.write(ba.bytes, off, len)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/