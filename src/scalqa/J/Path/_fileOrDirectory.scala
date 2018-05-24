package scalqa; package J; package Path

trait _fileOrDirectory extends Any with __ {

  def fileOpt: Opt.orError[J.File] = real.toFile.I.to(f =>
    if (!f.exists) Opt.orError.getError("File does not exist: " + f)
    else if (f.isDirectory) Opt.orError.getError("Path is a directory: " + f)
    else new J.File(f))

  def file: J.File = fileOpt.value

  def fileMake: J.File = real.toFile.I.to(f => {
    if (f.isDirectory) Fail("Path is a directory: " + f)
    if (!f.getParentFile.exists) f.getParentFile.mkdir
    if (!f.exists) f.createNewFile
    new J.File(f)
  })

  def directoryOpt: Opt.orError[J.File.Directory] = real.toFile.I.to(f =>
    if (!f.exists) Opt.orError.getError("Directory does not exist: " + f)
    else if (f.isFile) Opt.orError.getError("Path is a file: " + f)
    else new J.File.Directory(f))

  def directory: J.File.Directory = directoryOpt.value

  def directoryMake: J.File.Directory = real.toFile.I.to(f => {
    if (f.isFile) Fail("Path is a file: " + f)
    if (!f.exists) f.mkdirs
    new J.File.Directory(f)
  })

  def make: J.Path = {
    if (!This.exists) if (This.last.contains(".")) fileMake else directoryMake
    This
  }
}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @def make -> Makes file or directory
 *
 *     If file of directory specified by this [[Path]] does not exist, it will be created
 *
 *     Note, when creating, the [[_names.lastName Path.lastName]] is checked
 *
 *     If it contains period (the extension separator), a file will be created
 *
 *     Otherwise a directory will be created
 *
 * @def directoryOpt -> File
 *
 *     Optionally returns directory, specified by this [[Path]] if it exists
 *
 *     {{{
 *       val p: J.Path = "C:" ~ "Temp" ~ "Xyz"
 *
 *       p.directoryOpt lp // Most likely prints: Opt.Error(Directory does not exist: C:\Temp\Xyz)
 *
 *       p.directoryMake
 *
 *       p.directoryOpt lp // Most likely prints: Opt(C:\Temp\Xyz)
 *     }}}
 *
 * @def directory: -> File
 *
 *     Returns directory, specified by this [[Path]]
 *
 *     Fails if the directory does not exist
 *
 * @def directoryMake: -> File
 *
 *     Returns directory, specified by this [[Path]]
 *
 *     If directory does not exist, it will be created
 *     {{{
 *       val p: J.Path = "C:" ~ "Temp" ~ "Xyz"
 *
 *       p.directoryOpt lp // Most likely prints: Opt.Error(Directory does not exist: C:\Temp\Xyz)
 *
 *       p.directoryMake
 *
 *       p.directoryOpt lp // Most likely prints: Opt(C:\Temp\Xyz)
 *     }}}
 *
 * @def fileOpt -> File
 *
 *     Optionally returns file, specified by this [[Path]] if it exists
 *     {{{
 *        val p: J.Path = "C:" ~ "Temp" ~ "Xyz.txt"
 *
 *        p.fileOpt lp  // Most likely prints: Opt.Error(File does not exist: C:\Temp\Xyz.txt)
 *
 *        p.fileMake
 *
 *        p.fileOpt lp  // Most likely prints: Opt(C:\Temp\Xyz.txt)
 *     }}}
 *
 * @def file: -> File
 *
 *     Returns file, specified by this [[Path]]
 *
 *     Fails if the file does not exist
 *
 * @def fileMake: -> File
 *
 *     Returns file, specified by this [[Path]]
 *
 *     If file does not exist, it will be created
 *     {{{
 *        val p: J.Path = "C:" ~ "Temp" ~ "Xyz.txt"
 *
 *        p.fileOpt lp  // Most likely prints: Opt.Error(File does not exist: C:\Temp\Xyz.txt)
 *
 *        p.fileMake
 *
 *        p.fileOpt lp  // Most likely prints: Opt(C:\Temp\Xyz.txt)
 *     }}}
 */
