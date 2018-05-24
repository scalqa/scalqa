package scalqa; package Range; package Z; package The

private[Range] object Primitive {

  class Bytes(val start: Byte, override val startExclusive: Boolean, val end: Byte, override val endExclusive: Boolean) extends Range[Byte] {
    type THIS = Bytes
    def sorting = Sorting.The.Byte
    override def startContains(v: Byte, x: Boolean = false) = start < v || start == v && (x || !startExclusive)
    override def endContains(v: Byte, x: Boolean = false) = end > v || end == v && (x || !endExclusive)
    protected def _get(s: Byte, sx: Boolean, e: Byte, ex: Boolean) = new Bytes(s, sx, e, ex)
  }

  class Chars(val start: Char, override val startExclusive: Boolean, val end: Char, override val endExclusive: Boolean) extends Range[Char] {
    type THIS = Chars
    def sorting = Sorting.The.Char
    override def startContains(v: Char, x: Boolean = false) = start < v || start == v && (x || !startExclusive)
    override def endContains(v: Char, x: Boolean = false) = end > v || end == v && (x || !endExclusive)
    protected def _get(s: Char, sx: Boolean, e: Char, ex: Boolean) = new Chars(s, sx, e, ex)
  }

  class Shorts(val start: Short, override val startExclusive: Boolean, val end: Short, override val endExclusive: Boolean) extends Range[Short] {
    type THIS = Shorts
    def sorting = Sorting.The.Short
    override def startContains(v: Short, x: Boolean = false) = start < v || start == v && (x || !startExclusive)
    override def endContains(v: Short, x: Boolean = false) = end > v || end == v && (x || !endExclusive)
    protected def _get(s: Short, sx: Boolean, e: Short, ex: Boolean) = new Shorts(s, sx, e, ex)
  }

  class Ints(val start: Int, override val startExclusive: Boolean, val end: Int, override val endExclusive: Boolean) extends Range[Int] {
    type THIS = Ints
    def sorting = Sorting.The.Int
    override def startContains(v: Int, x: Boolean = false) = start < v || start == v && (x || !startExclusive)
    override def endContains(v: Int, x: Boolean = false) = end > v || end == v && (x || !endExclusive)
    protected def _get(s: Int, sx: Boolean, e: Int, ex: Boolean) = new Ints(s, sx, e, ex)
  }

  class Longs(val start: Long, override val startExclusive: Boolean, val end: Long, override val endExclusive: Boolean) extends Range[Long] {
    type THIS = Longs
    def sorting = Sorting.The.Long
    override def startContains(v: Long, x: Boolean = false) = start < v || start == v && (x || !startExclusive)
    override def endContains(v: Long, x: Boolean = false) = end > v || end == v && (x || !endExclusive)
    protected def _get(s: Long, sx: Boolean, e: Long, ex: Boolean) = new Longs(s, sx, e, ex)
  }

  class Doubles(val start: Double, override val startExclusive: Boolean, val end: Double, override val endExclusive: Boolean) extends Range[Double] {
    type THIS = Doubles
    def sorting = Sorting.The.Double
    override def startContains(v: Double, x: Boolean = false) = start < v || start == v && (x || !startExclusive)
    override def endContains(v: Double, x: Boolean = false) = end > v || end == v && (x || !endExclusive)
    protected def _get(s: Double, sx: Boolean, e: Double, ex: Boolean) = new Doubles(s, sx, e, ex)
  }

  class Floats(val start: Float, override val startExclusive: Boolean, val end: Float, override val endExclusive: Boolean) extends Range[Float] {
    type THIS = Floats
    def sorting = Sorting.The.Float
    override def startContains(v: Float, x: Boolean = false) = start < v || start == v && (x || !startExclusive)
    override def endContains(v: Float, x: Boolean = false) = end > v || end == v && (x || !endExclusive)
    protected def _get(s: Float, sx: Boolean, e: Float, ex: Boolean) = new Floats(s, sx, e, ex)
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/