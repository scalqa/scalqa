package scalqa; package j; package file; import language.implicitConversions

import java.nio.file.{ FileSystem => JSystem }
import File.*

object System extends Any.Ref.Custom.Type[System,JSystem]("File.System"):
  def apply(): System = java.nio.file.FileSystems.getDefault.asOpaque[System]

  extension (x: System)
    @tn("store_Stream") def store_~                            : ~[Store] = x.real.getFileStores.iterator.~.map(Store(_))
    @tn("root_Stream")  def root_~                             : ~[Path]  = x.real.getRootDirectories.iterator.~.map(Path(_))
    /**/                def separator                          : String   = x.real.getSeparator
    /**/                def path(first: String, more: String*) : Path     = x.real.getPath(first, more *)
    /**/                def path(a: ~[String])                 : Path     = a.read_?.map(x.path(_, a.toSeq *)) or x.path("")

  object opaque:
    opaque type `type` <: Opaque.Ref = JSystem & Opaque.Ref

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@object opaque -> ###

   [[J.File.System]] is an opaque value, backed by java.nio.file.FileSystem

*/

