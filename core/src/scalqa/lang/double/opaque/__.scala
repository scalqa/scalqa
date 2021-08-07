package scalqa; package lang; package double; import language.implicitConversions

object Opaque:
  type Base[A<:Opaque] = opaque.Base[A]
  type Data[A<:Opaque] = opaque.Data[A];        transparent inline def Data       = opaque.Data

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
  object Double:
    opaque type Opaque >: Double <: AnyVal = Double
  ```

  It must be the base for all Double opaque types

*/