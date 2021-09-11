import language.implicitConversions

package object scalqa:
  export scalqa.Lang.*
  export scalqa.Gen.*
  export scalqa.gen.Request.*
  export scalqa.j.vm.Predef.{ given }

  export scalqa.Val.{ ~ as _, * }
  @tn("Stream") val ~~ = `val`.Stream; @tn("Stream") type ~[+A] = `val`.Stream[A]

//  implicit inline def implicitVoidRequestToValOpt    [A<:Any        ](v: \/): Val.Opt[A]       = ZZ.None.cast[Val.Opt[A]]
//  implicit inline def implicitVoidRequestToBooleanOpt[A<:Any.Boolean](v: \/): Boolean.G.Opt[A] = Boolean.G.Opt.void[A]
//  implicit inline def implicitVoidRequestToByteOpt   [A<:Any.Byte   ](v: \/): Byte.G.Opt[A]    = Byte.G.Opt.void[A]
//  implicit inline def implicitVoidRequestToCharOpt   [A<:Any.Char   ](v: \/): Char.G.Opt[A]    = Char.G.Opt.void[A]
//  implicit inline def implicitVoidRequestToShortOpt  [A<:Any.Short  ](v: \/): Short.G.Opt[A]   = Short.G.Opt.void[A]
//  implicit inline def implicitVoidRequestToIntOpt    [A<:Any.Int    ](v: \/): Int.G.Opt[A]     = Int.G.Opt.void[A]
//  implicit inline def implicitVoidRequestToLongOpt   [A<:Any.Long   ](v: \/): Long.G.Opt[A]    = Long.G.Opt.void[A]
//  implicit inline def implicitVoidRequestToFloatOpt  [A<:Any.Float  ](v: \/): Float.G.Opt[A]   = Float.G.Opt.void[A]
//  implicit inline def implicitVoidRequestToDoubleOpt [A<:Any.Double ](v: \/): Double.G.Opt[A]  = Double.G.Opt.void[A]


  private[scalqa] type ClassTag[A]    = scala.reflect.ClassTag[A];      private[scalqa] transparent inline def ClassTag   = scala.reflect.ClassTag
  private[scalqa] type Specialized[A] = lang.any.Specialized[A];        private[scalqa] transparent inline def Specialized= lang.any.Specialized;
  private[scalqa] type tn             = scala.annotation.targetName
  private[scalqa] type fast           = scala.annotation.threadUnsafe
  extension[A](inline x: A) private[scalqa] inline def cast[B]:  B = x.asInstanceOf[B]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@object scalqa -> ### \n\n Root package [[scalqa]] defines 5 members:

  -- [[scalqa.Lang$ Lang]] holds language level extentions to Java and Scala functionality
  -- [[scalqa.Gen$ Gen]]   holds core language utilities
  -- [[scalqa.Fx$ Fx]]     holds GUI API
  -- [[scalqa.J$ J]]       holds second tier language utilities
  -- [[scalqa.Val$ Val]]   holds generic containers framework

  [[scalqa]] also contains many aliases,
  so the types and objects defined deeper in the hierarchy can be accessed without prefixes


@val ~~ ->  Companion operator alias \n\n Shortcut to [[scalqa.val.Stream$ Val.Stream]]

    `Note.`

    The stream companion alias is a double tilde (`~~`) instead of a single (`~`).
    This exception is made only for root object scalqa.~~ , `scalqa.Val.~` companion is stil single tilde.
    ```
    val s1 : ~[String] = ~~("a","b","c")
    val s2 : ~[String] = Val.~("a","b","c")
    ```
    The reason for the exception is twofold:

      1. `~` is universally used as a method name, which would conflict with unprefixed companion inside some classes
      2. Simple expression ~("a","b","c") compiles in Scala as a prefix method on Tuple3, but ~~("a","b","c") works fine as ~~.apply("a","b","c")
*/
