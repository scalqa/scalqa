package scalqa;  package lang; package boolean; package opaque; import language.implicitConversions

abstract class Data[A<:Opaque](name: String) extends Base[A](name) with Data._methods with g.companion.Containers[A]

object Data:

  transparent trait _methods extends Base._methods


/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@class Data -> ### Boolean Opaque Data Companion Object Base

  Opaque Data not only defines a Boolean based opaque type, but also privides a framework of custom specialized containers attached to this type.

  See [more in guide](../../../../../guide/features/Data.html).

  See [sample type definition](https://github.com/scalqa/samples/blob/master/src/example/opaque/all/BooleanData.scala).

@trait _methods -> Default methods for all Boolean.Opaque.Data defined types

*/