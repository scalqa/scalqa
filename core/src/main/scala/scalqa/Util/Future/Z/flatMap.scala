package scalqa; package Util; package Future; package Z

private[Future] object flatMap {

  def apply[A, B](f: Future[A], m: A => Future[B])(implicit e: concurrent.ExecutionContext = DEFAULT): Future[B] = {
    val p = new Control[B]

    f.apply(
      v => {
        try {
          val f = m(v)
          val o = f.resultOpt
          if (o) p.complete(o.value)
          else f match {
            case f: Control.Linkable => f.linkTo(p)
            case f                   => f.onComplete(p.complete)
          }
        } catch {
          case scala.util.control.NonFatal(t) => p.complete(t)
        }
      }, dc => {
        p.complete(dc)
      })

    p.future
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
