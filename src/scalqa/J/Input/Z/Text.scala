package scalqa; package J; package Input; package Z

private[J] class Text(is: java.io.InputStream) extends Base(is) with Input.Text {

  def read(byteLimit: Long): String = {
    var cnt = 0L;
    val sw = new java.io.StringWriter
    val isr = new java.io.InputStreamReader(real)
    val ca = new Array.Raw[Char](500)
    var i = isr.read(ca)
    while (i > -1 && cnt <= byteLimit) { cnt += i; sw.write(ca, 0, i); i = isr.read(ca) }
    sw.getBuffer.toString
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/