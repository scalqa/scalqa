package scalqa; package lang; package boolean; package g; package companion; import language.implicitConversions

class Stream[A<:Raw]:
  /**/           inline def apply(inline v: A): G.Stream[A] = G.Stream(v)
  /**/           inline def apply(v: A*)      : G.Stream[A] = G.Stream(v *)
  @tn("getVoid") inline def void              : G.Stream[A] = G.Stream.void

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@def void  -> Get void instance

*/