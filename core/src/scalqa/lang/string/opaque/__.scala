package scalqa; package lang; package string; import language.implicitConversions

object Opaque:
  type Base[A<:Opaque] = opaque.Base[A];    transparent inline def Base       = opaque.Base
  type Data[A<:Opaque] = opaque.Data[A];    transparent inline def Data       = opaque.Data

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@object Opaque ->
  Opaque type is defined as
  ```
  object String:
    opaque type Opaque <: AnyRef.Opaque  = java.lang.String & AnyRef.Opaque
  ```

  It must be the base for all String opaque types

  The reason to have String.Opaque vs. AnyRef.Opaque based types, is that String.Opaque will inherit a large library of methods, same a String itself does.
  String.Opaque will behave like a regular String, but be different from a String.  If this behaviour is not desirable, use AnyRef.Opaque.Base even with String opaques.

*/