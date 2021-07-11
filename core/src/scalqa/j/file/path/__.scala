package scalqa; package j; package file; import language.implicitConversions

import java.nio.file.{ Path => PATH }
import File.Path

object Path extends Any.Ref.Custom.Type[Path,PATH]("J.Path") with path._methods:
  inline          def apply(v: PATH)                : Path    = v.asOpaque[Path]
  /**/            def apply()                       : Path    = void.real.toAbsolutePath.asOpaque[Path]
  /**/            def apply(s:String, more:String*) : Path    = File.System().path(s, more *)
  /**/            def apply(names: ~[String])       : Path    = File.System().path(names)
  @tn("getVoid")  def void                          : Path    = File.System().real.getPath("")
  private[j]      def any(v: Any)                   : Path    = v match { case v: PATH => apply(v); case v => apply(v.toString) }
  override        def isVoid(v: Path)               : Boolean = v.real.startsWith("")
  override        def tag(v: Path)                  : String  = v.real.toString
  override        def doc(v: Path)                  : Doc     = super.doc(v) += ("size",v.size)

  implicit inline def implicitFromReal(v: PATH)        : Path = v.asOpaque[Path]
  implicit inline def implicitFromString(v: String)    : Path = apply(v)
  implicit inline def implicitFromFile(v: J.File)      : Path = v.path
  implicit inline def implicitRequest(inline v: \/): Path = void

  object opaque:
    opaque type `type` <: Opaque.Ref = PATH & Opaque.Ref
/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@object opaque -> ###

   [[J.Path]] is an opaque value, backed by java.nio.file.Path

@def void  -> Get void instance

@def implicitRequest -> General void instance request \n\n It is possible to use general request \\/ to get void instance of this type, thanks to this implicit conversion.

*/