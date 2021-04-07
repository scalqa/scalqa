package scalqa; package lang; package byte; package custom; import language.implicitConversions

abstract class Data[A<:Opaque.Byte](typeName: String) extends Type[A](typeName) with Framework[A]

object Data:
  type Ordered[A<:Opaque.Byte] = data.Ordered[A]
  type Numerical[A<:Opaque.Byte] = data.Numerical[A]
  type Number [A<:Opaque.Byte] = data.Number[A]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@class Data -> ### Byte Data Type Base

  [[Data]] not only defines a Byte based opaque type, but also privides a framework of custom specialized containers attached to this type.

*/