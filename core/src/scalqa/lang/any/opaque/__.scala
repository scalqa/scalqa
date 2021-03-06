package scalqa; package lang; package any; import language.implicitConversions

import Any.Opaque

object Opaque:
  opaque type Boolean <: AnyVal & Opaque  = scala.Boolean    & Opaque
  opaque type Byte    <: AnyVal & Opaque  = scala.Byte       & Opaque
  opaque type Char    <: AnyVal & Opaque  = scala.Char       & Opaque
  opaque type Short   <: AnyVal & Opaque  = scala.Short      & Opaque
  opaque type Int     <: AnyVal & Opaque  = scala.Int        & Opaque
  opaque type Long    <: AnyVal & Opaque  = scala.Long       & Opaque
  opaque type Float   <: AnyVal & Opaque  = scala.Float      & Opaque
  opaque type Double  <: AnyVal & Opaque  = scala.Double     & Opaque
  opaque type Ref     <: AnyRef & Opaque  = scala.AnyRef     & Opaque
  opaque type String  <: Ref              = java.lang.String & Opaque

  // Members ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  type Companion[A<:Opaque] = opaque.Companion[A]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@object Opaque -> ###

  Opaque object contains all root opaque types.

  All properly defined Scalqa opaque types must extend one of those roots.

*/