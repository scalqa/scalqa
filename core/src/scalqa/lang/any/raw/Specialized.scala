package scalqa; package lang; package any; package raw; import language.implicitConversions

object Specialized:
  trait OnAnyRaw
  trait OnBoolean extends OnAnyRaw
  trait OnByte    extends OnAnyRaw
  trait OnChar    extends OnAnyRaw
  trait OnShort   extends OnAnyRaw
  trait OnInt     extends OnAnyRaw
  trait OnLong    extends OnAnyRaw
  trait OnFloat   extends OnAnyRaw
  trait OnDouble  extends OnAnyRaw

  @tn("get_Opt") def get_?(v: Any) : Opt[String] = v match
    case v: OnBoolean    => "Boolean"
    case v: OnByte       => "Byte"
    case v: OnChar       => "Char"
    case v: OnShort      => "Short"
    case v: OnInt        => "Int"
    case v: OnLong       => "Long"
    case v: OnFloat      => "Float"
    case v: OnDouble     => "Double"
    case v: OnAnyRaw     => "AnyRaw"
    case _               => \/


/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@object Specialized -> ###

  Specialized object provides a set of tags to indicate special implementations.

  It is used primarily for documentation purposes.  Processing logic does not depend on it.

*/