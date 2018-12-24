package scalqa; package Idx; package Range; package Z

private[scalqa] object stream {

  def apply(start: Int, sz: Int): Stream[Int] with Any.Able.Stream[Int] = new Base(start, sz) {

    def _apply(i: Int) = start + i

    override def foreach(c: Stream.Consumer[Int]) = { var i = _position; while (i < _size) { c.accept(start + i); i += 1 }; _position = i }

    override def to[TRGT[_]](implicit c: Stream.Interface.To.Converter[TRGT]): TRGT[Int] = c match {
      case Stream.Interface.To.ArrayBuffer => Array.Buffer.loaded[Int](array(start + _position <>> start + _size)).asInstanceOf[TRGT[Int]]
      case v => v.make(this)
    }
  }

  def step(r: Range, step: Int): Stream[Int] with Any.Able.Stream[Int] = stream.step(
    if (step < 0) r.end - 1 else r.start,
    r.size / step.abs + (if (r.size % step != 0) 1 else 0),
    step)

  def step(start: Int, sz: Int, step: Int): Stream[Int] with Any.Able.Stream[Int] = new Base(start, sz) {

    protected override def _apply(i: Int) = start + i * step
  }

  abstract class Base(val start: Int, val _size: Int) extends Stream[Int] with Stream.A.Specialized.Indexed[Int] with Any.Able.Stream[Int] {
    def pump = _pumpIndexed
    def foreach(f: Stream.Consumer[Int]) = _consumeIndexed(f)
    override def sortedOpt = Ordering.Int
    override def ilkOpt = Ilk.Ints
    def all = this
    override def toInfo = super.toInfo.I(_.addAt(0, ("start", start)))
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
