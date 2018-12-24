package scalqa; package Stream; package Z; package extend; package filter

import Stream.A.Specialized.Indexed

private[Stream] object dropNext {

  def apply[@specialized(DATA) A](s: Stream[A], sz: Int): Stream[A] = s match {
    case v: Indexed[_] =>
      v._position = v._position + sz min Indexed.size(v)
      v
    case _ => new Stream[A] with A.Extended.Filter[A] {

      protected var i = if (sz < 0) 0 else sz

      def prime = {
        def skip = while (i > 0 && real.prime) { i -= 1; real.pump }
        if (i > 0) skip
        real.prime
      }

      def pump = real.pump

      def foreach(f: Consumer[A]) = if (prime) s.foreach(f)

      override def sizeOpt = real.sizeOpt.map(_ - i)

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
