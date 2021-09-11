package scalqa; package lang; package int; package z; package range; import language.implicitConversions

import scala.quoted.*

object Macro:

  inline def foreach[A<:Raw,U](inline x: g.Range[A], inline f:A=>U): Unit = ${ foreachMacro('x,'f)}

  // ---------------------------------------------------------------------------------------------------------------------------------------------------------------------
  private def foreachMacro[A<:Any.Int:Type,U:Type](r: Expr[Int.G.<>[A]] ,f: Expr[A => U])(using Quotes): Expr[Unit] =
    r match
      case '{ new G.<>[A]($s,$to,true)  } => '{ var i=$s.cast[Int]; val e=$to.cast[Int];  while(i<=e){ val r=$f(i.cast[A]); i+=1 }}
      case '{ new G.<>[A]($s,$to,false) } => '{ var i=$s.cast[Int]; val e=$to.cast[Int];  while(i< e){ val r=$f(i.cast[A]); i+=1 }}
      case '{ new G.<>[A]($s,$sz)       } => '{ var i=$s.cast[Int]; val e=i+$sz;          while(i< e){ val r=$f(i.cast[A]); i+=1 }}
      case _                              => '{ foreachDflt($r,$f) }

  inline def foreachDflt[A<:Raw,U](inline x: G.<>[A], inline f:A=>U): Unit = { val v=x; var i=v.start.cast[Int]; val e=v.endX.cast[Int]; while(i<e){ val r=f(i.cast[A]); i+=1 }}

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
