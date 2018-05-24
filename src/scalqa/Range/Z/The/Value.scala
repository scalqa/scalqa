package scalqa; package Range; package Z; package The

private[Range] object Value {
  import Any.{ Value => V }

  class Bytes[A <: V.Byte](c: V.Byte.Companion[A], s: Byte, override val startExclusive: Boolean, e: Byte, override val endExclusive: Boolean) extends Range[A] {
    def this(s: V.Byte, sx: Boolean, e: V.Byte, ex: Boolean) = this(s.kin.cast, s._real, sx, e._real, ex)
    type THIS = Bytes[A]; def start = c.map(s); def end = c.map(e); def sorting = Sorting.The.Itself
    override def startContains(v: A, x: Boolean = false) = s < v._real || s == v._real && (x || !startExclusive)
    override def endContains(v: A, x: Boolean = false) = e > v._real || e == v._real && (x || !endExclusive)
    protected def _get(s: A, sx: Boolean, e: A, ex: Boolean) = new Bytes(c, s._real, sx, e._real, ex)
  }

  class Chars[A <: V.Char](c: V.Char.Companion[A], s: Char, override val startExclusive: Boolean, e: Char, override val endExclusive: Boolean) extends Range[A] {
    def this(s: V.Char, sx: Boolean, e: V.Char, ex: Boolean) = this(s.kin.cast, s._real, sx, e._real, ex)
    type THIS = Chars[A]; def start = c.map(s); def end = c.map(e); def sorting = Sorting.The.Itself
    override def startContains(v: A, x: Boolean = false) = s < v._real || s == v._real && (x || !startExclusive)
    override def endContains(v: A, x: Boolean = false) = e > v._real || e == v._real && (x || !endExclusive)
    protected def _get(s: A, sx: Boolean, e: A, ex: Boolean) = new Chars(c, s._real, sx, e._real, ex)
  }

  class Shorts[A <: V.Short](c: V.Short.Companion[A], s: Short, override val startExclusive: Boolean, e: Short, override val endExclusive: Boolean) extends Range[A] {
    def this(s: V.Short, sx: Boolean, e: V.Short, ex: Boolean) = this(s.kin.cast, s._real, sx, e._real, ex)
    type THIS = Shorts[A]; def start = c.map(s); def end = c.map(e); def sorting = Sorting.The.Itself
    override def startContains(v: A, x: Boolean = false) = s < v._real || s == v._real && (x || !startExclusive)
    override def endContains(v: A, x: Boolean = false) = e > v._real || e == v._real && (x || !endExclusive)
    protected def _get(s: A, sx: Boolean, e: A, ex: Boolean) = new Shorts(c, s._real, sx, e._real, ex)
  }

  class Ints(c: V.Int.Companion[V.Int], s: Int, override val startExclusive: Boolean, e: Int, override val endExclusive: Boolean) extends Range[V.Int] {
    def this(s: V.Int, sx: Boolean, e: V.Int, ex: Boolean) = this(s.kin.cast, s._real, sx, e._real, ex)
    type THIS = Ints; def start = c.map(s); def end = c.map(e); def sorting = Sorting.The.Itself
    override def startContains(v: V.Int, x: Boolean = false) = s < v._real || s == v._real && (x || !startExclusive)
    override def endContains(v: V.Int, x: Boolean = false) = e > v._real || e == v._real && (x || !endExclusive)
    protected def _get(s: V.Int, sx: Boolean, e: V.Int, ex: Boolean) = new Ints(c, s._real, sx, e._real, ex)
  }

  class Longs[A <: V.Long](c: V.Long.Companion[A], s: Long, override val startExclusive: Boolean, e: Long, override val endExclusive: Boolean) extends Range[A] {
    def this(s: V.Long, sx: Boolean, e: V.Long, ex: Boolean) = this(s.kin.cast, s._real, sx, e._real, ex)
    type THIS = Longs[A]; def start = c.map(s); def end = c.map(e); def sorting = Sorting.The.Itself
    override def startContains(v: A, x: Boolean = false) = s < v._real || s == v._real && (x || !startExclusive)
    override def endContains(v: A, x: Boolean = false) = e > v._real || e == v._real && (x || !endExclusive)
    protected def _get(s: A, sx: Boolean, e: A, ex: Boolean) = new Longs(c, s._real, sx, e._real, ex)
  }

  class Doubles[A <: V.Double](c: V.Double.Companion[A], s: Double, override val startExclusive: Boolean, e: Double, override val endExclusive: Boolean) extends Range[A] {
    def this(s: V.Double, sx: Boolean, e: V.Double, ex: Boolean) = this(s.kin.cast, s._real, sx, e._real, ex)
    type THIS = Doubles[A]; def start = c.map(s); def end = c.map(e); def sorting = Sorting.The.Itself
    override def startContains(v: A, x: Boolean = false) = s < v._real || s == v._real && (x || !startExclusive)
    override def endContains(v: A, x: Boolean = false) = e > v._real || e == v._real && (x || !endExclusive)
    protected def _get(s: A, sx: Boolean, e: A, ex: Boolean) = new Doubles(c, s._real, sx, e._real, ex)
  }

  class Floats[A <: V.Float](c: V.Float.Companion[A], s: Float, override val startExclusive: Boolean, e: Float, override val endExclusive: Boolean) extends Range[A] {
    def this(s: V.Float, sx: Boolean, e: V.Float, ex: Boolean) = this(s.kin.cast, s._real, sx, e._real, ex)
    type THIS = Floats[A]; def start = c.map(s); def end = c.map(e); def sorting = Sorting.The.Itself
    override def startContains(v: A, x: Boolean = false) = s < v._real || s == v._real && (x || !startExclusive)
    override def endContains(v: A, x: Boolean = false) = e > v._real || e == v._real && (x || !endExclusive)
    protected def _get(s: A, sx: Boolean, e: A, ex: Boolean) = new Floats(c, s._real, sx, e._real, ex)
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/