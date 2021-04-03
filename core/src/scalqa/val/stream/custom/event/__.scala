package scalqa; package `val`; package stream; package custom; import language.implicitConversions

class Event extends event.Monitor:
  private   var beforeFirst, empty                            : ><[() => Any] = \/
  private   var each, afterLast               : ><[(Int, Time.Length) => Any] = \/
  protected def runOnBeforeFirst                                         : Unit = beforeFirst.~.foreach(_())
  protected def runOnEvery(cnt: Int, tm: Time.Length)                    : Unit = each.~.foreach(_(cnt, tm))
  protected def runOnAfterLast(cnt: Int, tm: Time.Length)                : Unit = afterLast.~.foreach(_(cnt, tm))
  protected def runOnEmpty                                               : Unit = empty.~.foreach(_())

  /**/      def onBeforeFirst[U](l: Time => U)                           : Unit = beforeFirst += { () => l(Time()) }
  /**/      def onEvery[U](c: Int, l: (Int, Time.Length) => U)           : Unit = each = each.join{ var next = c; (cnt, tm) => if (cnt == next) { next += c; l(cnt, tm) }}
  /**/      def onEvery[U](t: Time.Length, l: (Int, Time.Length) => U)   : Unit = each = each.join(new Listener(t,l))
  /**/      def onAfterLast[U](l: (Int, Time.Length) => U)               : Unit = afterLast += ((c, t) => l(c, t))
  /**/      def onEmpty[U](l: () => U)                                   : Unit = empty += l

  // ***************************************************************************************
  private class Listener(t: Time.Length, l: (Int, Time.Length) => Any) extends java.util.concurrent.atomic.AtomicLong(0L) with ((Int, Time.Length) => Any):
    def apply(cnt: Int, len: Time.Length): Unit =
      get match
      case v if v == 0 => if (!compareAndSet(v, System.nanoTime + t.nanosTotal)) apply(cnt, len)
      case v if v > System.nanoTime => ()
      case v if (compareAndSet(v, System.nanoTime + t.nanosTotal)) => l(cnt, len)
      case _ => apply(cnt, len)

object Event:
  type Monitor = event.Monitor;     inline def Monitor = event.Monitor


/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
