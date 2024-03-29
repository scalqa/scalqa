package scalqa; package lang; package int; package z; package range; import language.implicitConversions

import scala.quoted.*

object foreachMacro:

  inline def apply[A<:Raw,U](inline x: G.Range[A], inline f:A=>U): Unit = ${ applyMacro('x,'f)}

  // -----------------------------------------------------------------------------------------------------------------------------
  private def applyMacro[A<:Any.Int:Type,U:Type](r: Expr[G.Range[A]] ,f: Expr[A => U])(using Quotes): Expr[Unit] =
    r match
      case '{ new G.Range[A]($s,$to,true)  } => '{ var i=$s.cast[Int]; val e=$to.cast[Int];  while(i<=e){ val r=$f(i.cast[A]); i+=1 }}
      case '{ new G.Range[A]($s,$to,false) } => '{ var i=$s.cast[Int]; val e=$to.cast[Int];  while(i< e){ val r=$f(i.cast[A]); i+=1 }}
      case '{ new G.Range[A]($s,$sz)       } => '{ var i=$s.cast[Int]; val e=i+$sz;          while(i< e){ val r=$f(i.cast[A]); i+=1 }}
      case _                              => '{ applyDflt($r,$f) }

  private inline def applyDflt[A<:Raw,U](inline x: G.Range[A], inline f:A=>U): Unit =
    val v=x
    var i=v.start.cast[Int]
    val e=v.endX.cast[Int]
    while(i<e)
      val r = f(i.cast[A])
      i += 1

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
