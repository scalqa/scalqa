package scalqa; package `val`; package stream; package z; package _use; package _calculate; import language.implicitConversions

object sum:

  def opt[A](x: ~[A], n:Math[A]) : Opt[A] = n match
    case _ : Custom.Math[_] => n.cast[Custom.Math[A]].calculateSum_?(x)
    case _                  => x.read_?.map(v=>{var r=v; x.FOREACH(v => r=n.plus(r,v)); r})


  def few[A,B,C,D,E,F]( x: ~[A],f1:A=>Opt[B], f2:A=>Opt[C], f3:A=>Opt[D]= \/, f4:A=>Opt[E]= \/, f5:A=>Opt[F]= \/)
                      (using n1:Math[B], n2:Math[C], n3:Math[D], n4:Math[E], n5:Math[F])
    :  (B,C)  | (B,C,D) | (B,C,D,E) | (B,C,D,E,F) =

      var v1 = n1.zero
      var v2 = n2.zero
      var v3 = n3.zero
      var v4 = n4.zero
      var v5 = n5.zero

      val is3 = f3.^.nonVoid
      val is4 = f4.^.nonVoid
      val is5 = f5.^.nonVoid

      x.FOREACH(v => {
        /**/    f1(v).forval(v => v1 = n1.plus(v1,v))
        /**/    f2(v).forval(v => v2 = n2.plus(v2,v))
        if(is3) f3(v).forval(v => v3 = n3.plus(v3,v))
        if(is4) f4(v).forval(v => v4 = n4.plus(v4,v))
        if(is5) f5(v).forval(v => v5 = n5.plus(v5,v))
      })

      if     (is5) (v1,v2,v3,v4,v5)
      else if(is4) (v1,v2,v3,v4)
      else if(is3) (v1,v2,v3)
      else         (v1,v2)


/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
