package scalqa; package lang; import language.implicitConversions

object String extends Any.Ref.Custom.Containers[String]:
  val ordering          : Ordering[String] = summon[Ordering[String]]
  val orderingIgnoreCase: Ordering[String] = string.z.Ordering.IgnoreCase

  // Members ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  /**/                                              transparent inline def Custom     = string.Custom
  type Builder    = string.Builder.opaque.`type`;   transparent inline def Builder    = string.Builder
  type _methods = string._methods;              transparent inline def _methods = string._methods

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