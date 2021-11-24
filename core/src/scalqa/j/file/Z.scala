package scalqa; package j; package file; import language.implicitConversions

import java.nio.file.Files
import java.nio.file.StandardCopyOption.*
import File.Path

object Z:

  def writeString(f: J.File, s: String) =
    if (f.exists) f.delete
    f.path.parent.make
    f.openOutput.asText.writeAllAndClose(s)

  def move(f: J.File, target: Path, overwrite: Boolean = false): J.File =
    target.parent.make
    Path(Files.move(f.path.real, target.real, (overwrite ? REPLACE_EXISTING).stream.toSeq *)).file

  def copy(f: J.File, p: Path, overwrite: Boolean = false, copyAttributes: Boolean = false): J.File =
    p.parent.make
    Path(Files.copy(f.path.real, p.real, ((overwrite ? REPLACE_EXISTING).stream ++ copyAttributes ? COPY_ATTRIBUTES).toSeq *)).file

  def tempFile(f: J.File): J.File =
      (0 <> 100).stream
        .map(i => f.name + ".temp" + { if (i == 0) "" else i.toString })
        .map((Vm.Setup.tempPathOpt or f.path.dropLast(1)) + _)
        .drop(_.exists)
        .map(_.file)
        .readOpt or (J.illegalState("Could not create temp file for: " + this))

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/