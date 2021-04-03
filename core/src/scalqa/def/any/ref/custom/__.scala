package scalqa; package `def`; package any; package ref; import language.implicitConversions

object Custom:
  type Type[A<:Opaque.Ref, BASE<:Ref] = custom.Type[A,BASE]
  type Data[A<:Opaque.Ref, BASE<:Ref] = custom.Data[A,BASE];      inline def Data      = custom.Data
  type Framework[A]                   = custom.Framework[A];      inline def Framework = custom.Framework

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
