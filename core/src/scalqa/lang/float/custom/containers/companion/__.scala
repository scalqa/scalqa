package scalqa; package lang; package float; package custom;  package containers; import language.implicitConversions

object Companion:
  type Opt       [A<:RAW] = companion.Opt[A]
  type Collection[A<:RAW] = companion.Collection[A]
  type Idx       [A<:RAW] = companion.Idx[A]
  type Pack      [A<:RAW] = companion.Pack[A]
  type Pro       [A<:RAW] = companion.Pro[A]
  type Stream    [A<:RAW] = companion.Stream[A]
  type Fun       [A<:RAW] = companion.Fun[A]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
