package scalqa; package Fx; package Application; package Z

import concurrent.ExecutionContext

private[Fx] class Promise[A](calculation: => A, messageOpt: Opt[Popup])(implicit e: ExecutionContext) extends Util.Future.Z.Control[A] with Runnable {

  override val future = new Future {
    override def onComplete(f: Out[A] => Unit)(implicit e: ExecutionContext) = super.onComplete(f)(Thread.Executor)
  }

  var done = false

  messageOpt(m => {
    def show = { m.show; future.onComplete(_ => m.hide)(e) }
    if (m.delay.isVoid) Thread.run(show)
    else Thread.runIn(m.delay, if (!done) show)
  })

  def run = {
    val v = calculation
    done = true
    complete(v)
  }

  e.execute(this)
}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
