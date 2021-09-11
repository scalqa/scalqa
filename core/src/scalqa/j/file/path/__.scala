package scalqa; package j; package file; import language.implicitConversions

import java.nio.file.{ Path => REAL }
import File.Path

object Path extends AnyRef.Opaque.Base[Path,REAL]("J.Path") with path._methods:
  inline          def apply(v: REAL)                 : Path    = v.toOpaque
  /**/            def current                        : Path    = void.real.toAbsolutePath.toOpaque
  /**/            def apply(s:String, more:String*)  : Path    = File.System().path(s, more *)
  /**/            def apply(names: ~[String])        : Path    = File.System().path(names)
  @tn("getVoid")  def void                           : Path    = File.System().real.getPath("")
  private[j]      def any(v: Any)                    : Path    = v match { case v: REAL => apply(v); case v => apply(v.toString) }
  override        def value_isVoid(v: Path)          : Boolean = v.real.startsWith("")
  override        def value_tag(v: Path)             : String  = v.real.toString
  override        def value_doc(v: Path)             : Doc     = super.value_doc(v) += ("size",v.size)

  implicit inline def implicitFrom(v: \/)            : Path    = void
  implicit inline def implicitFrom(inline v: REAL)   : Path    = v.toOpaque
  implicit inline def implicitFrom(inline v: String) : Path    = apply(v)
  implicit inline def implicitFrom(inline v: J.File) : Path    = v.path
  implicit inline def implicitFrom(v: CURRENT)       : Path    = current

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

   [[J.Path]] is an opaque value, backed by java.nio.file.Path

@def void  -> Get void instance

@def implicitFrom    -> General void instance request \n\n It is possible to use general request \\/ to get void instance of this type, thanks to this implicit conversion.

*/