package scalqa; package Stream; package Z; package consume; package foreach

private[Stream] object Idx {

  def apply[@specialized(DATA) A](s: Stream[A], c: Consumer.Idx[A], start: Int = 0) = {

    class Run extends Consumer[A] {
      var i = start;
      def accept(v: A) { c.accept(i, v); i += 1 }
    }

    s.foreach(new Run)
  }

}
