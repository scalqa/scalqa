package scalqa; package lang; package string; package opaque; import language.implicitConversions

abstract class Data[A<:Opaque](typeName: String) extends Base[A](typeName) with Data._methods with AnyRef.G.Customized.Containers[A]

object Data:

  transparent trait _methods extends _methods._evaluate with _methods._modify with _methods._copy

  object _methods:
    transparent trait _evaluate  extends base._methods._evaluate
    transparent trait _modify    extends base._methods._modify
    transparent trait _copy      extends base._methods._copy

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@class Data -> ### String Opaque Data Companion Object Base

  Opaque Data not only defines a String based opaque type, but also privides a framework of customized containers attached to this type.

  See [more in guide](../../../../../guide/features/Data.html).

@trait _methods -> ###

  Default methods largerly replicate String Extension Methods

*/
