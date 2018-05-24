package scalqa; package Pipe; package Z; package reduce

private[Pipe] object average {

  def apply[A, NUM <: Numeric](src: Flow[A], c: Any.As.Numeric[A, NUM]): NUM = {
    var sum = c.math.Zero;
    val cnt = src.synchronize.peek(v => sum = c.math.add(sum, c(v))).count()
    if (cnt == 0) c.void else c.numeric(c.math.divide(sum, c.math(cnt)))
  }

  def few[A, B, NUM <: Numeric](src: Flow[A], f: A => B*)(implicit c: Any.As.Numeric[B, NUM]): Index[NUM] = c.tag.newArray(f.size + 1, c.math.Zero).I.to(array => {
    {
      src.foldAsOpt[Array[c.VALUE]](
        array,
        (a, v) => {
          a(0) = c.math.add(a(0), c.math.One)
          var i = 1
          while (i < a.size) { a(i) = c.math.add(a(i), c(f(i - 1)(v))); i += 1 }
          a
        },
        (a, b) => {
          var i = 0;
          while (i < a.size) { a(i) = c.math.add(a(i), b(i)); i += 1 }
          a
        })
    }.map(a => a.all.dropFirst(1).map(c.math.divide(_, a(0))).map(c.numeric).as[Index]) or new Index.The.Proxy(array.asMap(c.numeric).asTail(1)) with Void
  })

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/