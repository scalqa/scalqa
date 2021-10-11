package scalqa; package lang; package anyref; import language.implicitConversions

object Opaque:
  type Base[A<:Opaque, REAL<:AnyRef] = opaque.Base[A,REAL];    transparent inline def Base       = opaque.Base
  type Data[A<:Opaque, REAL<:AnyRef] = opaque.Data[A,REAL];    transparent inline def Data       = opaque.Data

  object TYPE:
    opaque type DEF <: AnyRef = AnyRef

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@type DEF  ->

  AnyRef.Opaque is the supertype for all reference based opaque types

  As an example look into [J.File.Store](../../../j/file/Store$.html)  with source code [available](https://github.com/scalqa/scalqa/blob/master/core/src/scalqa/j/file/Store.scala).

*/