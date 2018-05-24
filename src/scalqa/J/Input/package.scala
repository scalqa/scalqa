package scalqa; package J

package object Input {

  def get(is: java.io.InputStream): Input = new Z.Bytes(is)

  def get(ba: Array[Byte]): Input = get(new java.io.ByteArrayInputStream(ba.bytes))

  def get(ba: Array[Byte], offs: Int, length: Int): Input = get(new java.io.ByteArrayInputStream(ba.bytes, offs, length))

  def get(text: String): Input = get(text.getBytes)

  def get(f: File): Input = get(new java.io.FileInputStream(f.real))

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/