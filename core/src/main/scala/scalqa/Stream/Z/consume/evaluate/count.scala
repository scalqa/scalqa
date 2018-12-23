package scalqa; package Stream; package Z; package consume; package evaluate

private[Stream] object count {

  def apply[@specialized(DATA) A](s: Stream[A]): Int = {
    class Counter extends Consumer[A] {
      var count = 0
      def accept(v: A) = count += 1
    }
    val c = new Counter
    s.foreach(c)
    c.count
  }

  def apply[@specialized(DATA) A](s: Stream[A], f: Filter[A]): Int = {
    class Counter extends Consumer[A] {
      var count = 0
      def accept(v: A) = if (f.allow(v)) count += 1
    }
    val c = new Counter
    s.foreach(c)
    c.count
  }

  def andTime[@specialized(DATA) A](s: Stream[A]): (Int, Duration) = {
    val t = Time.now
    (s.count, t.age)
  }

  def few[@specialized(DATA) A](flow: Flow[A], fun: Array[Filter[A]]): Idx[Int] = {
    class Result extends Idx[Int] with Any.Able.Void with Consumer[A] {
      var _void = true
      val size = fun.size
      protected val array = new Array[Int](size)
      def apply(i: Int) = array(i)
      override def isVoid = _void
      def accept(v: A) = {
        _void = false
        var i = 0;
        while (i < size) { if (fun(i).allow(v)) array(i) += 1; i += 1 }
      }
    }
    val r = new Result
    flow.foreachSynchronized(r)
    r
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
