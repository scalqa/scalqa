package scalqa; package Stream; package Z; package extend; package filter

private[Stream] object drop {

  @inline def apply[@specialized(DATA) A](s: Stream[A], f: Filter[A]): Stream[A] = new Stream[A] with A.Extended.Filter[A] {
    protected var has = false
    protected var v: A = _

    def prime = has || { while (!has && real.prime) { v = real.pump; has = !f.allow(v) }; has }

    @inline def pump = { has = false; v }

    def foreach(c: Consumer[A]) = {
      if (has) c.accept(pump)
      s.foreach(new Consumer[A] { def accept(v: A) = if (!f.allow(v)) c.accept(v) })
    }

    @inline override def real = s
  }
}
