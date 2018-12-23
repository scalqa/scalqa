package scalqa; package Stream; package Z; package extend; package filter

private[Stream] object dropWhile {

  @inline final def apply[@specialized(DATA) A](s: Stream[A], f: Filter[A]): Stream[A] = new Stream[A] with A.Extended.Filter[A] {
    protected var first: A = _
    protected var dropped, isFirst = false

    def prime =
      if (dropped) isFirst || real.prime
      else { dropped = true; while (!isFirst && real.prime) { val v = real.pump; if (!f.allow(v)) { first = v; isFirst = true } }; isFirst }

    def pump = {
      if (isFirst) { isFirst = false; first }
      else real.pump
    }

    def foreach(c: Consumer[A]) = if (prime) { c.accept(pump); s.foreach(c) }

    @inline final def real = s
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
