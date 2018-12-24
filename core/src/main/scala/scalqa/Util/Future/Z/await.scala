package scalqa; package Util; package Future; package Z

private[Future] object await {

  def apply[A](f: Future[A], d: Util.Time.PreciseDuration)(implicit e: concurrent.ExecutionContext): Out[A] = {

    val p = concurrent.Promise[Unit]

    f.onComplete(_ => p.trySuccess(()))

    try {

      concurrent.Await.result(p.future, concurrent.duration.Duration(d.totalNanos.real, concurrent.duration.NANOSECONDS))

      f.resultOpt.value

    } catch {
      case _: concurrent.TimeoutException => Out.make[A](Deficiency.Time("Not enough time: " + d))
      case t: Throwable                   => Out.make[A](Deficiency.Error(t))
    }
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
