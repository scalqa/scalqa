package scalqa; package lang; package double; package g; package containers; package companion; import language.implicitConversions

class Collection[A<:Raw] extends Pack.zBased[A,G.Collection[A]]:
  type M = G.Collection.Mutable[A]; inline def M = Mutable

  type Mutable = G.Collection.Mutable[A]
  object Mutable:
    def apply(initSize: Int = J.initSize): Mutable = new G.Buffer(initSize).cast[Mutable]

  type StableSet = Val.Collection.StableSet[A]
  object StableSet:
    /**/           inline def apply(inline v: A *) : StableSet = apply(v)
    /**/           inline def apply(inline v: ~[A]): StableSet = Val.Collection.StableSet(v)
    @tn("getVoid") inline def void                 : StableSet = Val.Collection.StableSet.void

private[scalqa] object Collection extends Collection[Double]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@def void  -> Get void instance

*/