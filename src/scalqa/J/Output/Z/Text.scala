package scalqa; package J; package Output; package Z

private[scalqa] class Text(os: java.io.OutputStream) extends Base[java.io.OutputStream](os) with Output.Text {
  private val writer = new java.io.OutputStreamWriter(real)

  override def flush: this.type = { writer.flush; super.flush }

  def string(v: String, range: Opt[Int.Range] = \/): this.type = { range.applyOr(r => writer.write(v, r.start, r.size), writer.write(v)); this }


  def array(v: Array[Char], range: Opt[Int.Range] = \/): this.type = { range.applyOr(r => writer.write(v.chars, r.start, r.size), writer.write(v.chars)); this }

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/