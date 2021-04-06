package scalqa; package lang; package short; import language.implicitConversions

object Custom:
  type Type[A<:Opaque.Short] = custom.Type[A]
  type Data[A<:Opaque.Short] = custom.Data[A];       inline def Data      = custom.Data
  type Framework[A<:RAW]         = custom.Framework[A];  inline def Framework = custom.Framework
  /**/                                                   inline def Companion = custom.framework.Companion

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
