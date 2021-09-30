package scalqa; package lang; import language.implicitConversions

object String extends AnyRef.G.Companion.Containers[String]:
  val ordering          : Ordering[String] = summon[Ordering[String]]
  val orderingIgnoreCase: Ordering[String] = string.z.Ordering.IgnoreCase

  // Members ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  type Opaque   = string.Opaque.TYPE.DEF;  transparent inline def Opaque   = string.Opaque
  type Builder  = string.Builder.TYPE.DEF; transparent inline def Builder  = string.Builder
  type _methods = string._Methods;         transparent inline def _methods = string._Methods

package object string:
  type Opaque = string.Opaque.TYPE.DEF

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@object String -> ### java.lang.String Companion

    This object also defines custom containers for String type, which are parameterazed generic containers

@val ordering -> Ordering   \n\n  Returns type natural ordering
@val orderingIgnoreCase  -> Ordering if case ignored

*/