package scalqa; package Stream; package Z; package extend; package group

private[Stream] object sliding {

  @inline def apply[@specialized(DATA) A](s: Stream[A], frameSize: Int, step: Int): Stream[~[A]] = {

    class Frame extends Stream[A] with Stream.A.Specialized.Indexed[A] {
      val array: Array[A] = s.ilkDefault.mkArray[A](frameSize)
      var from = -step
      var sz = step
      var ready = false

      def load: Boolean = ready || {
        if (s.prime) {
          from = (from + step) % frameSize
          sz -= step
          while (sz < frameSize && s.prime) {
            array((from + sz) % frameSize) = s.pump
            sz += 1
          }
          ready = sz > 0
        }
        ready
      }
      def deliver = { _position = 0; ready = false; this }
      @inline def _apply(i: Int): A = array((from + i) % frameSize)
      @inline def _size = sz
      @inline def foreach(f: Consumer[A]) = _consumeIndexed(f)
      @inline def pump = _pumpIndexed
    }

    new Stream[~[A]] with A.Extended[~[A]] {
      protected val frame = new Frame

      @inline def prime = frame.load
      @inline def pump: Stream[A] = frame.deliver
      @inline def foreach(c: Consumer[~[A]]) = while (prime) c.accept(pump)
      @inline override def ilkOpt = Ilk.Refs
      @inline def real = s
    }
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
