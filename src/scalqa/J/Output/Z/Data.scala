package scalqa; package J; package Output; package Z

private[scalqa] class Data(os: java.io.OutputStream) extends Base[java.io.OutputStream](os) with Output.Data {
  private val dos = real match { case v: java.io.DataOutputStream => v; case v => new java.io.DataOutputStream(v) }

  override def flush: this.type = { dos.flush; super.flush }

  def boolean(v: Boolean): this.type = { dos.writeBoolean(v); this }

  def byte(v: Int): this.type = { dos.writeByte(v); this }

  def short(v: Int): this.type = { dos.writeShort(v); this }

  def char(v: Int): this.type = { dos.writeChar(v); this }

  def int(v: Int): this.type = { dos.writeInt(v); this }

  def long(v: Long): this.type = { dos.writeLong(v); this }

  def float(v: Float): this.type = { dos.writeFloat(v); this }

  def double(v: Double): this.type = { dos.writeDouble(v); this }

  def bytes(v: String): this.type = { dos.writeBytes(v); this }

  def chars(v: String): this.type = { dos.writeChars(v); this }

  def utf(v: String): this.type = { dos.writeUTF(v); this }

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/