package scalqa; package J

import java.util.zip.{ ZipInputStream, ZipOutputStream, ZipEntry, Deflater, Inflater }

package object Zip {
  private val NoZipEntries = "NoZipEntries"

  def compress(data: Array[Byte]): Array[Byte] = {
    val os = new java.io.ByteArrayOutputStream(data.size)
    new Deflater(Deflater.BEST_COMPRESSION) { setInput(data.bytes); finish; val b = new Array.Raw[Byte](1024); while (!finished) os.write(b, 0, deflate(b)) }
    os.close();
    os.toByteArray
  }

  def decompress(data: Array[Byte]): Array[Byte] = {
    val os = new java.io.ByteArrayOutputStream(data.size)
    new Inflater { setInput(data.bytes); val b = new Array.Raw[Byte](1024); while (!finished) os.write(b, 0, inflate(b)) }
    os.close
    os.toByteArray
  }

  def saveFile(file: File, entries: ~[(String, J.Input)], zipLevelOpt: Opt[Int] = \/, writeEmptyFile: Boolean = true) {
    val it = entries.iterator
    val firstOpt = it.nextOpt
    if (!firstOpt && !writeEmptyFile) return ()
    val tempFile = file.newTemp
    val zos = new ZipOutputStream(tempFile.openOutput.asJavaOutputStream)
    zos.setLevel(zipLevelOpt or 1)
    val out = J.Output.get(zos).asBytes
    def add(t: (String, J.Input)) { zos.putNextEntry(new ZipEntry(t._1)); if (t._2 != null) out.write(t._2); zos.closeEntry }
    firstOpt(add).voidRun((NoZipEntries, null))
    it.all(add)
    out.close
    tempFile.move(file)
  }

  def loadFile(file: File, entryNamefilter: String => Boolean = s => true): ~[(String, J.Input)] = {
    new AllEntries(file)
      .drop(_._1 == NoZipEntries)
      .letBy(_._1, entryNamefilter)
      .map(_.map2(in => J.Input.get(in.asBytes.readAll)))
  }

  // **************************************************************************************************************************************************
  private class AllEntries(file: File) extends ~[(String, J.Input)] {
    val zis: ZipInputStream = new ZipInputStream(new java.io.FileInputStream(file.real));
    var done = false
    def supplyOpt = if (done) \/ else zis.getNextEntry.Opt.map(e => (e.getName, J.Input.get(zis))).voidRun { zis.close; done = true }
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
