package scalqa; package j; import language.implicitConversions

import java.util.zip.{ Deflater, Inflater}

object Zip:

  def load(file: J.File, entryNamefilter: String => Boolean = \/): ~[(String, Pro[J.Input])] = zip.Z.loadFromFile(file, entryNamefilter)

  def save(file: J.File, entries: ~[(String, Pro[J.Input])], level: Int = 1, writeEmptyFile: Boolean = true): Unit  =
    val stream = entries.enablePreview
    if(stream.preview_?.nonEmpty || writeEmptyFile)
      val tempFile = file.temp
      zip.Z.saveToFile(tempFile, stream, level)
      file.delete
      tempFile.move(file)

  def compress(data: Array[Byte]): Array[Byte] =
    val os = new java.io.ByteArrayOutputStream(data.length)
    new Deflater(Deflater.BEST_COMPRESSION) { setInput(data); finish; val b = new Array[Byte](1024); while (!finished) os.write(b, 0, deflate(b)) }
    os.close();
    os.toByteArray

  def decompress(data: Array[Byte]): Array[Byte] =
    val os = new java.io.ByteArrayOutputStream(data.length)
    new Inflater { setInput(data); val b = new Array[Byte](1024); while (!finished) os.write(b, 0, inflate(b)) }
    os.close
    os.toByteArray

  // Members ~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  type Format[A] = zip.Format[A]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@object Zip -> ### Zip Utilities

*/
