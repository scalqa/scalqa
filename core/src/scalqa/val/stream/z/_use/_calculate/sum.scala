package scalqa; package `val`; package stream; package z; package _use; package _calculate; import language.implicitConversions

object sum:

  def few[A,B,C,D,E,F]( x: Stream[A],f1:A=>Opt[B], f2:A=>Opt[C], f3:A=>Opt[D]=VOID,f4:A=>Opt[E]=VOID,f5:A=>Opt[F]=VOID)
                      (using n1:Math.Sum[B], n2:Math.Sum[C], n3:Math.Sum[D], n4:Math.Sum[E], n5:Math.Sum[F])
    :  (B,C)  | (B,C,D) | (B,C,D,E) | (B,C,D,E,F) =


      var v1 = n1.zero
      var v2 = n2.zero
      var v3 = n3.zero
      var v4 = n4.zero
      var v5 = n5.zero

      val is3 = f3.self.nonVoid
      val is4 = f4.self.nonVoid
      val is5 = f5.self.nonVoid

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
