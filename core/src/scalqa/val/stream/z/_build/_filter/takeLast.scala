package scalqa; package `val`; package stream; package z; package _build; package _filter; import language.implicitConversions

class takeLast[A](x: Stream[A], cnt: Int) extends z.x.Pipe.Calc[A](x):
  def calc = new Calc

  class Calc extends z.x.Pipe[A](x) with Able.Size:
    private         val a = new Array[AnyRef](cnt)
    private         var i = 0
    x.foreach(v => { a(i % a.length) = v.cast[AnyRef]; i+=1 })
    private         val sz     = i min a.length;
    private         val off    = i - sz - 1
    private         var j      = 0
    def readOpt = {var o:Opt[A]= \/; if(j<sz){ j+=1; o = a((off + j) % a.length).cast[A]}; o}
    /**/            def size   = sz - j

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
