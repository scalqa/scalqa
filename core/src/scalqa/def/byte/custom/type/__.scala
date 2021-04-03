package scalqa;  package `def`; package byte; package custom; import language.implicitConversions

abstract class Type[A<:Opaque.Byte](val name:String) extends Opaque.Type[A](ClassTag.Byte.cast[ClassTag[A]]) with Info.Tag.Void.Bytes[A]:

  override def isVoid(v: A): Boolean=false

  given xxTagVoid: Info.Tag.Void.Bytes[A]=this

  extension(inline x: A)
    inline def real: Byte = x.cast[Byte]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@class Type -> ### Byte Opaque Type Base

*/
