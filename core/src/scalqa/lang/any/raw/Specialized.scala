package scalqa; package lang; package any; package raw; import language.implicitConversions

object Specialized:
  trait OnSomething
  trait OnBoolean extends OnSomething
  trait OnByte    extends OnSomething
  trait OnChar    extends OnSomething
  trait OnShort   extends OnSomething
  trait OnInt     extends OnSomething
  trait OnLong    extends OnSomething
  trait OnFloat   extends OnSomething
  trait OnDouble  extends OnSomething

  @tn("get_Opt") def get_?(v: Any) : Opt[String] = v match
    case v: OnBoolean    => "Boolean"
    case v: OnByte       => "Byte"
    case v: OnChar       => "Char"
    case v: OnShort      => "Short"
    case v: OnInt        => "Int"
    case v: OnLong       => "Long"
    case v: OnFloat      => "Float"
    case v: OnDouble     => "Double"
    case v: OnSomething  => "Something"
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