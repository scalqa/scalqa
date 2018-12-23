package scalqa; package Custom; package Int; package Z

private[Int] object stream {

  @inline final def up(from: Int): ~[Int] = {
    val sz = scala.Int.MaxValue - from.toLong
    if (sz <= scala.Int.MaxValue) new Stream[Int] with UpBase with Stream.A.Specialized.Indexed[Int] {
      @inline val _size = sz.toInt
      @inline final def _apply(i: Int) = from + i
      @inline final def pump = _pumpIndexed
      override def foreach(f: Stream.Consumer[Int]) = _consumeIndexed(f)
    }
    else new UpBase {
      var l = from.toLong
      @inline final def prime = l <= scala.Int.MaxValue
      @inline final def pump = { val v = l.toInt; l += 1; v }
    }
  }

  @inline final def down(from: Int): ~[Int] = {
    val sz = from.toLong - scala.Int.MinValue
    if (sz <= scala.Int.MaxValue) new Stream[Int] with DownBase with Stream.A.Specialized.Indexed[Int] {
      @inline val _size = sz.toInt
      @inline final def _apply(i: Int) = from - i
      @inline final def pump = _pumpIndexed
      override def foreach(f: Stream.Consumer[Int]) = _consumeIndexed(f)
    }
    else new DownBase {
      var l = from.toLong
      @inline final def prime = l >= scala.Int.MinValue
      @inline final def pump = { val v = l.toInt; l -= 1; v }
    }
  }

  // ------------------------------------------------------------------------------------------------------------------------------------
  private trait UpBase extends Stream[Int] with Stream.A.Specialized[Int] {
    override def foreach(c: Stream.Consumer[Int]) = while (prime) c.accept(pump)
    override def sortedOpt: Opt[scala.Ordering[Int]] = Ordering.Int
    override def ilkOpt = Ilk.Ints
  }

  private trait DownBase extends UpBase {
    override def sortedOpt: Opt[scala.Ordering[Int]] = Ordering.Int.reverse
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
