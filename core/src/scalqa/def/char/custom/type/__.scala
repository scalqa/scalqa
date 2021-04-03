package scalqa;  package `def`; package char; package custom; import language.implicitConversions

abstract class Type[A<:Opaque.Char](val name:String) extends Opaque.Type[A](ClassTag.Char.cast[ClassTag[A]]) with Info.Tag.Void.Chars[A]:

  override def isVoid(v: A): Boolean=false

  given xxTagVoid: Info.Tag.Void.Chars[A]=this

  extension(inline x: A)
    inline def real: Char = x.cast[Char]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@class Type -> ### Char Opaque Type Base

*/
