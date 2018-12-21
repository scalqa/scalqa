package scalqa; package Stream; package Z; package extend; package flow

private class sequential[A] private (flow: Flow[A]) extends Stream.A.Base[A] {
  val originalSizeOpt = flow.sizeOpt
  var cnt = 0
  var started, filled = false;
  object buf extends java.util.Stack[A] with Consumer[A] { def accept(v: A) = synchronized(add(v)) }

  def prime = {
    if (!started) startFill
    while (!filled && buf.size == 0) App.pause(1.Millis)
    buf.size > 0
  }

  def pump = synchronized { cnt += 1; buf.pop }

  override def foreach(c: Consumer[A]) = {
    while (!filled && prime) c.accept(pump)
    if (buf.size > 0) {
      buf.all.foreach(c)
      buf.clear
    }
  }

  override def sizeOpt: Opt.Int = originalSizeOpt.map(_ - cnt)

  override def ilkOpt = flow.ilkOpt

  private def startFill: Unit = synchronized(if (!started) {
    started = true;
    Future { flow.foreach(buf); filled = true }
  })
}

private[Stream] object sequential {

  def apply[A](src: Flow[A]): Stream[A] = src match {
    case v: Stream[A] => v
    case v: ~[_]      => v.asInstanceOf[Stream[A]]
    case v            => new sequential(v)
  }
}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
