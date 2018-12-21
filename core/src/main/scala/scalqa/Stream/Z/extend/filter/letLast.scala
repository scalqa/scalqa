package scalqa; package Stream; package Z; package extend; package filter

import Stream.A.Specialized.Indexed

private[Stream] object letLast {

  def apply[@specialized(DATA) A](s: Stream[A], cnt: Int): Stream[A] = s match {
    case v if (cnt <= 0) => \/
    case v: Indexed[_] =>
      val sz = Indexed.size(v) - v._position
      if (sz > cnt) v._position += sz - cnt
      v
    case v if (s.sizeOpt.let(_ <= cnt)) => s
    case v => new Stream[A] with A.Extended.Filter[A] {
      val real = s.preview
      protected var in = false

      lazy val buf = {
        in = true
        val a = real.previewIlk.mkArray[A](cnt)
        var i = 0
        real.foreach(v => { a(i % cnt) = v; i += 1 })
        new Idx[A] {
          val off = if (i < cnt) 0 else i
          val size = i min cnt;
          def apply(i: Int) = a((i + off) % cnt).asInstanceOf[A]
        }.all
      }

      @inline def prime = buf.prime

      @inline def pump = buf.pump

      def foreach(f: Consumer[A]) = buf.foreach(f)

      @inline override def sizeOpt = in.!.toOpt(real).letMap(_.sizeOpt) orOpt buf.sizeOpt
    }
  }
}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
