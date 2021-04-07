package scalqa;  package lang; package int; package custom; import language.implicitConversions

abstract class Type[A<:Opaque.Int](val name:String) extends Opaque.Companion[A](ClassTag.Int.cast[ClassTag[A]]) with Def.Void.Ints[A]:

  override def isVoid(v: A): Boolean=false

  given xxDefVoid: Def.Void.Ints[A]=this

  extension(inline x: A)
    inline def real: Int = x.cast[Int]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@class Type -> ### Int Opaque Type Base

*/