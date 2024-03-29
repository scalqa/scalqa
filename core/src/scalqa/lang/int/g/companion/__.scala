package scalqa; package lang; package int; package g; import language.implicitConversions

object Companion:
  type Containers[A<:Raw] = companion.Containers[A]
  type Stream    [A<:Raw] = companion.Stream[A]
  type Pack      [A<:Raw] = companion.Pack[A]
  type Opt       [A<:Raw] = companion.Opt[A]
  type Collection[A<:Raw] = companion.Collection[A];     transparent inline def Collection = companion.Collection
  type Idx       [A<:Raw] = companion.Idx[A];            transparent inline def Idx        = companion.Idx
  type Pro       [A<:Raw] = companion.Pro[A];            transparent inline def Pro        = companion.Pro
  type Fun       [A<:Raw] = companion.Fun[A]
  type Lookup    [A<:Raw] = companion.Lookup[A];         transparent inline def Lookup     = companion.Lookup
  type Set       [A<:Raw] = companion.Set[A]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@object Companion ->

    Companion object contains a set of classes, which provide companion object functionality for customized generic containers.

*/