package scalqa; package lang; package int; package z; package range; import language.implicitConversions

import scala.quoted.*

object Macro:

  inline def foreach[A<:RAW,U](inline x: g.Range[A], inline f:A=>U): Unit        = ${ foreachMacro('x,'f)}

  // ---------------------------------------------------------------------------------------------------------------------------------------------------------------------
  private def foreachMacro[A<:Raw.Int:Type,U:Type](r: Expr[Int.G.<>[A]] ,f: Expr[A => U])(using Quotes): Expr[Unit] =
    r match
      case '{ new G.<>[A]($s,$to,true)  } => '{ var i=$s.real; val e=$to.real;  while(i<=e){ val r=$f(i.cast[A]); i+=1 }}
      case '{ new G.<>[A]($s,$to,false) } => '{ var i=$s.real; val e=$to.real;  while(i< e){ val r=$f(i.cast[A]); i+=1 }}
      case '{ new G.<>[A]($s,$sz)       } => '{ var i=$s.real; val e=i+$sz;     while(i< e){ val r=$f(i.cast[A]); i+=1 }}
      case _                                 => '{ foreachDflt($r,$f) }

  inline def foreachDflt[A<:RAW,U](inline x: G.<>[A], inline f:A=>U): Unit = { val v=x; var i=v.start.real; val e=v.endX.real; while(i<e){ val r=f(i.cast[A]); i+=1 }}

//  // ---------------------------------------------------------------------------------------------------------------------------------------------------------------------
//  private def streamMacro[A<:any.Raw.Int:Type](r: Expr[g.Range[A]])(using Quotes): Expr[g.Stream[A]] =
//    //    r.show.TP
//    r match
//      case '{ ($s:Int) <> ($to:Int)        } => '{                new range.Stream[A]($s.real,$to.real+1L) }
//      case '{ new G.<>[A]($s,$to,true)  } => '{                new range.Stream[A]($s.real,$to.real+1L) }
//      case '{ new G.<>[A]($s,$to,false) } => '{                new range.Stream[A]($s.real,$to.real.Long) }
//      case '{ new G.<>[A]($s,$sz)       } => '{ var i=$s.real; new range.Stream[A](i,i + $sz.Long) }
//      case _                                 => '{ val v=$r;      new range.Stream[A](v.start.real.Int,v.endX.real.Long) }

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
