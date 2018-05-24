package scalqa; package J; package File

import java.nio.file.Files
import java.nio.file.StandardCopyOption._

class _Class private[J] (f: JFile) extends Z.Like(f) {

  def delete: Boolean = real.delete

  def extension: String = real.getCanonicalPath.copyAfterLast(".", "")

  def size: Byte.Size = real.length

  def move(target: Path, overwrite: Boolean = false): File = {
    target.parent.directoryMake
    Path.get(Files.move(path.real, target.real, overwrite.opt(REPLACE_EXISTING).all.to[Seq]: _*)).file
  }

  def newTemp: File = (0 <> 100).all.
    map(i => name + ".temp" + { (i == 0) ? ("", i.toString) }).
    map(App.Pro.TempPathOpt().or(path.copyShort(1)) + _).
    drop(_.fileOpt).
    map(_.fileMake).
    firstOpt or Fail("Could not create temp file for:", this)

  def openOutput = Output.get(this)

  def openInput = Input.get(this)

  def readString = openInput.asText.readAllAndClose

  def writeString(s: String) = { if (exists) delete; openOutput.asText.writeAllAndClose(s) }

  def copy(p: Path, overwrite: Boolean = false, copyAttributes: Boolean = false): File = {
    p.parent.directoryMake
    Path.get(Files.copy(path.real, p.real, (overwrite.opt(REPLACE_EXISTING).all ~~ copyAttributes.opt(COPY_ATTRIBUTES)).to[Seq]: _*)).file
  }
}

object _Class {

  implicit def zzGet(v: JFile) = new File(v)
}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @class _Class ->
 *
 *    [[File]] represents an ''existing'' file in the [[File.System]]
 *
 *    [[File]] does not have direct constructors
 *
 *    To create [[File]] one needs to start with [[J.Path]], which can point to both: existent and non existent resources
 *
 *    Note. [[File.Directory]] is a different entity
 *
 * @def copy -> Copy to new location
 *
 *     Copies ''this'' file to new location
 *
 *     Returns new [[File]]
 *     {{{
 *       val p: J.Path = "C:" ~ "Temp" ~ "Test.txt"
 *
 *       val f1: J.File = p.fileMake.I(_.writeString("Abc"))
 *
 *       val f2: J.File = f1.copy(p.parent + "Test2.txt")
 *
 *       f2 lp            // Prints: C:\Temp\Test2.txt
 *
 *       f2.readString lp // Prints: Abc
 *     }}}
 *
 * @def readString -> Read as String
 *
 *     Reads ''this'' file as String
 *
 *     Full code = {{{ openInput.asText.readAllAndClose }}}
 *
 * @def readString -> Read as String
 *
 *     Reads ''this'' file as String
 *
 *     Full code = {{{ openInput.asText.readAllAndClose }}}
 *
 * @def writeString -> Write String
 *
 *     Writes String to ''this'' file, overwriting prior data
 *
 *     Full code =
 *     {{{
 *       if (exists) delete;
 *       openOutput.asText.writeAllAndClose(s)
 *     }}}
 *
 * @def openOutput -> Create output
 *
 *     Opens [[J.Output]] to ''this'' file
 *
 * @def openInput -> Create input
 *
 *     Opens [[J.Input]] to ''this'' file
 *
 * @def delete -> Delete file
 *
 *    Deletes file
 *
 * @def extension -> File extension
 *
 *    Returns the part of file name after last period
 *
 *    If no period in file name, empty String is returned
 *
 *    {{{
 *       val p: J.Path = "C:" ~ "Temp" ~ "Test.txt"
 *
 *       val f: J.File = p.fileMake
 *
 *       f.path lp       // Prints: C:\Temp\Test.txt
 *
 *       f.name lp       // Prints: Test.txt
 *
 *       f.extension lp  // Prints: txt
 *    }}}
 * @def size -> File size
 *
 *    Returns file [[Byte.Size]]
 *
 *    {{{
 *       val p: J.Path = "C:" ~ "Temp" ~ "Test.txt"
 *
 *       val f: J.File = p.fileMake
 *
 *       f.writeString("ABC" * 1000)
 *
 *       f.size lp // Prints: 3.0kB
 *    }}}
 *
 * @def move -> Move file
 *
 *     Returns new [[File]]
 *
 *     {{{
 *       val p: J.Path = "C:" ~ "Temp" ~ "Test.txt"
 *
 *       val f1: J.File = p.fileMake.I(_.writeString("Abc"))
 *
 *       val f2: J.File = f1.move(p.parent + "Test2.txt")
 *
 *       f2 lp            // Prints: C:\Temp\Test2.txt
 *
 *       f2.readString lp // Prints: Abc
 *     }}}
 *
 * @def newTemp -> Creates temporary file
 *
 *     Creates new temporary file with ''this'' file as base
 *
 *     if App.Pro.TempPathOpt is available, this will be the directory, otherwise ''this'' file directory will be used
 *
 *     Temporary file name will be ''this.name' plus '.temp' or '.temp1' or '.temp2' or '.temp3' or etc. if exists
 *     {{{
 *       val p: J.Path = "C:" ~ "Temp" ~ "Test.txt"
 *
 *       val f: J.File = p.fileMake
 *
 *       f.newTemp lp // Prints: C:\Temp\Test.txt.temp
 *
 *       f.newTemp lp // Prints: C:\Temp\Test.txt.temp1
 *
 *       f.newTemp lp // Prints: C:\Temp\Test.txt.temp2
 *     }}}
 */
