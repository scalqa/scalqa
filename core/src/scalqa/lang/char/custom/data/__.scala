package scalqa; package lang; package char; package custom; import language.implicitConversions

abstract class Data[A<:Opaque.Char](typeName: String) extends Type[A](typeName) with Framework[A]

object Data:
  type Ordered[A<:Opaque.Char] = data.Ordered[A]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@class Data -> ### Char Data Type Base

  [[Data]] not only defines a Char based opaque type, but also privides a framework of custom specialized containers attached to this type.

*/