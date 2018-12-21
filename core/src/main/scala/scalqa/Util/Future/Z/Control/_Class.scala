package scalqa; package Util; package Future; package Z; package Control

private[Future] class _Class[A] extends java.util.concurrent.atomic.AtomicReference[Any](Nil) with Promise[A] with _Future[A] {

  def complete(o: Out[A]): Boolean = get match {
    case _: Out[_] => false
    case p: Control[A] => p.complete(o)
    case v if compareAndSet(v, o) =>
      v.asInstanceOf[List[Event[A]]].foreach(_.fire(o))
      true
    case _ => complete(o)
  }

  private[Control] def linkRoot(p: Control[A]): Unit = if (this ne p)
    get() match {
      case v: Out[A] => if (!p.complete(v)) App.Fail.state("Cannot link completed promises together")
      case v: Control[A] => rootControl(v).linkRoot(p)
      case v: List[_] if compareAndSet(v, p) => p.addEventList(v.asInstanceOf[List[Event[A]]])
      case _ => linkRoot(p)
    }

  private[Control] def rootControl(p: Control[A]): Control[A] = {
    def root(p: Control[A]): Control[A] = p.get() match { case v: Control[A] => root(v); case _ => this }
    var rt = root(p)
    if ((p eq rt) || compareAndSet(p, rt)) rt
    else get() match { case p: Control[A] => rootControl(p); case _ => this }
  }

}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
