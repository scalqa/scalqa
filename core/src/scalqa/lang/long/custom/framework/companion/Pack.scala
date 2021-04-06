package scalqa; package lang; package long; package custom; package framework; package companion; import language.implicitConversions

class Pack[A<:RAW] private[lang]() extends Pack.zBased[A,G.><[A]]

object Pack extends Pack[SELF]:

  private[framework] class zBased[A<:RAW, PACK]:
    /**/           inline def apply(inline v:A, inline vs: A*): PACK = G.><.fromVarArg(v,vs).cast[PACK]
    /**/           inline def apply(inline v: ~[A])           : PACK = G.><.fromStream(v).cast[PACK]
    @tn("getVoid") inline def void                            : PACK = G.><.void.cast[PACK]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@def void  -> Get void instance

*/