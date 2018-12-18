package scalqa; package App; package Event; package Z

private[App] abstract class Scheduled(f: () => Any) extends App.Event.A.Base with Runnable {

  protected val future: java.util.concurrent.Future[_]

  protected override def fireCancel: Unit = { if (!(future.isDone || future.isCancelled)) future.cancel(false); super.fireCancel }

  def run =
    if (isActive) try f() catch {
      case t: Throwable =>
        if (t != App.Event.CancelException) t.printStackTrace();
        cancel;
        throw App.Event.CancelException
    }
    else throw App.Event.CancelException
}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
