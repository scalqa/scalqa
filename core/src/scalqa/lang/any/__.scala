package scalqa; package lang; import language.implicitConversions

object Any:
  type _methods  = any._methods

  transparent inline def Opaque      = any.Opaque
  type Opaque    = AnyRef.Opaque | Boolean.Opaque | Byte.Opaque | Char.Opaque | Short.Opaque | Int.Opaque | Long.Opaque | Float.Opaque | Double.Opaque

  transparent inline def Raw         = any.Raw
  type Raw       = Boolean.Raw | Byte.Raw | Char.Raw | Short.Raw | Int.Raw | Long.Raw | Float.Raw | Double.Raw

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@object Any -> Companion to scala.Any

*/