package scalqa; package lang; package string; package opaque; import language.implicitConversions

abstract class Data[A<:Opaque](name: String) extends Base[A](name) with Data._methods with AnyRef.Containers[A]

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

  See [sample type definition](https://github.com/scalqa/samples/blob/master/src/example/opaque/all/StringData.scala).

@trait _methods -> ###

  _methods -> Default methods for all String.Opaque.Data defined types

  The default methods are largerly same as String Extension Methods

*/
