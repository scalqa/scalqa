package scalqa; package `def`; package any; package ref; package custom; package framework; package companion; import language.implicitConversions

class Collection[A]:
  def apply(v: A)                        : Val.Collection[A] = Val.Collection(v)
  def apply(v1: A, v2: A)                : Val.Collection[A] = Val.Collection(v1, v2)
  def apply(v1: A, v2: A, v3: A, vs: A*) : Val.Collection[A] = Val.Collection(v1, v2, v3, vs *)

  type Mutable   = Val.Collection.Mutable[A]
  object Mutable:
    def apply(initSize: Int = J.initSize): Mutable = new Any.Ref.Buffer(initSize).cast[Mutable]

  type StableSet = Val.Collection.StableSet[A]
  object StableSet:
    /**/           def apply(v: A *) : StableSet = apply(v)
    /**/           def apply(v: ~[A]): StableSet = Val.Collection.StableSet(v)
    @tn("getVoid") def void          : StableSet = Val.Collection.StableSet.void

private[scalqa] object Collection extends Collection[AnyRef]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@def void  -> Get void instance

*/