package scalqa; package fx; package scene; package application; import language.implicitConversions

object Thread extends concurrent.ExecutionContext:
  def is                                                                    : Boolean       = javafx.application.Platform.isFxApplicationThread
  def apply(fun: => Unit)                                                   : Unit          = if (is) fun else execute(z_DelayedJob(fun))
  def execute(v: Runnable)                                                  : Unit          = if (is) v.run else javafx.application.Platform.runLater(v)
  def reportFailure(cause: Throwable)                                       : Unit          = J.Vm.Setup.defaultExecutionContext.reportFailure(cause)
  def scheduleIn(delay: Time.Length, f: => Unit)                            : Event.Control = J.scheduleIn(delay, execute(new z_DelayedJob(f)))
  def scheduleEvery(period: Time.Length, f: => Unit)                        : Event.Control = scheduleEveryIn(period, period, f)
  def scheduleEveryIn(delay: Time.Length, period: Time.Length, f: => Unit)  : Event.Control = { val j = z_ScheduledJob(f); J.scheduleEveryIn(delay, period, j.runJob) }

  // ***********************************************************************
  private class z_DelayedJob(fun: => Unit) extends Runnable { def run = fun }

  private class z_ScheduledJob(fun: => Unit) extends Runnable:
    var problem : Opt[Throwable] = \/
    var waiting  = true
    def runJob   = if(problem) throw problem.get; else if(waiting) { waiting = false; execute(this) }
    def run      = try{ fun; waiting = true } catch{ case v: Throwable => problem = v}

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
    @object Thread ->
       [[Thread]] represents "FX Application Thread", the only one allowed to modify GUI controls


@def is -> FX Application Thread check

       Returns `true` if current thread is "FX Application Thread"


@def execute -> Runs function on FX Application Thread

      If current thread is FX Application Thread, the function is run immediately

      Otherwise it is scheduled for later


@def scheduleIn -> Runs function on FX Application Thread with delay

      Schedule the function to run once


*/
