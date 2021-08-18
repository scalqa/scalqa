package scalqa; package lang; package any; package raw; import language.implicitConversions

trait Specialized private[lang]():
  type SPECIALIZED_FOR <: AnyVal

object Specialized:

  @tn("get_Opt") def get_?(v: Any) : Opt[String] = v match
    case v: Boolean.Raw.Specialized => "Boolean"
    case v: Byte   .Raw.Specialized => "Byte"
    case v: Char   .Raw.Specialized => "Char"
    case v: Short  .Raw.Specialized => "Short"
    case v: Int    .Raw.Specialized => "Int"
    case v: Long   .Raw.Specialized => "Long"
    case v: Float  .Raw.Specialized => "Float"
    case v: Double .Raw.Specialized => "Double"
    case _                          => \/


/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@trait Specialized -> ###

  Specialized is the root of traits like: Byte.Raw.Specialized, Int.Raw.Specialized, etc., which indicate implementations with unboxed processing.

  Generally, Specialized marker is for information only and is not required for processing.

  See the [[Specialized$.html get_?]] method to receive description.


@def get_? -> Specialization name

  Returns specialization name, like "Boolean", "Byte", "Char", etc, if given instance is specialized

*/