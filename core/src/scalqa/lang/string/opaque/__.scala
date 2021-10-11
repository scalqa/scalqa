package scalqa; package lang; package string; import language.implicitConversions

object Opaque:
  type Base[A<:Opaque] = opaque.Base[A];    transparent inline def Base       = opaque.Base
  type Data[A<:Opaque] = opaque.Data[A];    transparent inline def Data       = opaque.Data

  object TYPE:
    opaque type DEF <: AnyRef.Opaque  = java.lang.String & AnyRef.Opaque

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@type DEF  ->

  String.Opaque is a supertype for all String based opaque types

  The reason to have String.Opaque vs. AnyRef.Opaque based types, is that String.Opaque will inherit a large library of methods, same a String itself does.
  String.Opaque will behave like a regular String, but be different from a String.  If this behaviour is not desirable, use AnyRef.Opaque.Base even with String opaques.

  See [sample type definition](https://github.com/scalqa/samples/blob/master/src/example/opaque/all/OpaqueString.scala).

*/