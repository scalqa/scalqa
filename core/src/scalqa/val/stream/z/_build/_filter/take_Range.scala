package scalqa; package `val`; package stream; package z; package _build; package _filter; import language.implicitConversions

class take_Range[A](x: ~[A], in: Int.<>) extends a.Pipe[A](x) with Able.Size.Opt.Long:
  private val start = in.start
  private val endX  = in.endX
  private var i     = -1

  @tn("read_Opt") def read_? =
    i += 1
    var o = x.read_?
    while (i < start && o.nonEmpty) { i += 1; o = x.read_? }
    o.drop(_ => i >= endX)

  @tn("sizeLong_Opt") def sizeLong_? : Long.Opt =
    if(i>=endX) 0L
    else x.sizeLong_?.map(v => {
      val need = endX - i - 1
      var sz : Long = if(v < need) v else need
      if(i<start) sz = sz - start + i + 1
      sz max 0
    })

  override def doc = super.doc +=@ (0, "", in)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
