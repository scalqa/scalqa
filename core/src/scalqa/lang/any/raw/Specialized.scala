package scalqa; package lang; package any; package raw; import language.implicitConversions

trait Specialized

object Specialized:
  trait OnBoolean extends Specialized
  trait OnByte    extends Specialized
  trait OnChar    extends Specialized
  trait OnShort   extends Specialized
  trait OnInt     extends Specialized
  trait OnLong    extends Specialized
  trait OnFloat   extends Specialized
  trait OnDouble  extends Specialized

  @tn("get_Opt") def get_?(v: Any) : Opt[String] = v match
    case v: OnBoolean => "Boolean"
    case v: OnByte    => "Byte"
    case v: OnChar    => "Char"
    case v: OnShort   => "Short"
    case v: OnInt     => "Int"
    case v: OnLong    => "Long"
    case v: OnFloat   => "Float"
    case v: OnDouble  => "Double"
    case _            => \/


/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
