package scalqa; package lang; package int; package custom; import language.implicitConversions

abstract class Data[A<:Opaque.Int](typeName: String) extends Type[A](typeName) with Framework[A]

object Data:

  // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  type Ordered   [A<:Opaque.Int] = data.Ordered[A]
  type Sequential[A<:Opaque.Int] = data.Sequential[A]
  type Numerical   [A<:Opaque.Int] = data.Numerical[A]
  type Number    [A<:Opaque.Int] = data.Number[A]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@class Data -> ### Int Data Type Base

  [[Data]] not only defines a Int based opaque type, but also privides a framework of custom specialized containers attached to this type.

*/