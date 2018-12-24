package scalqa; package Stream; package Z; package extend; package trigger

private[Stream] object triggerEvery {

  def apply[@specialized(DATA) A](s: Stream[A], tl: Duration, f: (Int, Duration) => Unit): Stream[A] = new Stream[A] with A.Extended.All[A] {
    protected var i = 0
    protected var start, time: Time = \/

    def prime = {
      def init = { time = Time.now; start = time }
      if (i == 0) init
      real.prime
    }

    def pump = { check; real.pump }

    def foreach(c: Consumer[A]) = if (prime) s.foreach(v => { check; c.accept(v) })

    protected def check = {
      if (time.age > tl) {
        time = Time.now
        f(i, start.age.round(tl / 10, DOWN))
      }
      i += 1
    }

    override def real = s
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
