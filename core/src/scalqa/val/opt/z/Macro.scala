package scalqa; package `val`; package opt; package z; import language.implicitConversions;

import scala.quoted.*

object Macro:

  inline def or[A](inline x:Opt[A], inline v: => A) : A  = {val o=x; if(o ne ZZ.None) o.cast[A] else v}

  private def orImpl[A](oe: Expr[Opt[A]] ,ve: Expr[A])(using Quotes, Type[A]): Expr[A] =
    oe match
      case '{ if($b:Boolean) ($v) else ZZ.BoolNone.cast[Val.Opt[A]] }  => '{{if($b) $v.cast[A] else $ve }}
      case '{ ZZ.BoolNone.cast[Val.Opt[A]]                          }  => {ve}
      case _                                                           => '{{val o=$oe; if(o ne ZZ.None) o.cast[A] else $ve}}

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
