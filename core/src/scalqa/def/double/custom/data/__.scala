package scalqa; package `def`; package double; package custom; import language.implicitConversions

abstract class Data[A<:Opaque.Double](typeName: String) extends Type[A](typeName) with Framework[A]

object Data:
  type Ordered[A<:Opaque.Double] = data.Ordered[A]
  type Numerical[A<:Opaque.Double] = data.Numerical[A]
  type Number [A<:Opaque.Double] = data.Number[A]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@class Data -> ### Double Data Type Base

  [[Data]] not only defines a Double based opaque type, but also privides a framework of custom specialized containers attached to this type.

*/