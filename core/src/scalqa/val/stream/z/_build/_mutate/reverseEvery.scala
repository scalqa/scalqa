package scalqa; package `val`; package stream; package z; package _build; package _mutate; import language.implicitConversions

class reverseEvery[A](x: ~[A], size: Int) extends a.Pipe[A](x) with Able.Size.Opt.Long:
  private var cur: ~[A] = \/

  @tn("read_Opt")     def read_?     = cur.read_? or_? { cur = x.read_~(size).reverse; cur.read_? }
  @tn("sizeLong_Opt") def sizeLong_? = x.sizeLong_?.mix(cur.sizeLong_?, _ + _)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
