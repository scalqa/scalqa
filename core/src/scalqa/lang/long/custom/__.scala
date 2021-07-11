package scalqa; package lang; package long; import language.implicitConversions

object Custom:
  type Type[A<:Opaque.Long] = custom.Type[A];        transparent inline def Type       = custom.Type
  type Data[A<:Opaque.Long] = custom.Data[A];        transparent inline def Data       = custom.Data
  type Containers[A<:RAW]   = custom.Containers[A];  transparent inline def Containers = custom.Containers
  /**/                                               transparent inline def Companion  = custom.containers.Companion

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
