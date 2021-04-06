package scalqa; package lang; package long; package custom; import language.implicitConversions

abstract class Data[A<:Opaque.Long](typeName: String) extends Type[A](typeName) with Framework[A]

object Data:
  type Ordered[A<:Opaque.Long] = data.Ordered[A]
  type Numerical[A<:Opaque.Long] = data.Numerical[A]
  type Number [A<:Opaque.Long] = data.Number[A]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@class Data -> ### Long Data Type Base

  [[Data]] not only defines a Long based opaque type, but also privides a framework of custom specialized containers attached to this type.

*/