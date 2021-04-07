package scalqa;  package lang; package float; package custom; import language.implicitConversions

abstract class Type[A<:Opaque.Float](val name:String) extends Opaque.Companion[A](ClassTag.Float.cast[ClassTag[A]]) with Def.Void.Floats[A]:

  override def isVoid(v: A): Boolean=false

  given xxDefVoid: Def.Void.Floats[A]=this

  extension(inline x: A)
    inline def real: Float = x.cast[Float]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@class Type -> ### Float Opaque Type Base

*/