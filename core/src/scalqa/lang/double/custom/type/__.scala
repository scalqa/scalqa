package scalqa;  package lang; package double; package custom; import language.implicitConversions

abstract class Type[A<:Opaque.Double](val name:String) extends Opaque.Companion[A](ClassTag.Double.cast[ClassTag[A]]) with gen.`given`.VoidTag.RawDouble[A]:

  override def isVoid(v: A): Boolean=false

  given givenVoidTag: Given.VoidTag.RawDouble[A]=this

  extension(inline x: A)
    inline def real: Double = x.cast[Double]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@class Type -> ### Double Opaque Type Base

  Custom Type is like more widely used [Custom Data](../../../../../guide/features/Data.html),
  but without attached containers.  Type instances will still be processed by streams without boxing.

*/