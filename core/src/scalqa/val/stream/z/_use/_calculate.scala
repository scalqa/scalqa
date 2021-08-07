package scalqa; package `val`; package stream; package z; package _use; import language.implicitConversions

import Custom.Math.Average

object _calculate:
  def averageFew[A,B,C,D,E,F](x: ~[A], f1:A=>Opt[B], f2:A=>Opt[C], f3:A=>Opt[D]= \/, f4:A=>Opt[E]= \/, f5:A=>Opt[F]= \/)
                                    (using a1:Average[B], a2:Average[C], a3:Average[D], a4:Average[E], a5:Average[F]):  (B,C)  | (B,C,D) | (B,C,D,E) | (B,C,D,E,F) =
    var i=0; var l1=a1.averageLogic; var l2=a2.averageLogic; var l3=a3.averageLogic; var l4=a4.averageLogic; var l5=a5.averageLogic;
    val is3=f3.^.nonVoid; val is4=f4.^.nonVoid; val is5=f5.^.nonVoid
    x.FOREACH(v => {
      /**/    f1(v).forval(l1.add)
      /**/    f2(v).forval(l2.add)
      if(is3) f3(v).forval(l3.add)
      if(is4) f4(v).forval(l4.add)
      if(is5) f5(v).forval(l5.add)
    })
    val v1=l1.result; val v2=l2.result
    if(is5)(v1,v2,l3.result,l4.result,l5.result) else if(is4) (v1,v2,l3.result,l4.result) else if(is3) (v1,v2,l3.result) else (v1,v2)

  private def div[A](v: A, count: Int)(using n: Math[A]): A = n match
    case n: math.Integral[A]   => n.quot(v, n.fromInt(count))
    case n: math.Fractional[A] => n.div(v, n.fromInt(count))
    case _                     => J.illegalState()

  // -------------------------------------------------------------------------------------------------------------------------------------------------------------------
  def sumFew[A,B,C,D,E,F](x: ~[A], f1:A=>Opt[B], f2:A=>Opt[C], f3:A=>Opt[D]= \/, f4:A=>Opt[E]= \/, f5:A=>Opt[F]= \/)
                                    (using n1:Math[B], n2:Math[C], n3:Math[D], n4:Math[E], n5:Math[F]):  (B,C)  | (B,C,D) | (B,C,D,E) | (B,C,D,E,F) =
    var v1=n1.zero; var v2=n2.zero; var v3=n3.zero; var v4=n4.zero; var v5=n5.zero; val is3=f3.^.nonVoid; val is4=f4.^.nonVoid; val is5=f5.^.nonVoid
    x.FOREACH(v => {
      /**/    f1(v).forval(v => v1 = n1.plus(v1,v))
      /**/    f2(v).forval(v => v2 = n2.plus(v2,v))
      if(is3) f3(v).forval(v => v3 = n3.plus(v3,v))
      if(is4) f4(v).forval(v => v4 = n4.plus(v4,v))
      if(is5) f5(v).forval(v => v5 = n5.plus(v5,v))
    })
    if(is5) (v1,v2,v3,v4,v5) else if(is4) (v1,v2,v3,v4) else if(is3) (v1,v2,v3) else (v1,v2)

  // -------------------------------------------------------------------------------------------------------------------------------------------------------------------
  def countFew[A](x: ~[A], f1:A=>Boolean, f2:A=>Boolean, f3:A=>Boolean= \/, f4:A=>Boolean= \/, f5:A=>Boolean= \/):  (Int,Int)|(Int,Int,Int)|(Int,Int,Int,Int)|(Int,Int,Int,Int,Int) =
    var v1=0; var v2=0; var v3=0; var v4=0; var v5=0; val is3=f3.^.nonVoid; val is4=f4.^.nonVoid; val is5=f5.^.nonVoid
    x.FOREACH(v => {
      if(f1(v)) v1+=1;
      if(f2(v)) v2+=1;
      if(is3 && f3(v)) v3+=1;
      if(is4 && f4(v)) v4+=1;
      if(is5 && f5(v)) v5+=1;
    })
    if(is5) (v1,v2,v3,v4,v5) else if(is4) (v1,v2,v3,v4) else if(is3) (v1,v2,v3) else (v1,v2)
/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
