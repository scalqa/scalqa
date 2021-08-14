package scalqa; package `val`; package stream; package z; package _use; package _calculate; import language.implicitConversions

import Custom.Math.Average

object average:

  def few[A,B,C,D,E,F](x: ~[A], f1:A=>Opt[B], f2:A=>Opt[C], f3:A=>Opt[D]= \/, f4:A=>Opt[E]= \/, f5:A=>Opt[F]= \/)
                      (using a1:Average[B], a2:Average[C], a3:Average[D], a4:Average[E], a5:Average[F])
    : (B,C) | (B,C,D) | (B,C,D,E) | (B,C,D,E,F) =

      var i = 0
      var l1 = a1.averageLogic
      var l2 = a2.averageLogic
      var l3 = a3.averageLogic
      var l4 = a4.averageLogic
      var l5 = a5.averageLogic

      val is3 = f3.^.nonVoid
      val is4 = f4.^.nonVoid
      val is5 = f5.^.nonVoid

      x.FOREACH(v => {
        /**/    f1(v).forval(l1.add)
        /**/    f2(v).forval(l2.add)
        if(is3) f3(v).forval(l3.add)
        if(is4) f4(v).forval(l4.add)
        if(is5) f5(v).forval(l5.add)
      })

      val v1 = l1.result
      val v2 = l2.result

      if(is5)      (v1,v2,l3.result,l4.result,l5.result)
      else if(is4) (v1,v2,l3.result,l4.result)
      else if(is3) (v1,v2,l3.result)
      else         (v1,v2)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
