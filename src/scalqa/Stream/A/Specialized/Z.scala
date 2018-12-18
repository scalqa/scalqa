package scalqa; package Stream; package A; package Specialized

private[Specialized] object Z {

  @noinline def preview[@specialized(DATA) A](s: Stream[A] with Indexed[A], cnt: Int): Stream[A] =
    if (cnt <= 0) \/
    else {
      val sz = cnt min s.previewSize
      val v = s.letAt(s._position <>>+ sz)
      s._position += sz
      v
    }

  @noinline def takeWhile[@specialized(DATA) A](s: Stream[A] with Indexed[A], f: Filter[A]): ~[A] = {
    var i = s._position
    val sz = Indexed.size(s)
    while (i < sz && f.allow(Indexed(s, i))) i += 1
    s.take(i - s._position)
  }
}
