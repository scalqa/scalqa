package scalqa; package `val`; package stream; package z; package build; package extend; import language.implicitConversions

class join[A](x: ~[A], value: A) extends a.Pipe[A](x) with Able.Size.Opt.Long:
  private var v = true
  @tn("read_Opt")     def read_?     : Opt[A]   = if(v) x.read_? or_? {v = false; value} else \/
  @tn("sizeLong_Opt") def sizeLong_? : Long.Opt = if(v) x.sizeLong_?.map(_ + 1) else 0L

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
