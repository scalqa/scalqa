package scalqa; package `val`; package stream; package z; package _build; package _filter; import language.implicitConversions

class dropLast[A](x: Stream[A], cnt: Int) extends z.x.Pipe[A](x) with Able.Size.Opt.Long:
  private val a  = new Array[AnyRef](cnt)
  private var i  = -1

  def readOpt =
    var o = x.readOpt
    if (i == -1) { i = 0; while(i < cnt && o){ a(i)=o; o = x.readOpt; i+=1 }; i = 0}
    o.map(v => {
      val r = a(i)
      a(i) = v.cast[AnyRef]
      i = (i + 1) % cnt
      r.cast[A]
    })

  def sizeLongOpt : Long.Opt = x.sizeLongOpt.map(_ - (if(i== -1) cnt else 0)).drop(_ < 0)


/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
