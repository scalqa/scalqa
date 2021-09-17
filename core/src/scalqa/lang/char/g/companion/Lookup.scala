package scalqa; package lang; package char; package g; package companion; import language.implicitConversions

class Lookup[A<:Raw]:
  /**/           inline def apply[B](inline v: (A, B) *) : G.Lookup[A,B] = Stable(v *)
  /**/           inline def apply[B](inline v: ~[(A, B)]): G.Lookup[A,B] = Stable(v)
  @tn("getVoid") inline def void[B]                      : G.Lookup[A,B] = Stable.void[B]

  type Mutable[B] = G.Lookup.Mutable[A,B];                     val Mutable = new Lookup.Mutable[A]
  type M[B]       = G.Lookup.Mutable[A,B];  transparent inline def M       = Mutable
  type Stable[B]  = G.Lookup.Stable[A,B];                      val Stable  = new Lookup.Stable[A]

object Lookup:

  class Mutable[A<:Raw]:
    def apply[B](initSize: Int = J.initSize): G.Lookup.Mutable[A,B] = new G.Lookup.Mutable.X.Basic(initSize)

  class Stable[A<:Raw]:
    /**/           inline def apply[B](inline v: (A,B) *) : G.Lookup.Stable[A,B] = G.Lookup.Stable[A,B](v *)
    /**/           inline def apply[B](inline v: ~[(A,B)]): G.Lookup.Stable[A,B] = G.Lookup.Stable[A,B](v)
    @tn("getVoid") inline def void[B]                     : G.Lookup.Stable[A,B] = G.Lookup.Stable.void[A,B]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@def void  -> Get void instance

*/