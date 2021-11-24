package scalqa; package j; package file; import language.implicitConversions

import java.nio.file.{ FileSystem => REAL }
import File.*

object System extends AnyRef.Opaque.Base[System,REAL]("File.System"):
  def apply(): System = java.nio.file.FileSystems.getDefault.toOpaque

  extension (inline x: System)
    inline def storeStream                                   : Stream[Store] = x.real.getFileStores.iterator.stream.map(Store(_))
    inline def rootStream                                    : Stream[Path]  = x.real.getRootDirectories.iterator.stream.map(Path(_))
    inline def separator                                     : String        = x.real.getSeparator
    inline def path(inline first:String, inline more:String*): Path          = x.real.getPath(first, more *)
    inline def path(inline a: Stream[String])                : Path          = {val p=x; a.readOpt.map(p.path(_, a.toSeq *)) or p.path("") }

  object TYPE:
    opaque type DEF <: AnyRef.Opaque = REAL & AnyRef.Opaque

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@type DEF  -> ###

   [[J.File.System]] is an opaque value, backed by java.nio.file.FileSystem

*/

