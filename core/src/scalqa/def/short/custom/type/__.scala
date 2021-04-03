package scalqa;  package `def`; package short; package custom; import language.implicitConversions

abstract class Type[A<:Opaque.Short](val name:String) extends Opaque.Type[A](ClassTag.Short.cast[ClassTag[A]]) with Info.Tag.Void.Shorts[A]:

  override def isVoid(v: A): Boolean=false

  given xxTagVoid: Info.Tag.Void.Shorts[A]=this

  extension(inline x: A)
    inline def real: Short = x.cast[Short]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@class Type -> ### Short Opaque Type Base

*/
