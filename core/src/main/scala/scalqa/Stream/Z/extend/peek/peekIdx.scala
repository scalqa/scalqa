package scalqa; package Stream; package Z; package extend; package peek

private[Stream] object peekIdx {

  def apply[@specialized(DATA) A](s: Stream[A], c: Consumer.Idx[A], start: Int): Stream[A] = new Stream[A] with A.Extended.All[A] {
    protected var i = start

    @inline final def real = s

    @inline final def prime = real.prime

    def pump = { val v = real.pump; c.accept(i, v); i += 1; v }

    def foreach(ec: Consumer[A]) = {
      class Each extends Consumer[A] {
        var j = i
        def accept(v: A) = { c.accept(j, v); j += 1; ec.accept(v) }
      }
      s.foreach(new Each)
    }
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
