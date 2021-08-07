package scalqa; package lang; package short; package g; package customized; package companion; import language.implicitConversions

class Opt[A<:Raw]:
  @tn("getVoid") inline def void: G.Opt[A]      = G.Opt.void[A]

object Opt extends Opt[Short]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@def void  -> Get void instance
*/