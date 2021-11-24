package scalqa; package `val`; package stream; package z; package _build; package _group; import language.implicitConversions

class partition[A](x: Stream[A], p: A => Boolean, seq: Seq[A=>Boolean]) extends z.x.Pipe.Calc[Stream[A]](x):

  def calc =
    val cnt  = seq.size + 1
    val init = x.sizeOpt.map(_ / cnt * 2) or J.initSize
    if(cnt == 1)
      val one, two = Idx.M[A](init)
      x.FOREACH(v => if(p(v)) one += v else two += v)
      Stream(one.stream,two.stream)
    else
      val pa = new Array[A =>Boolean](cnt).self(a =>{a(0)=p; for(i <- 1 <>> cnt) a(i) = seq(i-1) })
      val ra = new Array[Buffer[A]](cnt+1).self(a => for(i <- 0 <> cnt) a(i) = new AnyRef.Buffer[A](init))

      x.FOREACH(v => {
        var i = 0
        while (i < cnt) if(pa(i)(v)) { ra(i) += v; i = cnt + 1 } else i += 1
        if(i==cnt) ra(i) += v
      })
      ra.stream.map(_.stream)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
