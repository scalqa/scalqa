package scalqa; package j; package zip; import language.implicitConversions

import java.util.zip.{ ZipOutputStream, ZipEntry, ZipFile}

object Z:
  val NoZipEntries = "NoZipEntries"

  def loadFromFile(file: J.File, entryNamefilter: String => Boolean=VOID): Stream[(String, Pro[J.Input])] =
    val zf = new ZipFile(file.real)
    Stream.fromEnumeration(zf.entries)
      .take(e => e.getName != NoZipEntries && entryNamefilter(e.getName))
      .map(e => (e.getName, Pro(J.Input(zf.getInputStream(e)))))

  // ------------------------------------------------------------------------------------------------------------------
  def saveToFile(f: J.File, entries: Stream[(String, Pro[J.Input])], level: Int): Unit =
    val zos = new ZipOutputStream(f.openOutput.real)
    zos.setLevel(level)
    val out = J.Output(zos).asBytes
    entries.foreach((n,p) => {
      zos.putNextEntry(new ZipEntry(n))
      if (p != null) out.write(p())
      zos.closeEntry
    })
    out.close

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
