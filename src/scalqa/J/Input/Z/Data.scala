package scalqa; package J; package Input; package Z

import java.io.{ DataInputStream => DIS }

private[J] class Data protected[Input] (s: java.io.InputStream) extends Base(s) with Input.Data {
  val dis = s match { case v: DIS => v; case v => new DIS(v) }

  def readFully(ba: Array[Byte]) = dis.readFully(ba.bytes)

  def readFully(ba: Array[Byte], off: Int, len: Int) = dis.readFully(ba.bytes, off, len)

  def skipBytes(n: Int): Int = dis.skipBytes(n)

  def boolean = dis.readBoolean

  def byte: Byte = dis.readByte

  def unsignedByte: Int = dis.readUnsignedByte

  def short: Short = dis.readShort

  def unsignedShort: Int = dis.readUnsignedShort

  def char: Char = dis.readChar

  def int: Int = dis.readInt

  def long: Long = dis.readLong

  def float: Float = dis.readFloat

  def double: Double = dis.readDouble

  def utf: String = dis.readUTF
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
