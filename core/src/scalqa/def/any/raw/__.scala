package scalqa; package `def`; package any; import language.implicitConversions

object Raw:
  type Boolean  = scala.Boolean | Opaque.Boolean
  type Byte     = scala.Byte    | Opaque.Byte
  type Char     = scala.Char    | Opaque.Char
  type Short    = scala.Short   | Opaque.Short
  type Int      = scala.Int     | Opaque.Int
  type Long     = scala.Long    | Opaque.Long
  type Float    = scala.Float   | Opaque.Float
  type Double   = scala.Double  | Opaque.Double

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@object Raw -> ###

  [[Any.Raw]] contains all root raw types, which are based on Java primitive values

*/