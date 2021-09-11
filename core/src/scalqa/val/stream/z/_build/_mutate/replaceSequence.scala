package scalqa; package `val`; package stream; package z; package _build; package _mutate; import language.implicitConversions

class replaceSequence[A,B](x: ~[A], f: A=>B, seq: ><[B], to: ><[A] ) extends z.x.Pipe[A](x):
  def this(x: ~[A], seq: ><[A], to: ><[A])=this(x, v => v.cast[B], seq.cast[><[B]], to)

  private val is  = seq.nonEmpty
  private val a   = new Array[AnyRef](seq.size max to.size)
  private var i,j = 0

  @tn("read_Opt") def read_? =
    var o: Opt[A] = \/
    if(i<j)
      o = a(i).cast[Opt[A]]
      i += 1
    else
      i = 0
      j = 0
      o = x.read_?
      while(is && o.take(v => f(v) == seq(j)))
        a(j) = o.cast[AnyRef]
        j += 1
        if(j == seq.size)
          j = to.size
          for(v <- 0 <>> j) a(v) = to(v).cast[AnyRef]
          return this.read_?
        o = x.read_?
      if(j>0)
        a(j) = o.cast[AnyRef]
        j += 1
        o = this.read_?
    o

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
