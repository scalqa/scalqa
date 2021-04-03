package scalqa; package `val`; package stream; package z; package build; package filter; import language.implicitConversions

class dropLast(x: ~[Ref], cnt: Int) extends a.Pipe[Ref](x) with Able.Size.Opt.Long:
  private val array  = new Array[Ref](cnt)
  private var i      = -1

  @tn("read_Opt") def read_? =
    var o = x.read_?
    if (i == -1) { i = 0; while(i < cnt && o.nonEmpty){ array(i)=o; o = x.read_?; i+=1 }; i = 0}
    o.map(v => {
      val r = array(i)
      array(i) = v
      i = (i + 1) % cnt
      r
    })

  @tn("sizeLong_Opt") def sizeLong_? : Long.Opt = x.sizeLong_?.map(_ - (if(i== -1) cnt else 0)).drop(_ < 0)


/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
