package scalqa; package Stream; package Z; package extend; package trigger

private[Stream] object triggerFirst {

  @inline final def apply[@specialized(DATA) A](s: Stream[A], fun: Time => Unit): Stream[A] = new Stream[A] with A.Extended.All[A] {

    protected var hot = true

    def prime = {
      val b = real.prime
      if (hot && b) {
        fun(Time.now)
        hot = false
      }
      b
    }

    @inline final def pump = real.pump

    def foreach(f: Consumer[A]) = if (prime) s.foreach(f)

    @inline final override def real = s
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
