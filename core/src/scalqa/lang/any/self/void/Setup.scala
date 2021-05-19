package scalqa; package lang; package any; package self; package void; import language.implicitConversions

abstract class Setup[T](v: T):
  @tn("requestVoid") @fast lazy final val void : T = v match
    case null                  => J.illegalArgument("null passed to " + getClass)
    case v: Ref if v.^.nonVoid => J.illegalArgument("nonVoid object passed as void for " + getClass + ": " + v)
    case v                     => v

  implicit inline def implicitRequest_\/(inline v: \/): T = void


/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/

