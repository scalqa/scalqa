package scalqa; package lang; package short; package g; package companion; import language.implicitConversions

class Pack[A<:Raw] private[lang]() extends z_Pack[A,G.Pack[A]]

class z_Pack[A<:Raw, PACK]:
  /**/           inline def apply(inline v:A, inline vs: A*): PACK = G.Pack.fromVarArg(v,vs).cast[PACK]
  /**/           inline def apply(inline v: Val.Stream[A])  : PACK = G.Pack.fromStream(v).cast[PACK]
  @tn("getVoid") inline def void                            : PACK = G.Pack.void.cast[PACK]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@def void  -> Get void instance

*/