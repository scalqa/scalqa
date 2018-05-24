package scalqa; package J; package Output

trait Text extends Z.Like {

  def writeAllAndClose(v: String) = { string(v); close }

  def string(v: String, range: Opt[Int.Range] = \/): this.type

  def float(v: Float): this.type = { string(java.lang.String.valueOf(v)); this }

  def double(v: Double): this.type = { string(java.lang.String.valueOf(v)); this }

  def long(v: Long): this.type = { string(java.lang.String.valueOf(v)); this }

  def byte(v: Byte): this.type = { string(java.lang.String.valueOf(v)); this }

  def short(v: Short): this.type = { string(java.lang.String.valueOf(v)); this }

  def int(v: Int): this.type = { string(java.lang.String.valueOf(v)); this }

  def char(v: Char): this.type = { string(java.lang.String.valueOf(v)); this }

  def array(v: Array[Char], range: Opt[Int.Range] = \/): this.type

  override def flush: this.type

  def asPrinter: Printer = new Printer {
    def flush = { Text.this.flush; this }
    def close = Text.this.close;
    def print(s: String) = { Text.this.string(s); this }
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
