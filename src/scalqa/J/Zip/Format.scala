package scalqa; package J; package Zip

trait Format[A] {

  protected def onCreateEntryName: A => String

  protected def onRead: (String, J.Input) => A

  protected def onWrite: (String, J.Output, A) => Any

  def load(file: File, entryNamefilter: String => Boolean = s => true): ~[A] = {
    val tracer = activityTrace(100)
    loadFile(file)
      .trigger(tracer())
      .parallel
      .map(_.to(onRead))
      .sequential
  }

  def save(file: File, entries: ~[A]) {
    val tracer = activityTrace(100)
    saveFile(file, entries
      .trigger(tracer())
      .parallel
      .map(v => {
        val name = onCreateEntryName(v)
        val buf = J.Output.Buffer.get(1000);
        onWrite(name, buf, v);
        buf.flush
        (name, J.Input.get(buf.bytes))
      })
      .sequential)
  }

  private def activityTrace(showEveryNth: Int): (() => Any) = {
    var i = 0
    var ch = 'a'
    () => { i += 1; if (i > 1 && i % showEveryNth == 0) { print(ch); ch = (ch + 1).toChar ? (_ > 'z', _ => 'a') } }
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
