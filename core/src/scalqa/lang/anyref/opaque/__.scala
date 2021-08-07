package scalqa; package lang; package anyref; import language.implicitConversions

object Opaque:
  type Base[A<:Opaque, REAL<:AnyRef] = opaque.Base[A,REAL];    transparent inline def Base       = opaque.Base
  type Data[A<:Opaque, REAL<:AnyRef] = opaque.Data[A,REAL];    transparent inline def Data       = opaque.Data

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
  object AnyRef:
    opaque type Opaque <: AnyRef = AnyRef
  ```

  It must be the base for all Object opaque types

*/