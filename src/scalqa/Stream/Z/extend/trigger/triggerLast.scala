package scalqa; package Stream; package Z; package extend; package trigger

private[Stream] object triggerLast {

  @inline def apply[@specialized(DATA) A](s: Stream[A], tlf: (Int, Duration) => Unit): Stream[A] = new Stream[A] with A.Extended.All[A] {
    protected var i = 0;
    protected var t: Time = \/
    protected var hot = true

    def prime = {
      if (i == 0) t = Time.now
      val b = real.prime
      if (!b && hot && i > 0) { hot = false; tlf(i, t.age) }
      b
    }

    @inline def pump = { i += 1; real.pump }

    def foreach(c: Consumer[A]) = if (prime) {
      class Each extends Consumer[A] {
        var j = i
        def accept(v: A) { c.accept(v); j += 1 }
      }
      val e = new Each
      s.foreach(e)
      tlf(e.j, t.age)
    }

    @inline override def real = s
  }

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
