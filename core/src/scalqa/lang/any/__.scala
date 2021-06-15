package scalqa; package lang; import language.implicitConversions

object Any:
  type _extension  = any._extension
  type Opaque;                                  @fast lazy val Opaque      = any.Opaque
  type Ref         = scala.AnyRef;              @fast lazy val Ref         = any.Ref
  type Raw         = scala.AnyVal;              @fast lazy val Raw         = any.Raw

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@object Any -> Companion to scala.Any

*/