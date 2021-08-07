package scalqa; package lang; package any; import language.implicitConversions

object Opaque:

  // Members ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  type Base[A <: Any.Opaque] = opaque.Base[A];   transparent inline def Base = opaque.Base

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@object Opaque -> ###

  Any.Opaque type is defined as
  ```
  object Any:
    type Opaque = AnyRef.Opaque | Boolean.Opaque | Byte.Opaque | Char.Opaque | Short.Opaque | Int.Opaque | Long.Opaque | Float.Opaque | Double.Opaque
  ```

*/