package scalqa; package `val`; package stream; package z; package util; import language.implicitConversions

import scala.quoted.*
import x.VarArg.*

object tupleOfFewMacro:

  inline def apply[A](inline t: (A,A)|(A,A,A)|(A,A,A,A)|(A,A,A,A,A)): Stream[A]  = ${ applyMacro('t) }

  private def applyMacro[A:Type](t: Expr[(A,A)|(A,A,A)|(A,A,A,A)|(A,A,A,A,A)])(using Quotes): Expr[Stream[A]] =
    t match
       //case '{ ($v1:A)                         } => '{ new Stream_ofOne  ($v1) }
       case '{ ($v1:A,$v2:A)                   } => '{ new Stream_ofTwo  ($v1,$v2) }
       case '{ ($v1:A,$v2:A,$v3:A)             } => '{ new Stream_ofThree($v1,$v2,$v3) }
       case '{ ($v1:A,$v2:A,$v3:A,$v4:A)       } => '{ new Stream_ofFour ($v1,$v2,$v3,$v4) }
       case '{ ($v1:A,$v2:A,$v3:A,$v4:A,$v5:A) } => '{ new Stream_ofFive ($v1,$v2,$v3,$v4,$v5) }
       case _                                    => '{ new Stream_fromTuple($t) }

class Stream_fromTuple[A](v: Product) extends Stream[A] with Able.Size:
  private         var i               = 0
  private         val sz              = v.productArity
  def readOpt : Opt[A] = {var o:Opt[A]= \/; if(i<sz){ o=v.productElement(i).cast[A]; i+=1}; o }
  /**/            def size   : Int    = sz - i

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
