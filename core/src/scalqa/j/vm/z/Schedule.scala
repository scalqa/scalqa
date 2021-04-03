package scalqa; package j; package vm; package z

private[scalqa] object Schedule:

  def everyIn[U](period: Time.Length, initDelay: Time.Length, job: () => U): Event.Control =
    val c = zEventControl(job)
    c.future = Setup.schedular_*().scheduleAtFixedRate(c, initDelay.nanosTotal.toLong, period.nanosTotal.toLong, java.util.concurrent.TimeUnit.NANOSECONDS)
    c

  def in[U](delay: Time.Length, job: () => U): Event.Control =
    val c = zEventControl(job)
    c.future = Setup.schedular_*().schedule(c, delay.nanosTotal.toLong, java.util.concurrent.TimeUnit.NANOSECONDS)
    c

  def apply(r: Runnable): Unit = Setup.defaultExecutionContext.execute(r)

  // ********************************************************************************************************************
  private class zEventControl(l: () => Any) extends Event.Control.X.Basic(l) with Runnable:
    var future: java.util.concurrent.Future[_] = null

    protected override def fireOnCancel =
      if (!(future.isDone || future.isCancelled)) future.cancel(false)
      super.fireOnCancel

    override def run: Unit =
      try
        target_?.forval(_())
      catch
      case t: Throwable =>
        if (t != Event.CancelRequest) t.printStackTrace();
        cancel;
        throw Event.CancelRequest

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
