package scalqa;  package lang; package boolean; package custom; import language.implicitConversions

abstract class Data[A<:Opaque.Boolean](typeName: String) extends Type[A](typeName) with Containers[A]

object Data

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@class Data -> ### Boolean Custom Data Setup

  Custom Data not only defines a Boolean based opaque type, but also privides a framework of custom specialized containers attached to this type.

  See [more in guide](../../../../../guide/features/Data.html).

*/