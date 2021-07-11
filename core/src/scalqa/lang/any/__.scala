package scalqa; package lang; import language.implicitConversions

object Any:
  type _methods  = any._methods
  type Opaque;                        transparent inline def Opaque      = any.Opaque
  type Ref         = scala.AnyRef;    transparent inline def Ref         = any.Ref
  type Raw         = scala.AnyVal;    transparent inline def Raw         = any.Raw

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@object Any -> Companion to scala.Any

*/