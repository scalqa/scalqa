package scalqa; package Concurrent; package Promise; package Z

private[Promise] class The[A] extends java.util.concurrent.atomic.AtomicReference[Any](\/ : Coll.Val[_]) with Promise[A] {

  def resultOpt = get.I.letAs(classOf[Opt.orError[A]])

  def complete(rslt: Opt.orError[A]): Boolean = get match {
    case _: Opt.orError[_] => false
    case v                 => if (compareAndSet(v, rslt)) { v.cast[Coll.Val[Event[A]]].all(_ fire rslt); true } else complete(rslt)
  }

  def onResult(f: Opt.orError[A] => Any)(implicit e: Executor): this.type = {
    get match {
      case o: Opt.orError[_] => new Event(e, f).fire(o.cast)
      case c: Coll.Val[_]    => c.cast[Coll.Val[Event[A]]].I(c => if (!compareAndSet(c, c + new Event(e, f))) onResult(f)(e))
    }
    this
  }
}

// ************************************************************************************************
private class Event[A](executor: Executor, job: Opt.orError[A] => Any) extends Runnable {
  private var value: Opt.orError[A] = \/

  def fire(v: Opt.orError[A]): Unit = { value = v; executor.execute(this) }

  def run() = job(value)
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
