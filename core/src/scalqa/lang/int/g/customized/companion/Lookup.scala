package scalqa; package lang; package int; package g; package customized; package companion; import language.implicitConversions

class Lookup[A<:Raw]:
  /**/           inline def apply[B](inline v: (A, B) *) : G.Lookup[A,B] = Stable(v *)
  /**/           inline def apply[B](inline v: ~[(A, B)]): G.Lookup[A,B] = Stable(v)
  @tn("getVoid") inline def void[B]                      : G.Lookup[A,B] = Stable.void[B]

  type M[B] = G.Lookup.Mutable[A,B]; inline def M = Mutable

  type Mutable[B] = G.Lookup.Mutable[A,B]
  object Mutable:
    def apply[B](initSize: Int = J.initSize): Mutable[B] = new G.Lookup.Mutable.X.Basic(initSize)

  type Stable[B] = G.Lookup.Stable[A,B]
  object Stable:
    /**/           inline def apply[B](inline v: (A,B) *) : Stable[B] = G.Lookup.Stable[A,B](v *)
    /**/           inline def apply[B](inline v: ~[(A,B)]): Stable[B] = G.Lookup.Stable[A,B](v)
    @tn("getVoid") inline def void[B]                     : Stable[B] = G.Lookup.Stable.void[A,B]

object Lookup extends Lookup[Int]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@def void  -> Get void instance

*/