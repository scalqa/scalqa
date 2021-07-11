package scalqa; package lang; package float; package custom; import language.implicitConversions

abstract class Data[A<:Opaque.Float](typeName: String) extends Type[A](typeName) with Containers[A]

object Data:
  type Ordered   [A<:Opaque.Float] = data.Ordered[A];    transparent inline def Ordered    = data.Ordered
  type Calculable[A<:Opaque.Float] = data.Calculable[A]; transparent inline def Calculable = data.Calculable
  type Numerical [A<:Opaque.Float] = data.Numerical[A];  transparent inline def Numerical  = data.Numerical

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@class Data -> ### Float Custom Data Setup

  Custom Data not only defines a Float based opaque type, but also privides a framework of custom specialized containers attached to this type.

  See [more in guide](../../../../../guide/features/Data.html).

*/