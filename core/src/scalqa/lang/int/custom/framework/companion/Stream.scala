package scalqa; package lang; package int; package custom; package framework; package companion; import language.implicitConversions

class Stream[A<:RAW]:
  /**/           inline def apply(inline v: A): G.~[A] = G.~(v)
  /**/           inline def apply(v: A*)      : G.~[A] = G.~(v *)
  @tn("getVoid") inline def void              : G.~[A] = G.~.void

object Stream extends Stream[SELF]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@def void  -> Get void instance

*/