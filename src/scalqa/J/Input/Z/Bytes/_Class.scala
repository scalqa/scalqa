package scalqa; package J; package Input; package Z; package Bytes

private[J] class _Class(s: java.io.InputStream) extends Base(s) with Input with Input.Bytes {

  def asBytes = this

  def asData = new Data(real)

  def asText = new Z.Text(real)

  def buffer: Input = get(readAll).I.run(close)

  // -----------------------------------------------------------------------------------
  def read: Int = real.read

  def read(ba: Array[Byte], range: Opt[Int.Range] = \/): Int = range.map(r => real.read(ba.bytes, r.start, r.size)) or real.read(ba.bytes)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/