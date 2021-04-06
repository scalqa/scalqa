package scalqa; package lang; package long; package custom; package framework; package companion; import language.implicitConversions

class Opt[A<:RAW]:
  @tn("getVoid") inline def void: G.Opt[A]      = G.Opt.void[A]

object Opt extends Opt[SELF]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@def void  -> Get void instance
*/