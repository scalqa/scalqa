package scalqa; package `val`; package stream; package z; package _build; package _filter; import language.implicitConversions

class dropFirst[A](x: ~[A], sz: Int) extends z.x.Pipe[A](x) with Able.Size.Opt.Long:
  private             var i          = if (sz < 0) 0 else sz
  @tn("read_Opt")     def read_?     = { while (i > 0 && x.read_?.nonEmpty) i -= 1; x.read_?}
  @tn("sizeLong_Opt") def sizeLong_? = x.sizeLong_?.map(v => (v - i) max 0)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
