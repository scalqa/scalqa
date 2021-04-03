package scalqa;  package `def`; package double; package custom; import language.implicitConversions

abstract class Type[A<:Opaque.Double](val name:String) extends Opaque.Type[A](ClassTag.Double.cast[ClassTag[A]]) with Info.Tag.Void.Doubles[A]:

  override def isVoid(v: A): Boolean=false

  given xxTagVoid: Info.Tag.Void.Doubles[A]=this

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

*/