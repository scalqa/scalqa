package scalqa; package lang; package char; import language.implicitConversions

object Opaque:
  type Base[A<:Opaque] = opaque.Base[A]
  type Data[A<:Opaque] = opaque.Data[A];        transparent inline def Data       = opaque.Data

  object TYPE:
    opaque type DEF >: Char <: AnyVal = Char

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@type DEF  ->

  Char.Opaque is the supertype for all opaques based on Char

*/
