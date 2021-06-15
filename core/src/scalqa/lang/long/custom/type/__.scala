package scalqa;  package lang; package long; package custom; import language.implicitConversions

abstract class Type[A<:Opaque.Long](val name:String) extends Opaque.Companion[A](ClassTag.Long.cast[ClassTag[A]]) with gen.`given`.VoidTag.RawLong[A]:

  override def isVoid(v: A): Boolean=false

  given givenVoidTag: Given.VoidTag.RawLong[A]=this

  extension(inline x: A)
    inline def real: Long = x.cast[Long]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@class Type -> ### Long Opaque Type Base

*/
