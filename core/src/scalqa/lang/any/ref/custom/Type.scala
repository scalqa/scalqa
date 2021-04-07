package scalqa; package lang; package any; package ref; package custom; import language.implicitConversions

abstract class Type[A<:Opaque.Ref, BASE<:Any.Ref](val name: String)(using ct: ClassTag[BASE]) extends Opaque.Companion[A](ct.cast[ClassTag[A]]):

  given xxDefVoid  : Def.Void[A]  = this

  extension(inline x: A)
    inline def real: BASE = x.cast[BASE]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@class Type -> ### Any.Ref Opaque Type Base

*/