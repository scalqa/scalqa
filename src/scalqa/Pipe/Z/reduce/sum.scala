package scalqa; package Pipe; package Z; package reduce

private[Pipe] object sum {

  def apply[A, NUM <: Numeric](src: Flow[A], c: Any.As.Numeric[A, NUM]): NUM = src.foldAsOpt[c.VALUE](c.math.Zero, (b, a) => c.math.add(b, c(a)), c.math.add(_, _)).map(c.numeric) or c.void

  def few[A, B, NUM <: Numeric](src: Flow[A], f: A => B*)(implicit c: Any.As.Numeric[B, NUM]): Index[NUM] = c.tag.newArray(f.size, c.math.Zero).I.to(array => {
    {
      src.foldAsOpt[Array[c.VALUE]](
        array,
        (a, v) => { var i = 0; while (i < a.size) { a(i) = c.math.add(a(i), c(f(i)(v))); i += 1 }; a },
        (a, b) => { var i = 0; while (i < a.size) { a(i) = c.math.add(a(i), b(i)); i += 1 }; a })
    }.map(_.asMap(c.numeric)) or new Index.The.Proxy(array.asMap(c.numeric)) with Void
  })
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/