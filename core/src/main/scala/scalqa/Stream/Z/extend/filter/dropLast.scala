package scalqa; package Stream; package Z; package extend; package filter

import Stream.A.Specialized.Indexed

private[Stream] object dropLast {

  def apply[@specialized(DATA) A](s: Stream[A], cnt: Int): Stream[A] = s match {
    case _ if (cnt <= 0)                => s
    case _ if (s.sizeOpt.let(_ <= cnt)) => \/
    case v: Indexed[_] => new Stream[A] with A.Extended.All[A] with Indexed[A] {

      protected val from = real._position

      val _size = Indexed.size(real) - from - cnt max 0

      def _apply(i: Int): A = Indexed.apply(real, from + i)
      def pump = _pumpIndexed
      def foreach(f: Consumer[A]) = _consumeIndexed(f)
      def real = v.asInstanceOf[Stream[A] with Indexed[A]]
    }
    case _ => new Stream[A] with A.Extended.Filter[A] {
      protected val real = s.preview
      protected val array = real.previewIlk.mkArray[A](cnt)
      protected var i = 0

      def prime = {
        def load = while (i < cnt && real.prime) { array(i) = real.pump; i += 1 }
        if (i == 0) load
        real.prime
      }

      def pump = {
        val v = array(i % cnt)
        array(i % cnt) = real.pump
        i += 1
        v
      }

      def foreach(c: Consumer[A]) = {
        class Each extends Consumer[A] {
          var j = i
          i = cnt
          def accept(v: A) = {
            val s = j % cnt
            c.accept(array(s))
            array(s) = real.pump
            j += 1
          }
        }
        if (prime) s.foreach(new Each)
      }

      override def sizeOpt = real.sizeOpt.map(_ - cnt)
    }
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
