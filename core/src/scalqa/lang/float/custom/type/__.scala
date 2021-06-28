package scalqa;  package lang; package float; package custom; import language.implicitConversions

abstract class Type[A<:Opaque.Float](val name:String) extends Opaque.Companion[A](ClassTag.Float.cast[ClassTag[A]]) with gen.`given`.VoidTag.RawFloat[A]:

  override def isVoid(v: A): Boolean=false

  given givenVoidTag: Given.VoidTag.RawFloat[A]=this

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

  Custom Type is like more widely used [Custom Data](../../../../../guide/features/Data.html),
  but without attached containers.  Type instances will still be processed by streams without boxing.

*/
