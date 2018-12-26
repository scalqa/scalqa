package scalqa; package Stream; package Z; package extend; package filter

private[Stream] object dropAt {

  def apply[@specialized(DATA) A](s: Stream[A], r: Idx.Range): Stream[A] = new Stream[A] with A.Extended.Filter[A] {
    protected var i = 0

    def prime = {
      while (r.contains(i) && real.prime) { i += 1; real.pump }
      real.prime
    }

    def pump = { i += 1; real.pump }

    def foreach(c: Consumer[A]) = {
      val st = r.start; val e = r.end
      while (i < e && s.prime) { val v = s.pump; if (i < st) c.accept(v); i += 1 }
      s.foreach(c)
    }

    def real = s
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
