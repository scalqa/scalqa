package scalqa;  package lang; package boolean; package custom; import language.implicitConversions

abstract class Type[A<:Opaque.Boolean](val name:String) extends Opaque.Companion[A](ClassTag.Boolean.cast[ClassTag[A]]) with Self.VoidTag.Booleans[A]:

  override def isVoid(v: A): Boolean=false

  given givenVoidTag: Self.VoidTag.Booleans[A]=this

  extension(inline x: A)
    inline def real: Boolean = x.cast[Boolean]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@class Type -> ### Boolean Opaque Type Base

*/
