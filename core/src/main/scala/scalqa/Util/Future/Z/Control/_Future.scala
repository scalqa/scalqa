package scalqa; package Util; package Future; package Z; package Control

private[Control] trait _Future[A] { self: _Class[A] =>

  private[Control] def addEvent(e: Event[A]): Unit = get match {
    case o: Out[A] => e.fire(o)
    case p: Control[A] => rootControl(p).addEvent(e)
    case l: List[_] if (compareAndSet(l, e :: l)) => ()
    case _ => addEvent(e)
  }

  private[Control] def addEventList(l: List[Event[A]]): Unit = if (l.nonEmpty) {
    get match {
      case o: Out[A] => l.foreach(_.fire(o))
      case p: Control[A] => rootControl(p).addEventList(l)
      case v: List[_] if (compareAndSet(v, v ++ l)) => ()
      case _ => addEventList(l)
    }
  }

  // **************************************************************************************
  val future = new Future

  class Future extends Util.Future[A] with Linkable {

    def resultOpt = get match {
      case v: Out[A]     => v
      case p: Control[A] => rootControl(p).future.resultOpt
      case _             => Opt.Void
    }

    def onComplete(c: Out[A] => Unit)(implicit e: concurrent.ExecutionContext) = addEvent(new Event(e, c))

    private[Z] override def linkTo(v: Control[_]): Unit = {
      val p = v.asInstanceOf[Control[A]]
      linkRoot(p.get() match { case v: Control[A] => p.rootControl(v); case _ => p })
    }
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
