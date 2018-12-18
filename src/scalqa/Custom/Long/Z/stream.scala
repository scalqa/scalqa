package scalqa; package Custom; package Long; package Z

private[Long] object stream {

  abstract class Base extends Stream[Long] with Stream.A.Specialized[Long] {
    protected var has = true

    @inline def prime = has

    @inline def foreach(c: Stream.Consumer[Long]) = while (prime) c.accept(pump)

    @inline override def ilkOpt = Ilk.Longs

  }

  class Up(var cur: Long) extends Base {

    def pump = { val v = cur; if (cur < scala.Long.MaxValue) cur += 1 else has = false; v }

    @inline override def sortedOpt = Ordering.Long
  }

  class Down(var cur: Long) extends Base {

    def pump = { val v = cur; if (cur > scala.Long.MinValue) cur -= 1 else has = false; v }

    @inline override def sortedOpt = Ordering.Long.reverse
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
