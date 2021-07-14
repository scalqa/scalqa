package scalqa;  package lang; package boolean; package custom; import language.implicitConversions

abstract class Type[A<:Opaque.Boolean](val typeName:String) extends Opaque.Companion[A](ClassTag.Boolean.cast[ClassTag[A]]) with gen.`given`.VoidTag.RawBoolean[A] with Type._methods[A]:

  override def isVoid(v: A): Boolean=false

  given givenVoidTag: Given.VoidTag.RawBoolean[A]=this

object Type:

  trait _methods[A<:RAW]:
    extension(inline x: A)
      inline def real: Boolean = x.cast[Boolean]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@class Type -> ### Boolean Custom Type Setup

  Custom Type is like more widely used [Custom Data](../../../../../guide/features/Data.html),
  but without attached containers.  Type instances will still be processed by streams without boxing.

@trait _methods -> ### Custom Type Default Methods

@def real -> Real value \n\n  Returns real value standing behind the opaque type

*/
