package scalqa; package Stream; package Z; package extend; package filter

private[Stream] object letWhile {

  @inline def apply[@specialized(DATA) A](s: Stream[A], f: Filter[A]): Stream[A] = new Stream[A] with A.Extended.Filter[A] {
    protected var open = true
    protected var has = false
    protected var v: A = _

    def prime = has || open && { has = real.prime && { v = real.pump; f.allow(v) }; open = has; has }

    @inline def pump = { has = false; v }

    def foreach(c: Consumer[A]) = while (prime) c.accept(pump)

    @inline def real = s
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
