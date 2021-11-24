package scalqa; package `val`; package stream; package z; package _build; package _filter; import language.implicitConversions

class take_Range[A](x: Stream[A], range: Int.Range) extends z.x.Pipe[A](x) with Able.Size.Opt.Long:
  private val start = range.start
  private val endX  = range.endX
  private var i     = -1

  def readOpt =
    i += 1
    var o = x.readOpt
    while (i < start && o) { i += 1; o = x.readOpt }
    o.drop(_ => i >= endX)

  def sizeLongOpt : Long.Opt =
    if(i>=endX) 0L
    else x.sizeLongOpt.map(v => {
      val need = endX - i - 1
      var sz : Long = if(v < need) v else need
      if(i<start) sz = sz - start + i + 1
      sz max 0
    })

  override def doc = super.doc +@= (0, "", range)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
