package scalqa; package gen; package void; import language.implicitConversions

abstract class Setup[A](voidValue: A):

  @tn("requestVoid") @fast lazy final val void : A = voidValue match
    case null                     => J.illegalArgument("null passed to " + getClass)
    case v: AnyRef if v.^.nonVoid => J.illegalArgument("nonVoid object passed as void for " + getClass + ": " + v)
    case v                        => v

  implicit inline def implicitFrom(v: \/): A = void

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@class Setup ->

  Void.Setup is an optional shortcut which helps to setup void value in companion object, saving couple lines of code.

  [See example](https://github.com/scalqa/scalqa/blob/master/fx/src/scalqa/fx/control/tooltip/__.scala).

*/
