package scalqa; package j; package zip; import language.implicitConversions

trait Format[A]:
  protected def createEntryName(v: A)                 : String
  protected def read(name: String, i: J.Input)        : A
  protected def write(name: String, o: J.Output, v: A): Unit

  def load(file: J.File, entryNamefilter: String => Boolean=VOID): Stream[A] =
    val tracer = activityTrace(100)
    Zip.load(file)
      .peek(_ => tracer())
      .parallel
      .map((n,in) => read(n, in()))
      .stream

  def save(file: J.File, entries: Stream[A]): Unit =
    val tracer = activityTrace(100)
    Zip.save(file, entries
      .peek(_ => tracer())
      .parallel
      .map(v => {
        val name = createEntryName(v)
        val buf = J.Output.Buffer(1000)
        write(name, buf, v);
        buf.flush
        (name, Pro(J.Input(buf.bytes)))
      })
      .stream)

  private def activityTrace(showEveryNth: Int): () => Any =
    var i = 0
    var ch = 'a'
    () =>
      i += 1
      if (i > 1 && i % showEveryNth == 0)
        print(ch);
        ch = (ch + 1).toChar
        if (ch > 'z') ch = 'a'

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
