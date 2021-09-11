package scalqa; package `val`; package stream; package z; package _build; package _extend; import language.implicitConversions

class repeat[A](x: ~[A], times: Int) extends z.x.Pipe[A](x) with Able.Size.Opt.Long:
  private var i = 0
  private var c: A = _

  @tn("read_Opt")     def read_?     = if(i > 0) { i -= 1; c } else x.read_?.forval(v => {c = v; i = times - 1})
  @tn("sizeLong_Opt") def sizeLong_? = x.sizeLong_?.map(_ * times + i)


/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
