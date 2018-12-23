package scalqa; package Stream; package Z; package extend; package filter

private[Stream] object letIdx {

  def apply[@specialized(DATA) A](s: Stream[A], f: Filter.Idx[A], start: Int): Stream[A] = new Stream[A] with A.Extended.Filter[A] {
    protected var i = start
    protected var has = false
    protected var v: A = _

    def prime = has || { while (!has && real.prime) { v = real.pump; has = f.allow(i, v); i += 1 }; has }

    @inline final def pump = { has = false; v }

    def foreach(c: Consumer[A]) = {
      if (has) c.accept(pump)
      class Each extends Consumer[A] {
        var j = i
        def accept(v: A) = {
          if (f.allow(j, v)) c.accept(v)
          j += 1
        }
      }
      s.foreach(new Each)
    }

    @inline final override def real = s
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
