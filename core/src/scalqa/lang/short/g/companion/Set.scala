package scalqa; package lang; package short; package g; package companion; import language.implicitConversions

class Set[A<:Raw]:
  /**/           inline def apply(inline v: A *) : G.Set[A] = apply(v)
  /**/           inline def apply(inline v: ~[A]): G.Set[A] = G.Set(v)
  @tn("getVoid") inline def void                 : G.Set[A] = G.Set.void

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@def void  -> Get void instance

*/