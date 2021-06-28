package scalqa; package lang; package short; package custom; import language.implicitConversions

abstract class Data[A<:Opaque.Short](typeName: String) extends Type[A](typeName) with Framework[A]

object Data:
  type Ordered  [A<:Opaque.Short] = data.Ordered[A]
  type Numerical[A<:Opaque.Short] = data.Numerical[A]
  type Number   [A<:Opaque.Short] = data.Number[A]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@class Data -> ### Short Data Type Base

  Custom Data not only defines a Short based opaque type, but also privides a framework of custom specialized containers attached to this type.

  See [more in guide](../../../../../guide/features/Data.html).
*/