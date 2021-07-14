package scalqa; package lang; package string; package custom; import language.implicitConversions

import string.{ _Methods as X }

abstract class Data[A<:Opaque.String](typeName: String) extends Type[A](typeName) with Any.Ref.Custom.Containers[A]

object Data:

  transparent trait _methods[A<:Opaque.String] extends X._evaluate[A] with X._modify[A] with X._copy[A] with X._transform[A]

  object _methods:
    trait _evaluate [A<:Opaque.String] extends X._evaluate[A]
    trait _modify   [A<:Opaque.String] extends X._modify[A]
    trait _copy     [A<:Opaque.String] extends X._copy[A]
    trait _transform[A<:Opaque.String] extends X._transform[A]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@class Data -> ### String Custom Data Setup

  Custom Data not only defines a String based opaque type, but also privides a framework of customized containers attached to this type.

  See [more in guide](../../../../../guide/features/Data.html).

@trait _methods -> ### Default Methods

    This is the same set of methods as [String._methods](../_methods.html), but customized for defined type

*/
