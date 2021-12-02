package scalqa; package `val`; package stream; package z; package _build; package _group; import language.implicitConversions

class sliding(x: Stream[AnyRef], size: Int, step: Int) extends z.x.Pipe[Stream[AnyRef]](x):
  private var pa: Array[AnyRef] = null
  private var pos = 0

  def readOpt : Opt[Stream[AnyRef]] =
    val a = new Array[AnyRef](size)
    if (pos > 0)
      var i = pos;
      while (i > 0) { a(pos - i) = pa(size - i); i -= 1 }
    else if(pos < 0)
      while (pos < 0 && x.readOpt) pos += 1
      if (pos < 0) return VOID
    pa = a
    val sz = read(a, pos)
    if (sz == pos) return VOID
    pos = size - step
    (sz > 0) ? a.stream(sz)

  def read(a: Array[AnyRef], from: Int): Int =
    var i = from
    while (i < a.length)
      val o = x.readOpt
      if (!o) return i
      a(i) = o.get
      i += 1
    i

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
