package scalqa; package lang; package anyref; package g; import language.implicitConversions

object Companion:
  type Containers[A] = companion.Containers[A]
  type Stream[A]     = companion.Stream[A]
  type Pack[A]       = companion.Pack[A]
  type Range[A]      = companion.Range[A]
  type Opt[A]        = companion.Opt[A]
  type Buffer[A]     = companion.Buffer[A]
  type Collection[A] = companion.Collection[A];   transparent inline def Collection = companion.Collection
  type Idx[A]        = companion.Idx[A];          transparent inline def Idx        = companion.Idx
  type Lookup[A]     = companion.Lookup[A];       transparent inline def Lookup     = companion.Lookup
  type Set[A]        = companion.Set[A]
  type Pro[A]        = companion.Pro[A];          transparent inline def Pro        = companion.Pro
  type Promise[A]    = companion.Promise[A]
  type Result[A]     = companion.Result[A]

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
