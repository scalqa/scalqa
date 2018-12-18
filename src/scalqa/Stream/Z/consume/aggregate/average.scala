package scalqa; package Stream; package Z; package consume; package aggregate

private[Stream] object average {

  def Opt[@specialized(DATA) A](s: Stream[A])(implicit m: Numeric[A]): Opt[A] = {
    class Sum extends Reducer[A] {
      val n = m.custom
      var cnt = 0
      init(n.zero)

      def reduce(x: A, y: A) = { cnt += 1; n.plus(x, y) }
    }

    val sum = new Sum
    s.foreach(sum)
    sum.toOpt.map(v => sum.n.divByInt(v, sum.cnt))
  }

  def Few[A, B](s: Stream[A], f: Seq[Mapping[A, B]])(implicit m: Numeric[B]): Idx[B] = {
    class Result extends Consumer[A] with Idx[B] with Any.Able.Void {
      val n = m.custom
      val size = f.size
      val c = n.zero.Class
      val array = c.ilk.mkArray[B](size)
      if (!c.real.isPrimitive) array.fill(n.zero)
      var cnt = 0

      override def isVoid = cnt == 0
      def apply(i: Int) = array(i)

      def accept(v: A) = {
        cnt += 1
        var i = 0
        while (i < size) { array(i) = n.plus(array(i), f(i)(v)); i += 1 }
      }

      def divide = if (cnt > 0) {
        var i = 0;
        while (i < size) { array(i) = n.divByInt(array(i), cnt); i += 1 }
      }
    }
    val r = new Result
    s.foreach(r)
    r.divide
    r
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
