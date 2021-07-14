package scalqa; package lang; package string; import language.implicitConversions

object Custom:
  type Type[A<:Opaque.String] = custom.Type[A];        transparent inline def Type       = custom.Type
  type Data[A<:Opaque.String] = custom.Data[A] //;        transparent inline def Data       = custom.Data

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
