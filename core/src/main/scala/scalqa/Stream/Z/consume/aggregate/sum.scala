package scalqa; package Stream; package Z; package consume; package aggregate

private[Stream] object sum {

  def apply[@specialized(DATA) A](s: Stream[A])(implicit m: Numeric[A]): A = {
    class Each extends Consumer[A] {
      val n = m.custom
      var sum = n.zero
      def accept(v: A) = sum = n.plus(sum, v)
    }
    val e = new Each
    s.foreach(e)
    e.sum
  }

  def few[A, B](src: Stream[A], f: Seq[Mapping[A, B]])(implicit n: Numeric[B]): Idx[B] = {
    class Result extends Consumer[A] with Idx[B] with Any.Able.Void {
      val size = f.size
      val i = n.zero.I.ilk
      val array = i.mkArray[B](size)
      if (!i.isPrimitive) array.fill(n.zero)
      var _isVoid = true
      def accept(v: A) {
        _isVoid = false
        var i = 0
        while (i < size) { array(i) = n.plus(array(i), f(i)(v)); i += 1 }
      }
      def apply(i: Int) = array(i)
      override def isVoid = _isVoid
    }
    val r = new Result
    src.foreach(r)
    r
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
