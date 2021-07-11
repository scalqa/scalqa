package scalqa; package lang; package any; package ref; import language.implicitConversions

object Custom:
  type Type[A<:Opaque.Ref, BASE<:Ref] = custom.Type[A,BASE];    transparent inline def Type       = custom.Type
  type Data[A<:Opaque.Ref, BASE<:Ref] = custom.Data[A,BASE];    transparent inline def Data       = custom.Data
  type Containers[A]                  = custom.Containers[A];   transparent inline def Containers = custom.Containers

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
