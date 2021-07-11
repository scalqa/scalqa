package scalqa;  package lang; package short; package custom; import language.implicitConversions

abstract class Type[A<:Opaque.Short](val name:String) extends Opaque.Companion[A](ClassTag.Short.cast[ClassTag[A]]) with gen.`given`.VoidTag.RawShort[A] with Type._methods[A]:

  override def isVoid(v: A): Boolean=false

  given givenVoidTag: Given.VoidTag.RawShort[A]=this

object Type:

  trait _methods[A<:RAW]:
    extension(inline x: A)
      inline def real: Short = x.cast[Short]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@class Type -> ### Short Custom Type Setup

  Custom Type is like more widely used [Custom Data](../../../../../guide/features/Data.html),
  but without attached containers.  Type instances will still be processed by streams without boxing.

*/
