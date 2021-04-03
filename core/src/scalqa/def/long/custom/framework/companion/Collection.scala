package scalqa; package `def`; package long; package custom; package framework; package companion; import language.implicitConversions

class Collection[A<:RAW] extends Pack.zBased[A,G.Collection[A]]:

  type Mutable = G.Collection.Mutable[A]
  object Mutable:
    def apply(initSize: Int = J.initSize): Mutable = new G.Buffer(initSize).cast[Mutable]

  type StableSet = G.Collection.StableSet[A]
  object StableSet:
    /**/           inline def apply(inline v: A *) : StableSet = G.Collection.StableSet(v)
    /**/           inline def apply(inline v: ~[A]): StableSet = G.Collection.StableSet(v)
    @tn("getVoid") inline def void                 : StableSet = G.Collection.StableSet.void

object Collection extends Collection[SELF]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@def void  -> Get void instance

*/