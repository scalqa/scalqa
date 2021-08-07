package scalqa; package `val`; package stream; package z; package _build; package _filter; import language.implicitConversions

class takeLast(x: ~[AnyRef], cnt: Int) extends a.Pipe.Calculated[AnyRef](x):

  def calculate =
    val a = new Array[AnyRef](cnt)
    var i = 0
    x.foreach(v => { a(i % cnt) = v; i+=1 })
    new z.a.Pipe.Refs[AnyRef](x) with Able.Size {
      private         val sz     = i min cnt;
      private         val off    = i - sz - 1
      private         var j      = 0
      @tn("read_Opt") def read_? = if(j<sz){ j+=1; a((off + j) % cnt)} else \/
      /**/            def size   = sz - j
    }

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
