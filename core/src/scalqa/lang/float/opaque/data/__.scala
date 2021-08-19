package scalqa; package lang; package float; package opaque; import language.implicitConversions

abstract class Data[A<:Opaque](name: String) extends Base[A](name) with Data._methods with g.customized.Containers[A]

object Data:

  transparent trait _methods extends Base._methods

  // Members ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  type Ordered   [A<:Opaque] = data.Ordered[A];    transparent inline def Ordered    = data.Ordered
  type Calculable[A<:Opaque] = data.Calculable[A]; transparent inline def Calculable = data.Calculable
  type Numerical [A<:Opaque] = data.Numerical[A];  transparent inline def Numerical  = data.Numerical

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@class Data -> ### Float Opaque Data Companion Object Base

  Opaque Data not only defines a Float based opaque type, but also privides a framework of custom specialized containers attached to this type.

  See [more in guide](../../../../../guide/features/Data.html).

@trait _methods -> Default methods for all Float.Opaque.Data defined types

*/