package scalqa; package Stream; package Z; package extend; package filter

import Stream.A.Specialized.Indexed

private[Stream] object letAt {

  def apply[@specialized(DATA) A](s: Stream[A], r: Idx.Range): Stream[A] = s match {
    case v: Indexed[_] => new Stream[A] with A.Extended.All[A] with Indexed[A] {
      protected val from = r.start + real._position
      protected val _size = r.size min Indexed.size(real) - from
      def _apply(i: Int): A = Indexed(real, from + i)
      def pump = _pumpIndexed
      def foreach(f: Consumer[A]) = _consumeIndexed(f)
      def real = v.asInstanceOf[Stream[A] with Indexed[A]]
    }
    case v => new Stream[A] with A.Extended.Filter[A] {
      val start = r.start
      val end = r.end
      var i = 0

      def prime = {
        while (i < start && real.prime) { i += 1; real.pump }
        i < end && real.prime
      }

      def pump = { i += 1; real.pump }

      def foreach(c: Consumer[A]) = while (prime) c.accept(pump)

      def real = s
    }
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
